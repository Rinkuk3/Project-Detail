package com.td.mbna.msec.midtier.mbcca.adaptor;


import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;


import com.mbnaweb.xsd.msgs.account.GetAccountOverviewsResponse;
import com.mbnaweb.xsd.msgs.statement.GetStatementResponse;
import com.mbnaweb.xsd.types.common.AcctOverviewType;
import com.mbnaweb.xsd.types.common.AcctSnapshotStatusType;
import com.mbnaweb.xsd.types.common.DelinquencyStatusType;
import com.mbnaweb.xsd.types.common.ElectronicBillingEnrollmentStatusType;
import com.mbnaweb.xsd.types.common.InsuredStatusType;
import com.mbnaweb.xsd.types.common.OfferParamsType;
import com.mbnaweb.xsd.types.statement.AvailableStatementListType;
import com.mbnaweb.xsd.types.statement.StatementActivityStatusType;
import com.mbnaweb.xsd.types.statement.StmtOnlineSummaryType;
import com.td.api.mbcca.request.cancelip.AddCreditCardAgreementPostedAdjustmentEventRequest;
import com.td.api.mbcca.request.cancelip.AdjustmentEvent;
import com.td.api.mbcca.request.cancelip.PostedAdjustmentEvent;
import com.td.api.mbcca.response.account.AccountOverview;
import com.td.api.mbcca.response.account.Accountstatus;
import com.td.api.mbcca.response.account.CreditCardAgreement;
import com.td.api.mbcca.response.account.CreditCardAgreementToParty;
import com.td.api.mbcca.response.account.CycleInfo;
import com.td.api.mbcca.response.account.RetailEvent;
import com.td.api.mbcca.response.account.TsysExtension;
import com.td.api.mbcca.response.account.cycledates.RetrieveCreditCardAgreementCycleDateList;
import com.td.api.mbcca.response.account.electronicbilling.ElectronicBillingService;
import com.td.api.mbcca.response.account.featureview.CashAdvanceFeeFeatureGroup;
import com.td.api.mbcca.response.account.featureview.FeatureView;
import com.td.api.mbcca.response.account.featureview.TermBalance;
import com.td.api.mbcca.response.insurance.InsuranceAgreement;
import com.td.api.mbcca.shared.Cccyamt;
import com.td.api.mbcca.shared.MerchantInfo;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.IpPlanDetail;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.IpPlanStatus;
import com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.RetrieveIpPlanListResponse;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.GetAvailableStatementListResponse;
import com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.ResponsePayload;
import com.td.mbna.msec.midtier.types.common.CardType;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.TransformUtil;
import com.td.mbna.msec.midtier.util.services.JAXBJsonConverter;

@Component
public class TdCardAcctAdaptor {

    private static MbnaLogger logger = new MbnaLogger(TdCardAcctAdaptor.class);

    private static final String DATE_FORMAT_SLASH = "MM/dd/yyyy";
    private static final String DATE_FORMAT_DASH = "yyyy-MM-dd";
    private static final String TYPCECD_ACTIVITY = "1000";
    private static final String EBILLING_STATUS_ENROLLED = "Active/Currently Enrolled";
    private static final String BT_TERMBALANCE_CD = "0003";
    private static final String PURCHASE_RATE_TERMBALANCE_CD = "0001";
    private static final String BT_SUBJECT_TO_CASHADVANCED_FEE_VALUE = "Balance Transfer Check";
    private static final String BT_INSURANCE_NOT_ENROLLED = "Not Insured";
    private static final String TYPECD_INSTALLMENT = "Installment";

    private static final String GL_CODE_MC = "0290";
    private static final String GL_CODE_VISA = "0291";
    private static final String ADJUSTMENT_TYPECD = "Offset";
    private static final String EVENT_TYPECD = "General Ledger";
    private static final String CURRENC_CODE = "CAD";

    private static final String MERCHANT_INFO = "Installment Plan Fee";
    private static final String ADJUSTMENT_EVENT_TYPECD = "Adjustment";
    private static final String ADJUSTMENT_INITIAL_TYPECD = "Initial";
    private static final String TRANSACTION_LEVEL_PROCESSING_TYPECD = "S";
    private static final String ADJUSTMENT_ACTIVITY_TYPECD = "7121";
    private static final String TX_PROCESSING_FEATURE_ID_PREFIX = "IL";
    private static final String TX_CATEGORY_CD = "0081";
    private static final String ACCOUNTING_FUNCTION_CD = "CAJ";


