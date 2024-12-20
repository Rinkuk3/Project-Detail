package com.td.mbna.msec.midtier.ofm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.cache.DisclosureServiceCommand;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsRequest;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.GetEntitlementFlagsResponse;
import com.td.mbna.msec.midtier.eligibility.payload.getentitlementflags.ResponsePayload;
import com.td.mbna.msec.midtier.ofm.MbnaOfm;
import com.td.mbna.msec.midtier.persistance.entity.Customers;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.tdwsservices.TDwsServiceUtil;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.CustAcctType;
import com.td.mbna.msec.midtier.types.common.EligIdType;
import com.td.mbna.msec.midtier.types.eligibility.AcctEligType;
import com.td.mbna.msec.midtier.types.eligibility.CustEligType;
import com.td.mbna.msec.midtier.types.eligibility.EligType;
import com.td.mbna.msec.midtier.util.BackEndSrvcUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.JaxbUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.ParallelServiceCaller;
import com.td.mbna.msec.midtier.util.ServiceCall;

@Component
public class OfmEligibilityUtil {
    public final static String DEFAULT_PRODUCT_CODES = "DEFAULT";
    private static final MbnaLogger logger = new MbnaLogger(OfmEligibilityUtil.class);

    private final static int FIRST_TIME_LOGIN_EAA = 1;
    private final static int NEW_EAA_PUBLISHED = 2;
    private final static int EAA_UPTODATE = 3;
    private final static String TdOp_searchAgreement = "searchAgreement";

    @Autowired
    private MbnaOfm mbnaOfm;

    public GetEntitlementFlagsResponse getGetEntitlementFlagsResponse(final BaseRequest request, String cardNumber, String acctNum, boolean isPrimary, String productCodes, boolean chatEligibility, String token) {
        return mbnaOfm.retrieveEligibility(buildGetEntitlementFlagsRequest(request, cardNumber, acctNum, isPrimary), chatEligibility, token);
    }
    public void scheduleCalls(final BaseRequest request, List<CustAcctType> custAccts, ParallelServiceCaller parallelCaller, String token) throws Exception {

        for (final CustAcctType custAcct : custAccts) {
            final String acctNum = custAcct.getAcctNum();
            ServiceCall<GetEntitlementFlagsResponse> rtrEligCall = new ServiceCall<GetEntitlementFlagsResponse>() {
                @Override
                public GetEntitlementFlagsResponse invoke() {
//                	boolean isChat = DBService.getChatEligibility(custAcct.getProductCodes(), custAcct.getArqCode());
                	boolean isChat = DBMybatisService.getChatEligibility(custAcct.getProductCodes(), custAcct.getArqCode());
                    return getGetEntitlementFlagsResponse(request, custAcct.getCardNum(), acctNum, custAcct.getCardHolder().isPrimaryUser(), custAcct.getProductCodes(), isChat, token);
                }
            };
            parallelCaller.scheduleCall(acctNum, rtrEligCall);

        }
    }

    public GetEntitlementFlagsResponse getResult(BaseRequest request, List<CustAcctType> custAccts, ParallelServiceCaller parallelCaller, String token) throws Exception {
        GetEntitlementFlagsResponse allResponse = new GetEntitlementFlagsResponse();
        ResponsePayload payload = new ResponsePayload();

        allResponse.setResponsePayload(payload);
        CustEligType custElig = new CustEligType();
        custElig.setCustId(request.getCustId());
        payload.setCustElig(custElig);

        if (custAccts == null){
        	return allResponse;
        }

        // Call the TD AccessControlEligibilityService operation once for each account;
        for (CustAcctType custAcct : custAccts) {
        	if(custAcct == null){
        		continue;
        	}
        	GetEntitlementFlagsResponse response = getAcctEntitlementFlags(request, custAcct, parallelCaller, token);
        	if(response == null ||response.getResponsePayload() == null ||response.getResponsePayload().getCustElig() == null ||response.getResponsePayload().getCustElig().getAcctsElig() == null ){
        		continue;
        	}
        	for (AcctEligType acctEligType : response.getResponsePayload().getCustElig().getAcctsElig()) {
        		acctEligType.setAcctId(custAcct.getAcctNum());
        	}
        	consolidateEligibility(payload.getCustElig(), response.getResponsePayload().getCustElig());
        }
        
        
		try {
			addEAAElig(request, allResponse.getResponsePayload().getCustElig());

		} catch (Exception e) {
			logger.error("getResult", e.getMessage(), e);
			throw ExceptionUtil.genRuntimeException(e);
		}
        return allResponse;

    }

