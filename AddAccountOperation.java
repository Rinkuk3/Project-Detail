package com.td.mbna.msec.midtier.account;

import com.td.api.enrollment.retrieve.ProductCustomer;
import com.td.api.enrollment.retrieve.Relationship;
import com.td.api.mbcca.response.RetrieveCreditCardAgreementPartyResponse;
import com.td.api.mbna.msec.midtier.mbnaparty.MbnaParty;
import com.td.api.mbna.msec.midtier.mbnaparty.payload.*;
import com.td.api.ofm.common.TCCAAPIAgreementPartyFeature;
import com.td.api.ofm.response.TSvcRetrieveCreditCardAgreementPartyFeatureListRs;
import com.td.mbna.msec.midtier.account.payload.addaccount.VerifyCardDetailsResponse;
import com.td.mbna.msec.midtier.account.payload.addaccount.VerifyCardRequest;
import com.td.mbna.msec.midtier.account.payload.addaccount.VerifyCardResponse;
import com.td.mbna.msec.midtier.cardservice.payload.validatecpi.ValidateCPIResponse;
import com.td.mbna.msec.midtier.enrollment.facade.TdEnrollmentFacade;
import com.td.mbna.msec.midtier.exceptions.BusinessException;
import com.td.mbna.msec.midtier.mbcca.MbnaCCA;
import com.td.mbna.msec.midtier.mbnaad.MbnaAd;
import com.td.mbna.msec.midtier.mbnaad.request.response.accesscard.RetrieveAccessCard;
import com.td.mbna.msec.midtier.ofm.facade.MbnaOfmFacade;
import com.td.mbna.msec.midtier.session.SessionMidProvider;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AddAccountOperation {
    private static MbnaLogger logger = new MbnaLogger(AddAccountOperation.class);
    private static final String MS804 = "MS804";
    private static final String MS803 = "MS803";
    private static final String MS802 = "MS802";
    private static final String MS801 = "MS801";
    private static final String MS279 = "MS279";
    private static final String GENERAL_ERROR = "MS601";
    @Autowired
    private MbnaParty mbnaParty;
    @Autowired
    private MbnaCCA mbnaCCA;
    @Autowired
    private TdEnrollmentFacade tdEnrollmentFacade;
    @Autowired
    private MbnaOfmFacade mbnaOfmFacade;
    @Autowired
    private MbnaAd mbnaAd;
    @Autowired
    private SessionMidProvider sessionProvider;


    public VerifyCardResponse verifyCreditCard(VerifyCardRequest verifyCardRequest, String... token) {
        PartyResponse verifyCardPartyResponse = null;
        VerifyCardResponse response = new VerifyCardResponse();
        String connectId = verifyCardRequest.getSessionInfo().getConnectId();
            ArrayList<CreditCard> creditCardlist = new ArrayList<>();
            try {
                verifyCardPartyResponse = mbnaParty.verifyCreditCardDetails(verifyCardRequest, token[0]);
            } catch (BusinessException exception) {
                if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                    response.setSuccess(false);
                    response.setErrorCode(MS804);
                    logger.error("Mbna Party API call returns error", response.toString());
                    return response;
                }
            }
            if(verifyCardPartyResponse.getResponsePayload()!=null) {
                if (CollectionUtils.isNotEmpty(verifyCardPartyResponse.getResponsePayload().getIndividual())) {
                    verifyCardPartyResponse.getResponsePayload().getIndividual().stream().forEach(individual -> {
                        individual.getIndividualToAgreement().forEach(individualToAgreement -> {
                            individualToAgreement.getCreditCardAgreement().getAgreementToAccessDevice().stream().forEach(agreementToAccessDevice -> {
                                if (agreementToAccessDevice.getCreditCard().getOnCardName() != null) {
                                    creditCardlist.add(agreementToAccessDevice.getCreditCard());
                                }
                            });
                        });
                    });
                    sessionProvider.setSessionAttribute("partyResCacheData", verifyCardPartyResponse);
                    sessionProvider.setSessionAttribute("cardHolderName", verifyCardPartyResponse);
                    List<CreditCard> elements = creditCardlist.stream().
                            filter(creditCard -> creditCard.getCardNum().equalsIgnoreCase(verifyCardRequest.getRequestPayload().getCardNumber()) &&
                                    creditCard.getOnCardName().equalsIgnoreCase(verifyCardRequest.getRequestPayload().getCardholderName())).collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(elements) && elements.size() > 0) {
                        if (elements.get(0).getCardNum() != null) {
                            response = callMbCCA(elements.get(0).getCardNum(), verifyCardRequest.getSessionInfo().getToken(), connectId, verifyCardPartyResponse, response);
                            sessionProvider.setSessionAttribute("cardData", elements.get(0));
                        } else {
                            logger.error("Card Number is NOT matching", response.toString());
                            response.setSuccess(false);
                            response.setErrorCode(MS801);
                        }
                        return response;
                    } else {
                        response.setSuccess(false);
                        response.setErrorCode(MS801);
                    }
                    return response;
                } else {
                    response.setSuccess(false);
                    response.setErrorCode(MS801);
                    logger.error("Mbna Party API call failed due to Invalid/EMPTY response", response.toString());
                }
            }
            else{
                response.setSuccess(false);
                response.setErrorCode(MS804);
                logger.error("Mbna Party API call failed due to Invalid/EMPTY response", response.toString());
            }
            return response;
    }

    private VerifyCardResponse callMbCCA(String cardNum, String token, String connectId, PartyResponse verifyCardPartyResponse, VerifyCardResponse response) {
        RetrieveCreditCardAgreementPartyResponse mbnaCCAResponse = null;
        try {
            mbnaCCAResponse = mbnaCCA.getCreditCardAccountInformation(cardNum, token);
        } catch (BusinessException exception) {
            if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                response.setSuccess(false);
                response.setErrorCode(MS804);
                logger.error("MbCCA API call returns error", response.toString());
                return response;
            }
        }
        if(mbnaCCAResponse.getResPayload() != null) {
            if (mbnaCCAResponse.getResPayload().getCreditCardAgreement()!=null && mbnaCCAResponse.getResPayload().getStatus()) {
                BigDecimal amount= mbnaCCAResponse.getResPayload().getCreditCardAgreement().getLastPaymentAmt();
                Boolean lpa =  (amount!= null) && amount.compareTo(BigDecimal.ZERO) > 0 ? Boolean.TRUE : Boolean.FALSE;
                String accountNumber = mbnaCCAResponse.getResPayload().getCreditCardAgreement().getAltkey().getAccountNum();
                if (mbnaCCAResponse.getResPayload().getCreditCardAgreement().getAltkey().getCardNum().equalsIgnoreCase(cardNum)) {
                    response = callEnrollmentAPI(cardNum, verifyCardPartyResponse, connectId, token, lpa, response, accountNumber);
                    sessionProvider.setSessionAttribute("lpa", lpa);
                    sessionProvider.setSessionAttribute("lastPaymentAmount", amount);
                }
            } else {
                response.setSuccess(false);
                response.setErrorCode(MS801);
                logger.error("MBCCA API call failed", response.toString());
                return response;
            }
        } else {
            response.setSuccess(false);
            response.setErrorCode(MS804);
            logger.error("MBCCA API call failed due to Invalid/EMPTY response", response.toString());
            return response;
        }
        return response;
    }

    private VerifyCardResponse callEnrollmentAPI(String cardNum, PartyResponse verifyCardPartyResponse, String connectId, String token, Boolean lpa, VerifyCardResponse response, String accountNumber) {
        ArrayList<Identification> identificationlist = new ArrayList<>();
        List<ProductCustomer> mbnaEnrollment = null;
        try {
            mbnaEnrollment = tdEnrollmentFacade.retrieveMbnaEnrollments(connectId, token);
        } catch (BusinessException exception) {
            if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                response.setSuccess(false);
                response.setErrorCode(MS804);
                logger.error("Enrollment API call returns error", response.toString());
                return response;
            }
        }
        verifyCardPartyResponse.getResponsePayload().getIndividual().stream().forEach(individual -> {
            individual.getIdentification().forEach(identification -> {
                if (identification != null && "CODS-ID".equalsIgnoreCase(identification.getTypeCd())) {
                    identificationlist.add(identification);
                }
            });
        });
        List<ProductCustomer> productCustomerList;
        List<Relationship> relationships;

        Set<String> identityNumbers = identificationlist.stream().map(Identification::getIdentificationNum).collect(Collectors.toSet());
        relationships = mbnaEnrollment.stream().
                flatMap(rel -> rel.getRelationship().stream()).
                filter(val -> identityNumbers.contains(val.getRelationshipVal())).collect(Collectors.toList());

        productCustomerList = mbnaEnrollment.stream().filter(productCustomer -> (productCustomer.getProductVal().equals(accountNumber))).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(relationships)) {
            if (CollectionUtils.isEmpty(productCustomerList)) {
                String partyId = relationships.get(0).getRelationshipVal();
                sessionProvider.setSessionAttribute("partyId", partyId);
                sessionProvider.setSessionAttribute("accountNumber", accountNumber);
                logger.debug("AddAccountOperation::callEnrollmentAPI::partyId=" + partyId);
                response = callOFMAPI(cardNum, connectId, partyId, token, lpa, response);
            } else {
                response.setSuccess(false);
                response.setErrorCode(MS802);
                logger.error("CODS_ID(Party),ReleationshipVal(EnrollmentAPI) and MBCCA data NOT matching", response.toString());
                return response;
            }
        } else {
            response.setSuccess(false);
            response.setErrorCode(MS801);
            logger.error("CODS_ID(Party) and ReleationshipVal(EnrollmentAPI) data NOT matching", response.toString());
            return response;
        }
        return response;
    }

    private VerifyCardResponse callOFMAPI(String cardNumber, String connectId, String partyId, String token, Boolean lpa, VerifyCardResponse response) {
        Boolean eligibleInd = Boolean.FALSE;
        // FOR NEGATIVE SCENARIO we are catch business exception to meet acceptance criteria .
        Optional<Boolean> eligibleIndicator = Optional.of(Boolean.FALSE);
        try {
            TSvcRetrieveCreditCardAgreementPartyFeatureListRs agreementPartyFeatureListRs = mbnaOfmFacade.retrieveFeaturesList(connectId, cardNumber, partyId, token);
            List<TCCAAPIAgreementPartyFeature> featureList = agreementPartyFeatureListRs.getAgreementPartyFeature();
            eligibleIndicator = featureList.stream().filter(feature -> ("Enrollment".equals(feature.getFeature().getFeatureName())) && (("ENROLLMENT").equals(feature.getFeature().getFeatureId()))).map(TCCAAPIAgreementPartyFeature::getEligibleInd).findAny();

        } catch (BusinessException exception) {
            if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                response.setSuccess(false);
                response.setErrorCode(MS804);
                return response;
            }
        }
        if (eligibleIndicator.isPresent()) {
            eligibleInd = eligibleIndicator.get();
        }

        if (Boolean.TRUE.equals(eligibleInd)) {
            response.setSuccess(true);
            response.setLpa(lpa);
        } else {
            response.setSuccess(false);
            response.setErrorCode(MS803);
            logger.error("eligibleInd failed from OFM API", response.toString());
            return response;
        }
        return response;
    }

    public VerifyCardDetailsResponse verifyCreditCardDetails(VerifyCardRequest req, String[] token) {
        String connectId = req.getSessionInfo().getConnectId();
        CreditCard creditCard = (CreditCard) sessionProvider.getSessionAttribute("cardData");
        String expiryDate[] = req.getRequestPayload().getCardExpiryDt().split("-");
        String expiryYm = expiryDate[0] + expiryDate[1];
        VerifyCardDetailsResponse response = new VerifyCardDetailsResponse();
        ValidateCPIResponse cardVerificationResponse = mbnaAd.cardCVCVerification(connectId, creditCard.getCardNum(), req.getRequestPayload().getCvc(), expiryYm, token[0]);
        if(cardVerificationResponse.getResponsePayload() != null) {
            if (cardVerificationResponse.getResponsePayload().isStatus()) {
                RetrieveAccessCard retrieveAccessCard = null;
                try {
                    retrieveAccessCard = mbnaAd.retrieveAccessCard(connectId, creditCard.getCardNum(), token[0]);
                } catch (BusinessException exception) {
                    if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                        response.setSuccess(false);
                        response.setErrorCode(MS804);
                        return response;
                    }
                }
                if (retrieveAccessCard != null) {
                    String expiryYMD[] = retrieveAccessCard.getCard().getCardExpiration().getExpirationYm().split("-");
                    if (retrieveAccessCard.getCard().getCardNum().equalsIgnoreCase(creditCard.getCardNum()) &&
                            retrieveAccessCard.getCard().getOnCardName().equalsIgnoreCase(creditCard.getOnCardName()) &&
                            (expiryYMD[0] + expiryYMD[1]).equalsIgnoreCase(expiryYm)) {

                        PartyResponse partyResponse;
                        ArrayList<String> identificationMMList = new ArrayList<>();
                        ArrayList<String> contactList = new ArrayList<>();
                        ArrayList<String> roleList = new ArrayList<>();
                        Boolean lpa = (Boolean) sessionProvider.getSessionAttribute("lpa");
                        BigDecimal lastPaymentAmount = (BigDecimal) sessionProvider.getSessionAttribute("lastPaymentAmount");
                        partyResponse = (PartyResponse) sessionProvider.getSessionAttribute("partyResCacheData");
                        Set<String> dOBs = partyResponse.getResponsePayload().getIndividual().stream().map(Individual::getBirthDt).collect(Collectors.toSet());

                        partyResponse.getResponsePayload().getIndividual().stream().forEach(individual -> {
                            individual.getIndividualToAgreement().forEach(individualToAgreement -> {
                                individualToAgreement.getCreditCardAgreement().getAgreementToAccessDevice().stream().forEach(agreementToAccessDevice -> {
                                    if (agreementToAccessDevice.getCreditCard().getCardNum().equalsIgnoreCase(creditCard.getCardNum()) &&
                                            agreementToAccessDevice.getCreditCard().getOnCardName().equalsIgnoreCase(creditCard.getOnCardName())) {
                                        individualToAgreement.getRole().stream().forEach(role -> {
                                                roleList.add(role.getKey());
                                        });
                                        individual.getIdentification().forEach(identification -> {
                                            if (identification != null && "MOTHER-MAIDEN-NAME".equalsIgnoreCase(identification.getTypeCd())) {
                                                identificationMMList.add(identification.getIdentificationNum());
                                            }
                                        });
                                    }
                                });
                            });
                        });
                        try{
                            if(!CollectionUtils.isEmpty(roleList)){
                                Optional<String> roleID= roleList.stream().findFirst();
                                ContactResponse contactsRes= mbnaParty.getContactDetails(roleID.get(),token[0]);
                                if(contactsRes.getResponsePayloadContact()!=null && contactsRes.getStatus()){
                                    contactsRes.getResponsePayloadContact().getContact().forEach(contact -> {
                                        if (contact.getLocator().getTelephoneNumber() != null) {
                                            contactList.add(contact.getLocator().getTelephoneNumber().getTelephoneNum().split("-")[1]);
                                        }
                                    });
                                }
                            }
                        }catch (BusinessException exception) {
                            if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                                response.setSuccess(false);
                                response.setErrorCode(MS804);
                                logger.error("Mbna Party API call returns error", response.toString());
                                return response;
                            }
                        }


                        if (lpa ?(prepareMatchedCount(identificationMMList, dOBs, contactList, lastPaymentAmount, req) >= 3):(prepareMatchedCount(identificationMMList, dOBs, contactList, lastPaymentAmount, req) >=2)) {
                            String status = null;
                            try {
                                status = tdEnrollmentFacade.enroll(connectId, (String) sessionProvider.getSessionAttribute("partyId"), (String) sessionProvider.getSessionAttribute("accountNumber"), token[0]);
                            } catch (BusinessException exception) {
                                if (exception.getFaultInfo().getErrorCode().contains(MS804)) {
                                    response.setSuccess(false);
                                    response.setErrorCode(MS804);
                                    return response;
                                }
                            }
                            if (status.equalsIgnoreCase(String.valueOf(HttpStatus.CREATED))) {
                                response.setSuccess(true);
                            }
                        } else {
                            response.setSuccess(false);
                            response.setErrorCode(MS801);
                            logger.error("Minimum Matching fields criteria NOT met", response.toString());
                            return response;
                        }
                    } else {
                        response.setSuccess(false);
                        response.setErrorCode(MS279);
                        logger.error("call MBADA API for Expiry Date Validation failed", response.toString());
                        return response;
                    }
                } else {
                    response.setSuccess(false);
                    response.setErrorCode(MS804);
                    logger.error("MBADA API call failed due to Invalid/Empty response", response.toString());
                    return response;
                }
            } else {
                response.setSuccess(false);
                response.setErrorCode(MS279);
                logger.error("callMBADA API for CVC Validation failed", response.toString());
                return response;
            }
        }else {
            response.setSuccess(false);
            response.setErrorCode(MS804);
            logger.error("MBADA API call failed due to Invalid/Empty response", response.toString());
            return response;
        }
        return response;
    }



    private int prepareMatchedCount(ArrayList<String> identificationMMList, Set<String> doBs, ArrayList<String> contactList, BigDecimal lpa, VerifyCardRequest req) {
        ArrayList<Boolean> twoOrThreeMatch = new ArrayList();
        twoOrThreeMatch.add(identificationMMList.stream().anyMatch(req.getRequestPayload().getMotherMaidenName()::equalsIgnoreCase));
        twoOrThreeMatch.add(doBs.contains(req.getRequestPayload().getDateOfBirth()));
        twoOrThreeMatch.add(contactList.contains(req.getRequestPayload().getTelephoneNo().replace("-","")));
        if(req.getRequestPayload().getLastPaymentAmount()!=null){
            twoOrThreeMatch.add(String.valueOf(lpa.compareTo(req.getRequestPayload().getLastPaymentAmount())).equalsIgnoreCase("0") ? Boolean.TRUE : Boolean.FALSE);
        }
        return Math.toIntExact(twoOrThreeMatch.stream().filter(Boolean::booleanValue).count());
    }
}