	/**
	 * 
	 * @param accountOverviews
	 * @return
	 */
    public GetAccountOverviewsResponse convertCreditCardAgreementToAccountsOverview(List<AccountOverview> accountOverviews)  {

// <<<<<<< HEAD
    	// logger.logJson(accountOverviews);
    	// GetAccountOverviewsResponse getAccountOverviewsResponse = new GetAccountOverviewsResponse();
    	// if(accountOverviews == null){
    		// String msg = "no accountOverviews content from MBCCA API";
        	// logger.error(msg);
        	// throw ExceptionUtil.genBusinessException("MS601", msg);
// =======
    	String methodName = "TdCardAcctAdaptor::convertCreditCardAgreementToAccountsOverview";
//    	logger.debug("in::convertCreditCardAgreementToAccountsOverview(List<AccountOverview> accountOverviews)::accountOverviews="+new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(accountOverviews));
    	GetAccountOverviewsResponse getAccountOverviewsResponse = new GetAccountOverviewsResponse();
    	if(accountOverviews == null){
    		String message = " no accountOverviews content from MBCCA API in "+methodName;
			logger.warn(message);
			return getAccountOverviewsResponse;
//			throw ExceptionUtil.genBusinessException("MS601", message);
// >>>>>>> 415f5213283766ad8568c312f6e63204fe22456f
    	}
    	
        List<AcctOverviewType> custAccts = new ArrayList<>();
        
        AcctOverviewType acctOverviewType ;
        
        CreditCardAgreement creditCardAgreement = null;
        ElectronicBillingService electronicBillingService = null;
        FeatureView featureView = null;
        List<Accountstatus> accountStatusList = null;
        
        AcctSnapshotStatusType acctSnapshotStatusType;
        List<CreditCardAgreementToParty> creditCardAgreementToPartyList = new ArrayList<>();
        String accountId = null;

        for(AccountOverview anAccountOverview : accountOverviews) {
        	
        	if(anAccountOverview == null){
        		continue;
        	}
        	
        	electronicBillingService = anAccountOverview.getElectronicBillingService();
        	featureView = anAccountOverview.getFeatureView();
        	if(anAccountOverview.getRetrieveCreditCardAgreement() != null){
        		creditCardAgreement = anAccountOverview.getRetrieveCreditCardAgreement().getCreditCardAgreement();
        		accountStatusList = anAccountOverview.getRetrieveCreditCardAgreement().getAccountStatus();
        		creditCardAgreementToPartyList.addAll(anAccountOverview.getRetrieveCreditCardAgreement().getCreditCardAgreementToParty());
        	}
        	InsuranceAgreement insuranceAgreement = anAccountOverview.getInsuranceAgreement();

            acctOverviewType = new AcctOverviewType();
            
			//1.creditCardAgreement
			if(creditCardAgreement == null){
				String message = " no creditCardAgreement content from MBCCA API in "+methodName;
				logger.warn(message);
//				throw ExceptionUtil.genBusinessException("no creditCardAgreement content from MBCCA API");
			}
			if(creditCardAgreement != null){
				acctOverviewType.setIsMultiCard(creditCardAgreement.getMultipleCardsInd() == null ? false : creditCardAgreement.getMultipleCardsInd().booleanValue());
				acctOverviewType.setCurrentBalance(creditCardAgreement.getBalanceAmt());
				acctOverviewType.setCreditLimit(creditCardAgreement.getCreditLimitAmt());
				acctOverviewType.setCashAdvanceLimit(creditCardAgreement.getCashAdvanceLimitAmt());
				acctOverviewType.setPastDueAmount(creditCardAgreement.getPastDueAmt());
				acctOverviewType.setMinPayment(creditCardAgreement.getMinimumTotalPaymentCccyamt() == null? BigDecimal.ZERO: creditCardAgreement.getMinimumTotalPaymentCccyamt().getAmount());
				acctOverviewType.setMinPaymentDueDate(creditCardAgreement.getPaymentDueDt() != null ? JAXBJsonConverter.convert(creditCardAgreement.getPaymentDueDt(),DATE_FORMAT_DASH) : null);
				acctOverviewType.setLastStatementBalance(creditCardAgreement.getPreviousBalanceAmt());
				acctOverviewType.setLastStatementBalanceDate(StringUtils.isNotBlank(creditCardAgreement.getLastBillingCycleDt()) ?  JAXBJsonConverter.convert(creditCardAgreement.getLastBillingCycleDt(),DATE_FORMAT_DASH) : null);
				acctOverviewType.setLastPaymentPosted(creditCardAgreement.getLastPaymentAmt());
				acctOverviewType.setLastPaymentPostedDate(StringUtils.isNotBlank(creditCardAgreement.getLastPaymentDt()) ? JAXBJsonConverter.convert(creditCardAgreement.getLastPaymentDt(),DATE_FORMAT_DASH) : null);
				acctOverviewType.setIsRewardCard(creditCardAgreement.getAgreementLoyaltyInfo().getEnrolledInd());
				acctOverviewType.setAcctOpenDate(JAXBJsonConverter.convert(creditCardAgreement.getOpenDt(),DATE_FORMAT_DASH));
				acctOverviewType.setDelinquencyStatus((creditCardAgreement.getConsecutivePastDueDaysCnt() != null && creditCardAgreement.getConsecutivePastDueDaysCnt() > 0) ?  DelinquencyStatusType.DELINQUENT : DelinquencyStatusType.NOT_DELINQUENT);
				if(creditCardAgreement.getAltkey() != null){
					accountId = creditCardAgreement.getAltkey().getAccountNum();
				}
				acctOverviewType.setAcctNum(accountId);
				
				//populate productCodes
				
				String productCodes = null;
				
				String tsysProductCode = creditCardAgreement.getProductTypeCd();
				String clientProductCode = creditCardAgreement.getAgreementTypeCd();
				String branchCode = creditCardAgreement.getServicingBranchNum();
				
				if (StringUtils.isNotBlank(tsysProductCode) && StringUtils.isNotBlank(clientProductCode) && StringUtils.isNotBlank(branchCode)) {
					productCodes = tsysProductCode +"-"+clientProductCode+"-"+branchCode;
				}
				
				acctOverviewType.setProductCodes(productCodes);
				
				//arqCode
	            String arqCode = null;
	
	            if (creditCardAgreement.getAgreementLoyaltyInfo() != null
	                    && creditCardAgreement.getAgreementLoyaltyInfo().getAccountRewardQualifierInfo() != null
	                    && creditCardAgreement.getAgreementLoyaltyInfo().getAccountRewardQualifierInfo().size() > 0) {
	                arqCode = creditCardAgreement.getAgreementLoyaltyInfo().getAccountRewardQualifierInfo().get(0).getAccountRewardQualifierCd();
	            } else {
	                logger.debug("TdCardAcctADaptor - arqCode is not avilable for accountId="+accountId);
	            }
	
	            acctOverviewType.setArqCode(arqCode);
	
	            //poCode
	            String poCode = "";
	
	            if (creditCardAgreement.getAgreementTSYSExtension() != null && StringUtils.isNotBlank(creditCardAgreement.getAgreementTSYSExtension().getCustomDataField42Cd())) {
	                poCode = creditCardAgreement.getAgreementTSYSExtension().getCustomDataField42Cd().trim();
	            } else {
	                logger.debug("TdCardAcctADaptor - poCode is not available for accountId="+accountId);
	            }
	
	            acctOverviewType.setPoCode(poCode);
	            
				try {
					acctOverviewType.setNextStatementClosingDate(JAXBJsonConverter.convert(TransformUtil.nextDateCycle(creditCardAgreement.getBillingCycleDayOfMonthNum()),DATE_FORMAT_DASH));
				} catch (ParseException e) {
					logger.error("TdCardAcctAdaptor:convertCreditCardAgreementToAccountsOverview","Failed in parsing next statement closing date billingCycleDayOfMonth="+creditCardAgreement.getBillingCycleDayOfMonthNum() +" for accountId="+accountId,e);
				}
			}
			
			
			//2.featureView
			if(featureView != null){
				acctOverviewType.setMembershipFeeDesc(featureView.getMembershipFeeFeatureDesc());
				acctOverviewType.setMembershipFeeFeatureId(featureView.getMembershipFeeFeatureId());
				if(featureView.getTermsFeature() != null){
					for(TermBalance termBalance : featureView.getTermsFeature().getTermBalance()) {
						if (termBalance.getTermBalanceCd().equalsIgnoreCase(BT_TERMBALANCE_CD)) {
							acctOverviewType.setContractRate(termBalance.getEffectiveRate());
							break;
						}
					}
					if(featureView.getTermsFeature().getTermBalance() != null){
						//populate purchase interest rate
						acctOverviewType.setPurchaseRate(featureView.getTermsFeature().getTermBalance().stream().filter( aTermFeature -> aTermFeature.getTermBalanceCd().equalsIgnoreCase(PURCHASE_RATE_TERMBALANCE_CD)).findAny().get().getEffectiveRate());
					}
				}
				

				if(featureView.getCashAdvanceFeeFeatureGroup() != null){
					for(CashAdvanceFeeFeatureGroup cashAdvanceFeeFeatureGroup : featureView.getCashAdvanceFeeFeatureGroup()) {
						if(cashAdvanceFeeFeatureGroup == null ){
							continue;
						}
						if (BT_SUBJECT_TO_CASHADVANCED_FEE_VALUE.equalsIgnoreCase(cashAdvanceFeeFeatureGroup.getSubjectToCashAdvanceFeeTransactionVal())) {
							if(cashAdvanceFeeFeatureGroup.getFeature() != null){
								acctOverviewType.setBtFeeLookupCode(cashAdvanceFeeFeatureGroup.getFeature().getFeatureId());
							}
							break;
						}
					}
				}
	            
			}


			//3. electronicBillingService
            if (electronicBillingService != null) {
                acctOverviewType.setHardCopyStatementCount(electronicBillingService.getStatementCycleCnt() != null ? String.valueOf(electronicBillingService.getStatementCycleCnt()) : "0");
                acctOverviewType.setEBillingStatus((electronicBillingService.getEnrolmentStatusCd() != null && electronicBillingService.getEnrolmentStatusCd().equalsIgnoreCase(EBILLING_STATUS_ENROLLED)) ? ElectronicBillingEnrollmentStatusType.ENROLLED : ElectronicBillingEnrollmentStatusType.OTHERS);
                acctOverviewType.setEnrollmentStatus(electronicBillingService.getEnrolmentStatusCd());
            } else {
                logger.debug("TdCardAcctAdaptor:convertCreditCardAgreementToAccountsOverview - Account not enrolled in E-billing - accountId="+accountId);
                acctOverviewType.setHardCopyStatementCount("");
                acctOverviewType.setEnrollmentStatus("");
                acctOverviewType.setEBillingStatus(ElectronicBillingEnrollmentStatusType.OTHERS);
            }


            //4. accountStatusList
            if(accountStatusList != null){
            	for(Accountstatus accountstatus : accountStatusList) {
            		acctSnapshotStatusType = new AcctSnapshotStatusType();
            		if(accountstatus != null){
            			acctSnapshotStatusType.setAccountStatusCode(accountstatus.getCd());
            			acctSnapshotStatusType.setAccountStatusReason(accountstatus.getReasonCd());
            		}
            		acctOverviewType.getAccountStatus().add(acctSnapshotStatusType);
            	}
            }
            
            //==================

            acctOverviewType.setPointsAvailable(0);
            acctOverviewType.setOffersParams(new OfferParamsType());


            //populate insurance status

            if (insuranceAgreement != null && insuranceAgreement.getProductFeature() != null && insuranceAgreement.getProductFeature().size() > 0) {
                acctOverviewType.setInsuredStatus(InsuredStatusType.OTHER);
            } else {
            	InsuredStatusType insuredStatusType = BT_INSURANCE_NOT_ENROLLED.equalsIgnoreCase(insuranceAgreement != null ? insuranceAgreement.getBalanceProtectionInsuranceCd():"") ? InsuredStatusType.NOT_INSURED : InsuredStatusType.OTHER;
                acctOverviewType.setInsuredStatus(insuredStatusType);
            }

            custAccts.add(acctOverviewType);

        }
        GetAccountOverviewsResponse.ResponsePayload responsePayload = new GetAccountOverviewsResponse.ResponsePayload();
        responsePayload.getCardHolderInfo().addAll(convertCustomerInfoToCardHolderInfo(creditCardAgreementToPartyList));
        responsePayload.getCustAccts().addAll(custAccts);

        
        getAccountOverviewsResponse.setResponsePayload(responsePayload);
// <<<<<<< HEAD
        // logger.logJson(getAccountOverviewsResponse);
// =======
//        logger.debug("out::convertCreditCardAgreementToAccountsOverview(List<AccountOverview> accountOverviews)::getAccountOverviewsResponse="+new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(getAccountOverviewsResponse));
// >>>>>>> 415f5213283766ad8568c312f6e63204fe22456f
        return getAccountOverviewsResponse;
    }