    private GetEntitlementFlagsResponse getAcctEntitlementFlags(BaseRequest request, CustAcctType custAcct, ParallelServiceCaller parallelCaller, String token) {
        String acctNum = custAcct.getAcctNum();
        // invoke call to back end
        GetEntitlementFlagsResponse response;

        if (parallelCaller == null) {
//        	boolean isChat = DBService.getChatEligibility(custAcct.getProductCodes(), custAcct.getArqCode());
        	boolean isChat = DBMybatisService.getChatEligibility(custAcct.getProductCodes(), custAcct.getArqCode());
            response = getGetEntitlementFlagsResponse(request, custAcct.getCardNum(), acctNum, custAcct.getCardHolder().isPrimaryUser(), custAcct.getProductCodes(), isChat, token);
        } else {
            response = parallelCaller.getResponse(acctNum, GetEntitlementFlagsResponse.class);
        }
        refineResponse(response, custAcct.getCardHolder().isPrimaryUser());
        return response;
    }

    private void refineResponse(GetEntitlementFlagsResponse response, boolean isPrimary) {
    	if(response == null 
    			|| response.getResponsePayload() == null 
    			|| response.getResponsePayload().getCustElig() == null 
    			|| response.getResponsePayload().getCustElig().getAcctsElig() == null 
    			|| response.getResponsePayload().getCustElig().getAcctsElig().isEmpty()){
    		return;
    	}
        AcctEligType acctsElig = response.getResponsePayload().getCustElig().getAcctsElig().get(0);
        List<EligType> eligList = acctsElig.getAcctElig();

        // Add HardCopy and paper eligibility
        boolean hardCopyStatementsEligPresent = false;
        boolean paperStatementsEligPresent = false;
        boolean transferToChequingEligPresent = false;
        EligType orderAccessElig = null;
        EligType banlanceTransferElig = null;
        for (EligType elig : eligList) {
        	if(elig == null){
        		continue;
        	}
            if (elig.getEligId() != null) {
                if (elig.getEligId().equals(EligIdType.HARDCOPY_STATEMENTS)) {
                    hardCopyStatementsEligPresent = true;
                }
                if (elig.getEligId().equals(EligIdType.PAPER_STATEMENTS)) {
                    paperStatementsEligPresent = true;
                }
                if (elig.getEligId().equals(EligIdType.TRANSFER_TO_CHEQUING)) {
                    transferToChequingEligPresent = true;
                }
                if (elig.getEligId().equals(EligIdType.ORDER_ACCESS_CHEQUE)) {
                    orderAccessElig = elig;
                }
                if (elig.getEligId().equals(EligIdType.BALANCE_TRANSFER)) {
                    banlanceTransferElig = elig;
                }
            }
        }
        Boolean cardHolderIsPch = isPrimary;
        if (!hardCopyStatementsEligPresent) {
            EligType elig = new EligType();
            elig.setEligId(EligIdType.HARDCOPY_STATEMENTS);
            elig.setEligValue(cardHolderIsPch);
            eligList.add(elig);
        }
        if (!paperStatementsEligPresent) {
            EligType elig = new EligType();
            elig.setEligId(EligIdType.PAPER_STATEMENTS);
            elig.setEligValue(cardHolderIsPch);
            eligList.add(elig);
        }
        if (!transferToChequingEligPresent) {
            EligType elig = new EligType();
            elig.setEligId(EligIdType.TRANSFER_TO_CHEQUING);
            if (banlanceTransferElig != null) {
                elig.setEligValue(banlanceTransferElig.isEligValue());
            } else {
                elig.setEligValue(false);
            }
            eligList.add(elig);

        }

        // PCR 56 only primary to requestAccessCheques approved else set to false
        if (orderAccessElig != null && !cardHolderIsPch) {
            orderAccessElig.setEligValue(false);
        }
    }


    private void consolidateEligibility(CustEligType totalEligibility, CustEligType newEligibility) {
        for (AcctEligType acctElig : newEligibility.getAcctsElig()) {
            // Check whether the account has already existed
            boolean exist = false;
            for (AcctEligType existElig : totalEligibility.getAcctsElig()) {
            	if(existElig == null){
            		continue;
            	}
                if (existElig.getAcctId().equals(acctElig.getAcctId())) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                totalEligibility.getAcctsElig().add(acctElig);
            }
        }
    }

    public void checkCardServiceAndUpdate(CustEligType custElig, String acctNum, boolean cardServiceOk) {
        // CardService.retrieveCardAccountInfo is not available, turned off the following Eligibility Flags
        // Card_Activation, Transfer_to_Chequing, PIN_Management
        // because these operations would fail if the user tries to access them from the UI
        if (cardServiceOk) {
        	return;
        }
        for (AcctEligType acctElig : custElig.getAcctsElig()) {
        	if(acctElig == null){
        		continue;
        	}
        	if (acctElig.getAcctId().equals(acctNum)) {
        		for (EligType elig : acctElig.getAcctElig()) {
        			EligIdType eligId = elig.getEligId();
        			if (eligId != null) {
        				elig.setEligValue(eligId != EligIdType.CARD_ACTIVATION && eligId != EligIdType.TRANSFER_TO_CHEQUING && eligId != EligIdType.PIN_MANAGEMENT);
        			}
        		}
        	}
        }
    }