	/**
	 * 
	 * @param customerInfoList
	 * @return
	 */
    public List<GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo> convertCustomerInfoToCardHolderInfo(List<CreditCardAgreementToParty> customerInfoList) {

        List<GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo> cardHolderInfoList = new ArrayList<>();
        GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo cardHolderInfo;


        if (customerInfoList == null || customerInfoList.isEmpty()) {
            logger.warn("TdCArdAcctAdaptor: Customer Information is not returned from MBCCA");
            return cardHolderInfoList;
        }
        for(CreditCardAgreementToParty creditCardAgreementToParty : customerInfoList) {
        	
        	TsysExtension tsysExtension = creditCardAgreementToParty.getTsysExtension();
        	
        	cardHolderInfo = new GetAccountOverviewsResponse.ResponsePayload.CardHolderInfo();
        	cardHolderInfo.setCardNumber(tsysExtension.getCardNum());
        	cardHolderInfo.setCardHolderName(creditCardAgreementToParty.getOnCardName());
        	cardHolderInfo.setCustomerId(tsysExtension.getCustomerId());
        	cardHolderInfoList.add(cardHolderInfo);
        }


        return cardHolderInfoList;
    }

    public GetAvailableStatementListResponse convertCycleDataToAvailableStatementList(RetrieveCreditCardAgreementCycleDateList cycleDateList, List<CycleInfo> cycleInfoList) {

        GetAvailableStatementListResponse getAvailableStatementListResponse = new GetAvailableStatementListResponse();
        getAvailableStatementListResponse.setResponsePayload(new ResponsePayload());

        com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.AvailableStatementListType availableStatementList = new com.td.mbna.msec.midtier.statement.payload.getAvailableStatementList.AvailableStatementListType();

        getAvailableStatementListResponse.getResponsePayload().setAvailableStatementList(availableStatementList);

        List<com.td.mbna.msec.midtier.statement.payload.StatementActivityStatusType> statementActivityStatusTypeList = new ArrayList<>();
        List<String> statementEndDateList = new ArrayList<>();

        availableStatementList.setStatementActivityStatus(statementActivityStatusTypeList);
        availableStatementList.setStatementEndDate(statementEndDateList);
        com.td.mbna.msec.midtier.statement.payload.StatementActivityStatusType statementActivityStatusType;

        if (cycleDateList == null || cycleDateList.getBillingCycleDt() == null || cycleDateList.getBillingCycleDt().isEmpty()) {
            //nothing wrong, there are no statement cycles avaialble
            logger.debug("No Statement Cycles are available");
            return getAvailableStatementListResponse;
        }
        
        for(String cycleDate : cycleDateList.getBillingCycleDt()) {
        	statementEndDateList.add(cycleDate);
        	if(cycleInfoList == null || cycleInfoList.isEmpty()){
        		continue;
        	}
        	for(CycleInfo aCycleInfo : cycleInfoList) {
        		if(aCycleInfo == null || aCycleInfo.getCycleDt() == null){
        			continue;
        		}
        		if (aCycleInfo.getCycleDt().equalsIgnoreCase(cycleDate)) {
        			
        			statementActivityStatusType = new com.td.mbna.msec.midtier.statement.payload.StatementActivityStatusType();
        			
        			if ( (aCycleInfo.getTransactionCategory() == null || aCycleInfo.getTransactionCategory().size() == 0) ||
        					(aCycleInfo.getTransactionCategory() != null && aCycleInfo.getTransactionCategory().size() == 1
        					&& aCycleInfo.getTransactionCategory().get(0).getTypeCd().equalsIgnoreCase(TYPCECD_ACTIVITY)
        					&& aCycleInfo.getTransactionCategory().get(0).getCycleToDateBalanceCccyamt().getAmount().equals(BigDecimal.ZERO))) {
        				statementActivityStatusType.setActivityAvailable(false);
        			} else {
        				statementActivityStatusType.setActivityAvailable(true);
        			}
        			
        			statementActivityStatusType.setStatementEndDate(String.valueOf(JAXBJsonConverter.convertToLong(aCycleInfo.getCycleDt(),DATE_FORMAT_DASH)));
        			statementActivityStatusType.setStatementPaymentDueDate(StringUtils.isNotBlank(aCycleInfo.getPaymentDueDt())  ? String.valueOf(JAXBJsonConverter.convertToLong(aCycleInfo.getPaymentDueDt(),DATE_FORMAT_DASH)) : "");
        			statementActivityStatusType.setStatementBalance(aCycleInfo.getBalanceAmt());
        			statementActivityStatusTypeList.add(statementActivityStatusType);
        			break;
        		}
        		
        	}
        }

        return getAvailableStatementListResponse;

    }

    public GetStatementResponse convertCycleDataToStatementResponse(RetrieveCreditCardAgreementCycleDateList cycleDateList, List<CycleInfo> cycleInfoList) {

        GetStatementResponse getStatementResponse = new GetStatementResponse();

        getStatementResponse.setResponsePayload(new GetStatementResponse.ResponsePayload());

        if (cycleDateList != null) {

            getStatementResponse.getResponsePayload().setAvailableStatementList(new AvailableStatementListType());

            StatementActivityStatusType statementActivityStatusType;
            List<String> billingDtStrs = cycleDateList.getBillingCycleDt();
			if(billingDtStrs != null){
		
				for(String aStatementCycle : billingDtStrs) {
	
	                getStatementResponse.getResponsePayload().getAvailableStatementList().getStatementEndDate().add(JAXBJsonConverter.convert(aStatementCycle,DATE_FORMAT_DASH));
	                if(cycleInfoList == null || cycleInfoList.isEmpty()){
	            		continue;
	            	}
	               for(CycleInfo aCycleInfo : cycleInfoList) {
	
	            	   if(aCycleInfo == null || aCycleInfo.getCycleDt() == null){
	            		   continue;
	            	   }
	                   if (aStatementCycle.equalsIgnoreCase(aCycleInfo.getCycleDt())) {
	                       statementActivityStatusType = new StatementActivityStatusType();
	
	                       if ( (aCycleInfo.getTransactionCategory() == null  || aCycleInfo.getTransactionCategory().size() == 0) ||
	                               (aCycleInfo.getTransactionCategory() != null && aCycleInfo.getTransactionCategory().size() == 1
	                               && aCycleInfo.getTransactionCategory().get(0).getTypeCd().equalsIgnoreCase(TYPCECD_ACTIVITY)
	                               && aCycleInfo.getTransactionCategory().get(0).getCycleToDateBalanceCccyamt().getAmount().equals(BigDecimal.ZERO))) {
	                           statementActivityStatusType.setActivityAvailable(false);
	                       } else {
	                           statementActivityStatusType.setActivityAvailable(true);
	                       }
	
	                       statementActivityStatusType.setStatementEndDate(JAXBJsonConverter.convert(aCycleInfo.getCycleDt(),DATE_FORMAT_DASH));
	                       statementActivityStatusType.setStatementBalance(aCycleInfo.getBalanceAmt());
	                       statementActivityStatusType.setStatementPaymentDueDate(StringUtils.isNotBlank(aCycleInfo.getPaymentDueDt()) ? JAXBJsonConverter.convert(aCycleInfo.getPaymentDueDt(),DATE_FORMAT_DASH) : null);
	
	                       getStatementResponse.getResponsePayload().getAvailableStatementList().getStatementActivityStatus().add(statementActivityStatusType);
	                   }
	               }
	            }
			}
        } else {
            getStatementResponse.getResponsePayload().setAvailableStatementList(null);
        }


        if (cycleInfoList != null && cycleInfoList.size() > 0) {
            StmtOnlineSummaryType stmtOnlineSummaryType = new StmtOnlineSummaryType();

            CycleInfo cycleInfo = cycleInfoList.get(0);

            stmtOnlineSummaryType.setCreditLimit(cycleInfo.getCreditLimitAmt());
            stmtOnlineSummaryType.setCacheAdvanceLimit(cycleInfo.getAvailableCreditLimitAmt());
            stmtOnlineSummaryType.setCreditAvailable(cycleInfo.getAvailableCreditLimitAmt());
            stmtOnlineSummaryType.setCreditAdvanceAvailable(cycleInfo.getAvailableCreditLimitAmt());


            stmtOnlineSummaryType.setStatementClosingDate(JAXBJsonConverter.convert(cycleInfo.getCycleDt(), DATE_FORMAT_DASH));
            stmtOnlineSummaryType.setDaysInBillingCycle(cycleInfo.getCycleDaysCnt());
            stmtOnlineSummaryType.setTotalMinimumPaymentDue(cycleInfo.getMinimumPaymentAmt());
            stmtOnlineSummaryType.setTotalMinimumPaymentDueDate(StringUtils.isNotBlank(cycleInfo.getPaymentDueDt()) ? JAXBJsonConverter.convert(cycleInfo.getPaymentDueDt(), DATE_FORMAT_DASH) : null);

            getStatementResponse.getResponsePayload().setOnlineSummary(stmtOnlineSummaryType);
        } else {
            logger.debug("TdCardAcctAdaptor: There are no cycles to convert.");
        }

        return getStatementResponse;
    }