    public void disableBT(CustEligType custElig, String acctNum) {
        // Turn off Balance_Transfer and Transfer_to_Chequing eligibility.
        // This is needed, e.g., when no matching txn fee table entry is found for the account
        for (AcctEligType acctElig : custElig.getAcctsElig()) {
        	if(acctElig == null){
        		continue;
        	}
            if (acctElig.getAcctId().equals(acctNum)) {
                for (EligType elig : acctElig.getAcctElig()) {
                	if(elig == null){
                		continue;
                	}
                    EligIdType eligId = elig.getEligId();
                    if (eligId != null) {
                        if (eligId.equals(EligIdType.BALANCE_TRANSFER)) {
                            elig.setEligValue(false);
                            logger.warning("BT disabled due to no matching txt fee entry");
                        } else if (eligId.equals(EligIdType.TRANSFER_TO_CHEQUING)) {
                            elig.setEligValue(false);
                            logger.warning("TTC disabled due to no matching txt fee entry");
                        }
                    }
                }
            }
        }
    }


    private void addEAAElig(BaseRequest request, CustEligType custElig) throws Exception {
        int eaaStatus = getEAAFlag(request);
        EligType eaaElig = new EligType();
        switch (eaaStatus) {
            case NEW_EAA_PUBLISHED:
                eaaElig.setEligId(EligIdType.ELECTRONIC_ACCESS_AGREEMENT);
                eaaElig.setEligValue(true);
                break;
            case EAA_UPTODATE:
                eaaElig.setEligId(EligIdType.ELECTRONIC_ACCESS_AGREEMENT);
                eaaElig.setEligValue(false);
                break;
            case FIRST_TIME_LOGIN_EAA:
                eaaElig.setEligId(EligIdType.ELECTRONIC_ACCESS_AGREEMENT_FIRST_TIME);
                eaaElig.setEligValue(true);
                break;
            default:
                throw new IllegalAccessException("Invalid EAA popup reason.");
        }
        custElig.getCustElig().add(eaaElig);
    }
   
    private int getEAAFlag(BaseRequest request) {
        // first, we need to get the published date of the latest EAA - call getDisclosure (TD's assembleDisclosure) for that
        logger.debug("retrive published date from DisclosureService for " + request.getSessionInfo().getLoginId());
        Date publishedDate;
        try {
        	String loginId = request.getSessionInfo().getLoginId();
        	loginId = loginId == null?request.getSessionInfo().getConnectId():loginId;
            publishedDate = DisclosureServiceCommand.getPublishedDT(request.getLanguagePref(), loginId);
        } catch (Exception e) {
            logger.error("getEAAFlag", e.getMessage(), e);
            throw com.td.mbna.msec.midtier.util.ExceptionUtil.genRuntimeException(e);
        }

        // second, try to get the published date of the accepted EAA from database
        logger.debug("retrive published date from DB for " + request.getCustId());
        Date publishedDateAccepted = null;
//        Collection<Customers> customers = DBService.findCustomersByCustomerId(request.getCustId());
        List<Customers> customers = DBMybatisService.findCustomersByCustomerId(request.getCustId());
        if(customers == null){
        	logger.error("getEAAFlag: customers is null of id="+request.getCustId());
            throw com.td.mbna.msec.midtier.util.ExceptionUtil.genBusinessException("getEAAFlag: customers is null of id="+request.getCustId());
        }
        for (Customers cus : customers) {
        	if(cus == null){
        		continue;
        	}
            publishedDateAccepted = cus.getEAAPublishedDateAccepted();
        }

        // if the published date of the accepted EAA exists in the database, compare with published date from getDisclosure (only compare day, month, year)
        if (publishedDateAccepted == null) {
        	logger.debug("calling getEAAFromSearchAgreement with " + publishedDate);
        	return getEAAFromSearchAgreement(publishedDate, request);
        }
   
        Calendar calPublishedAccepted = new GregorianCalendar();
        Calendar calPublished = new GregorianCalendar();
        calPublishedAccepted.setTime(publishedDateAccepted);
        calPublished.setTime(publishedDate);
        logger.debug("publishedDateAccepted is " + publishedDateAccepted);
        if (calPublishedAccepted.get(Calendar.YEAR) == calPublished.get(Calendar.YEAR) &&
        		calPublishedAccepted.get(Calendar.MONTH) == calPublished.get(Calendar.MONTH) &&
        		calPublishedAccepted.get(Calendar.DAY_OF_MONTH) == calPublished.get(Calendar.DAY_OF_MONTH)) {
        	logger.debug("EAA_UPTODATE");
        	return EAA_UPTODATE;
        } 
        
        logger.debug("NEW_EAA_PUBLISHED");
        return NEW_EAA_PUBLISHED;
      

    }

   
    private int getEAAFromSearchAgreement(Date publishedDate, BaseRequest request) {
        // call searchAgreement to see if the user has already accepted the latest EAA agreement
        boolean eaaFlag = searchAgreement(request.getCustId(), publishedDate, request.getSessionInfo().getLoginId());

        if (eaaFlag) {
            logger.debug("FIRST_TIME_LOGIN_EAA");
            return FIRST_TIME_LOGIN_EAA;
        }
        // searchAgreement has returned something so that means the user has already accepted the EAA, update local db with this information
        // update database with published date for that customer
        try {
//        	DBService.logEAAPublishedDateAccepted(request.getCustId(), publishedDate);
        	DBMybatisService.logEAAPublishedDateAccepted(request.getCustId(), publishedDate);
        } catch (Exception e) {
        	logger.error("getEAAFromSearchAgreement", e.getMessage(), e);
        	throw com.td.mbna.msec.midtier.util.ExceptionUtil.genRuntimeException(e);
        }
        logger.debug("EAA_UPTODATE");
        return EAA_UPTODATE;
    }

  
    private boolean searchAgreement(String custId, Date publishedDate, String loginId) {

    	String methodName ="OfmEligibilityUtil::searchAgreement";
    	Map<String, Object> paramValues = new HashMap<>();
    	
    	paramValues.put("initiatingPartyID", custId);
    	paramValues.put("financialInstTypeCD", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_CS_CSTAGT_FINANCIAL_INSTITUTION_TYPE_CD));
    	paramValues.put("documentTypeCD", TDwsServiceUtil.getTDServiceParam(TDwsServiceUtil.TD_DSCFG_EAA1));
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    	paramValues.put("publishedDocumentDT", df.format(publishedDate));
    	