    public RetrieveIpPlanListResponse convertRetailEventsToIpPlans(List<RetailEvent> retailEventList, String acctNum) {
    	String methodName = "TdCardAcctAdaptor::convertRetailEventsToIpPlans";
    	RetrieveIpPlanListResponse response = new RetrieveIpPlanListResponse();

    	com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.ResponsePayload responsePayload = new com.td.mbna.msec.midtier.account.payload.retrieveipplanlist.ResponsePayload();
        response.setResponsePayload(responsePayload);
    	if (retailEventList == null || retailEventList.isEmpty()){
    		return response;
    	}

    	BigDecimal totalRemainingBalance = BigDecimal.ZERO;
    	for (RetailEvent retailEvent: retailEventList){
    		if (retailEvent == null || retailEvent.getCategoryInfo() == null || !TYPECD_INSTALLMENT.equalsIgnoreCase(retailEvent.getTransactionLevelProcessingTypeCd())){
    			continue;
    		}

    		IpPlanDetail ipPlanDetail = new IpPlanDetail();

    		String[] eventIdDetails = retailEvent.getEventId().split("~");

    		ipPlanDetail.setEventId(retailEvent.getStatementDataDt()+"~"+eventIdDetails[1]+"~"+eventIdDetails[2]);

    		ipPlanDetail.setRemainingBalance(BigDecimal.ZERO);
            if (retailEvent.getOutstandingCccyamt() != null && retailEvent.getOutstandingCccyamt().getAmount() != null){
                ipPlanDetail.setRemainingBalance(retailEvent.getOutstandingCccyamt().getAmount());
            }

    		if (retailEvent.getCategoryInfo().getCptExpiredInd() != null && !retailEvent.getCategoryInfo().getCptExpiredInd()){
    			ipPlanDetail.setStatus(IpPlanStatus.Active);
    			totalRemainingBalance = totalRemainingBalance.add(ipPlanDetail.getRemainingBalance());
    			responsePayload.getActivePlans().add(ipPlanDetail);
    		} else {
    			ipPlanDetail.setStatus(IpPlanStatus.Inactive);
    			ipPlanDetail.setBalanceAtClosure(BigDecimal.ZERO);
    			responsePayload.getInactivePlans().add(ipPlanDetail);
    		}
    		
    		ipPlanDetail.setId(retailEvent.getAcquirerReferenceNum());
    		ipPlanDetail.setPlanName(retailEvent.getMerchantDoingBusinessAsName());
    		ipPlanDetail.setIpPaymentOptionFeatureDt(JAXBJsonConverter.convertDateToString(retailEvent.getEventDttm(),DATE_FORMAT_DASH));
    		
            String strDate = null;
        	
        	SimpleDateFormat slashDateFormat = new SimpleDateFormat(DATE_FORMAT_SLASH);
        	SimpleDateFormat dashDateFormat = new SimpleDateFormat(DATE_FORMAT_DASH);

            if (retailEvent.getEventDttm() != null){
    			strDate = slashDateFormat.format(retailEvent.getEventDttm());
            }
    		ipPlanDetail.setCreatedOn(strDate);
    		
    		long now = new Date().getTime();
			try {
				now = slashDateFormat.parse(slashDateFormat.format(new Date())).getTime();
			} catch (ParseException e) {
				String message = "parsing new Date() failed";
				logger.error(methodName, message,e);
			}
			
    		try {
				strDate = null;
				if (retailEvent.getCategoryInfo().getExpiryDt() != null){
					Date expiryDate = dashDateFormat.parse(retailEvent.getCategoryInfo().getExpiryDt());
					strDate = slashDateFormat.format(expiryDate);
					
					long duration = TimeUnit.DAYS.convert(expiryDate.getTime() - now, TimeUnit.MILLISECONDS);
					if (duration < 3 && IpPlanStatus.Active.equals(ipPlanDetail.getStatus())){
						ipPlanDetail.setStatus(IpPlanStatus.CloseIneligible);
					}
				}
				ipPlanDetail.setExpirationDate(strDate);
			} catch (ParseException e) {
				String message = "parsing expiryDate failed";
				logger.error(methodName, message,e);
			}
    		
    		try {
				strDate = null;
				if (retailEvent.getEventEndDt() != null){
					Date closedDate = dashDateFormat.parse(retailEvent.getEventEndDt());
					strDate = slashDateFormat.format(closedDate);
					
					long duration = TimeUnit.DAYS.convert(closedDate.getTime() - now, TimeUnit.MILLISECONDS);
					if (duration >= 0 && duration < 3 && IpPlanStatus.Active.equals(ipPlanDetail.getStatus())){
						ipPlanDetail.setStatus(IpPlanStatus.RecentlyClosed);
					}
				}
				ipPlanDetail.setClosedOn(strDate);
			} catch (ParseException e) {
				String message = "parsing getEventEndDt failed";
				logger.error(methodName, message,e);
			}
    		
			try {

	            strDate = null;
	            if (retailEvent.getNextPaymentDueDt() != null){
	            	strDate = slashDateFormat.format(dashDateFormat.parse(retailEvent.getNextPaymentDueDt()));
	            }
	            ipPlanDetail.setPaymentDueOn(strDate);
	            
			} catch (ParseException e) {
				logger.error("RetrieveIpPlanListOperation : convertIpPlan", "failed parsing date getNextPaymentDueDt", e);
			} 

            ipPlanDetail.setTimeRemaining(retailEvent.getPaidInFullRemainingPaymentCnt());
            
            ipPlanDetail.setMonthlyPayment(null);
            if (retailEvent.getSpecialProcessingExpiryPayOffCccyamt() != null && retailEvent.getSpecialProcessingExpiryPayOffCccyamt().getAmount() != null){
            	ipPlanDetail.setMonthlyPayment(retailEvent.getSpecialProcessingExpiryPayOffCccyamt().getAmount());
            }

            if (retailEvent.getCategoryInfo().getCptExpirationRemainingBalanceCccyamt() != null && retailEvent.getCategoryInfo().getCptExpirationRemainingBalanceCccyamt().getAmount() != null){
            	ipPlanDetail.setBalanceAtClosure(retailEvent.getCategoryInfo().getCptExpirationRemainingBalanceCccyamt().getAmount());
            }

            if (retailEvent.getPaymentOption() != null && retailEvent.getPaymentOption().getInstalmentFeeCccyamt() != null  && retailEvent.getPaymentOption().getInstalmentFeeCccyamt().getAmount() != null){
            	ipPlanDetail.setOneTimeTransactionFee(retailEvent.getPaymentOption().getInstalmentFeeCccyamt().getAmount());
            }else{
				ipPlanDetail.setOneTimeTransactionFee(BigDecimal.ZERO);
			}
            
            if (retailEvent.getEventTransactionCccyamt() != null && retailEvent.getEventTransactionCccyamt().getAmount() != null){
            	ipPlanDetail.setTransactionAmt(retailEvent.getEventTransactionCccyamt().getAmount());
            }


            //populate fields required for cancellation
            ipPlanDetail.setPostedTime(Integer.valueOf(retailEvent.getPostedTimeVal()));
            ipPlanDetail.setStatementDataDt(retailEvent.getStatementDataDt());

            //need to extract part of string from TranactionLevelProcessingPromotionId
            //ie need to extract IL26 out of LIL2600001
            String txProcessingFtId = retailEvent.getTransactionLevelProcessingPromotionId();
            //int startIndex = txProcessingFtId.indexOf(TX_PROCESSING_FEATURE_ID_PREFIX);
			if(!txProcessingFtId.isEmpty() & txProcessingFtId.length() >= 5){
				ipPlanDetail.setTxLevelProcessingFeatureId(txProcessingFtId.substring(1,5));
			}
    	}
    	
    	responsePayload.setTotalRemainingBalance(totalRemainingBalance);
        return response;
    }


    public AddCreditCardAgreementPostedAdjustmentEventRequest generateRefundRequest(String eventId, BigDecimal feeAmount, String cardNumber, String txLevelProcesingFeatureId, CardType cardType) {

        String retailEventDate = new SimpleDateFormat(DATE_FORMAT_DASH).format(new Date());

        AddCreditCardAgreementPostedAdjustmentEventRequest request = new AddCreditCardAgreementPostedAdjustmentEventRequest();

        PostedAdjustmentEvent postedAdjustmentEvent = new PostedAdjustmentEvent();

        postedAdjustmentEvent.setPostedEventId(eventId);
        List<AdjustmentEvent> adjustmentEventList = new ArrayList<>();

        AdjustmentEvent anAdjustmentEvent = new AdjustmentEvent();
        anAdjustmentEvent.setActivityTypeCd(ADJUSTMENT_ACTIVITY_TYPECD);
        anAdjustmentEvent.setAdjustmentTypeCd(ADJUSTMENT_INITIAL_TYPECD);
        anAdjustmentEvent.setEventTypeCd(ADJUSTMENT_EVENT_TYPECD);
        anAdjustmentEvent.setTransactionLevelProcessingTypeCd(TRANSACTION_LEVEL_PROCESSING_TYPECD);

        anAdjustmentEvent.setTransactionLevelProcessingFeatureId(txLevelProcesingFeatureId);
        anAdjustmentEvent.setRetailEventDt(retailEventDate);
        anAdjustmentEvent.setCardNum(cardNumber);

        Cccyamt transactionCccyamt = new Cccyamt();
        transactionCccyamt.setAmount(feeAmount);
        transactionCccyamt.setCurrencyCd(CURRENC_CODE);

        anAdjustmentEvent.setTransactionCccyamt(transactionCccyamt);

        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setName(MERCHANT_INFO);

        anAdjustmentEvent.setMerchantInfo(merchantInfo);
        anAdjustmentEvent.setAccountingFunctionCd(ACCOUNTING_FUNCTION_CD);
        anAdjustmentEvent.setTransactionCategoryCd(TX_CATEGORY_CD);


        adjustmentEventList.add(anAdjustmentEvent);


        AdjustmentEvent anAdjustmentEvent2 = new AdjustmentEvent();
        anAdjustmentEvent2.setActivityTypeCd( cardType == com.td.mbna.msec.midtier.types.common.CardType.MC ?  GL_CODE_MC : GL_CODE_VISA );

        anAdjustmentEvent2.setAdjustmentTypeCd(ADJUSTMENT_TYPECD);
        anAdjustmentEvent2.setEventTypeCd(EVENT_TYPECD);
        anAdjustmentEvent2.setForcePostInd(true);
        anAdjustmentEvent2.setRetailEventDt(retailEventDate);
        anAdjustmentEvent2.setCardNum(cardNumber);


        Cccyamt transactionCccyamt2 = new Cccyamt();
        transactionCccyamt2.setAmount(feeAmount);
        transactionCccyamt2.setCurrencyCd(CURRENC_CODE);

        anAdjustmentEvent2.setTransactionCccyamt(transactionCccyamt2);

        adjustmentEventList.add(anAdjustmentEvent2);


        postedAdjustmentEvent.setAdjustmentEvent(adjustmentEventList);
        request.setPostedAdjustmentEvent(postedAdjustmentEvent);


        return request;
    }
    
}