    	JAXBContext mtJaxBContext = null;
		try {
			mtJaxBContext = JaxbUtil.getJaxbContext("com.mbnaweb.xsd.msgs.eligibility");
		} catch (JAXBException e) {
			String message = "prepare SOAP service call failed in "+methodName;
			logger.warn(message);
//			throw ExceptionUtil.genBusinessException("no creditCardAgreement content from MBCCA API");
		}
    	
    	
    	com.mbnaweb.xsd.msgs.eligibility.GetEntitlementFlagsResponse response = null;
		try {
			response = (com.mbnaweb.xsd.msgs.eligibility.GetEntitlementFlagsResponse) BackEndSrvcUtil.invokeService(TdOp_searchAgreement, TdOp_searchAgreement,
					loginId, null, null,
					paramValues, paramValues,
					BackEndSrvcUtil.TDOperation.TdCustAgreementService_search,
					mtJaxBContext);
		} catch (Exception e) {
			String message = "CODS SOAP service call failed: custId=" + custId + ",loginId=" + loginId + ",publishedDate=" + publishedDate;
			logger.error(methodName, message,e);
//			throw ExceptionUtil.genBusinessException(message);
		}
		com.mbnaweb.xsd.types.eligibility.EligType eaaFlag =  null;
    	if(response != null && response.getResponsePayload() != null && response.getResponsePayload().getCustElig() != null && response.getResponsePayload().getCustElig().getCustElig() != null  ){
    		eaaFlag = response.getResponsePayload().getCustElig().getCustElig().get(0);
    		
    	}
    	if(eaaFlag == null){
    		return true;
    	}
    	return eaaFlag.isEligValue();
    }

    private GetEntitlementFlagsRequest buildGetEntitlementFlagsRequest(BaseRequest request, String cardNumber, String accountNumber, boolean isPrimary) {
        GetEntitlementFlagsRequest getEntitlementFlagsRequest = new GetEntitlementFlagsRequest();
        getEntitlementFlagsRequest.setAcctNum(accountNumber);
        getEntitlementFlagsRequest.setCardNum(cardNumber);
        getEntitlementFlagsRequest.setCustId(request.getCustId());
        getEntitlementFlagsRequest.getSessionInfo().setConnectId(request.getSessionInfo().getConnectId());
        getEntitlementFlagsRequest.setIsPrimaryUser(isPrimary);
        return getEntitlementFlagsRequest;
    }
    
    public static boolean isAllowed(List<EligType> eligList, EligIdType elig) {
        if (eligList == null){
        	return false;
        }
        for (EligType currElig : eligList) {
        	if(currElig== null){
        		continue;
        	}
            if ((currElig.getEligId() != null) && (currElig.getEligId().equals(elig)))
                return currElig.isEligValue();
        }
        return false;
    }
    public void setMbnaOfm(MbnaOfm mbnaOfm) {
        this.mbnaOfm = mbnaOfm;
    }

}
