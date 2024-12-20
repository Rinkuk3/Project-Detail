package com.td.mbna.msec.midtier.mbcca.adaptor;

import com.td.api.mbcca.response.account.CreditCardAgreement;
import com.td.api.mbcca.response.account.DailyAuthorizationSummary;
import com.td.api.mbcca.response.transactions.authorizations.summary.AuthorizationEvent;
import com.td.api.mbcca.response.transactions.postedevents.PostedEvent;
import com.td.mbna.msec.midtier.types.common.AcctOverviewType;
import com.td.mbna.msec.midtier.types.common.AcctSnapshotType;
import com.td.mbna.msec.midtier.types.common.OfferParamsType;
import com.td.mbna.msec.midtier.types.common.StmtActivityType;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TdCardTxAdaptor {

    private static MbnaLogger logger = new MbnaLogger(TdCardTxAdaptor.class);

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static final String CURRENCY_CAD = "CAD";
    private static final String TRANSACTION_TEMP = "TEMP";
    private static final String TRANSACTION_DEBIT = "Debit";
    private static final String APPROVED = "Approved";

    public List<StmtActivityType> convertFromPostedEventToStmtActivity(List<PostedEvent> postedEvents) {

        List<StmtActivityType> stmtActivityTypeList = new ArrayList<>();

        StmtActivityType stmtActivityType = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

        for(PostedEvent aPostedEvent : postedEvents) {

            stmtActivityType = new StmtActivityType();

            stmtActivityType.setAcctId(aPostedEvent.getCardNum());

            //2019-12-12~2019-12-17~1603492
            String eventId = aPostedEvent.getEventId();
            String[] transactionDates = eventId.split("~");


            try {
                stmtActivityType.setPostingDate(dateFormat.parse(transactionDates[1]).getTime());

                stmtActivityType.setTransactionDate(dateFormat.parse(aPostedEvent.getTransactionDt()).getTime());
            } catch (Exception e) {
                logger.error("TdCardTxAdaptor:convertFromPostedEventToStmtActivity. EventId ="+eventId,e.getLocalizedMessage(),e);
                throw ExceptionUtil.genRuntimeException(e);
            }

            stmtActivityType.setPostingTime(transactionDates[2]);
            stmtActivityType.setStatementDataDt(aPostedEvent.getStatementDataDt());

            stmtActivityType.setAmount(aPostedEvent.getAmt());

            stmtActivityType.setTransactionType(aPostedEvent.getDebitCreditCd());
            stmtActivityType.setTransactionCode(aPostedEvent.getActivityTypeDesc());
            stmtActivityType.setDescription(aPostedEvent.getEventDescriptionTxt());
            stmtActivityType.setMerchantName(aPostedEvent.getMerchantInfo().getName());
            stmtActivityType.setMerchantCity(aPostedEvent.getMerchantInfo().getCity());

            //Currency Code is missing in API and since MBNA transactions are in CAD, setting it to CAD.
            stmtActivityType.setCurrencyCode(CURRENCY_CAD);

            stmtActivityType.setReferenceNumber(aPostedEvent.getAcquirerReferenceNum() != null ? aPostedEvent.getAcquirerReferenceNum() : "");
            stmtActivityType.setIpEligibility( (StringUtils.isBlank(aPostedEvent.getTargetedPromotionIndicatorCd()) ||  (!StringUtils.isBlank(aPostedEvent.getTargetedPromotionIndicatorCd()) && (aPostedEvent.getTargetedPromotionIndicatorCd().equalsIgnoreCase("N") ||  aPostedEvent.getTargetedPromotionIndicatorCd().equalsIgnoreCase("T"))) ) ? false : true);

            stmtActivityTypeList.add(stmtActivityType);
        }


        return stmtActivityTypeList;

    }

    public AcctSnapshotType convertToAccountSnapshot( CreditCardAgreement creditCardAgreement) {

        AcctSnapshotType acctSnapshotType = new AcctSnapshotType();

        if (creditCardAgreement == null) {
            logger.debug("TdCardTxAdaptor:convertToAccountSnapshot creditCardAgreement is null or empty. Nothing to convert.");
            return acctSnapshotType;
        }
        List<DailyAuthorizationSummary> dailyAuthorizationSummaries = creditCardAgreement.getDailyAuthorizationSummary();
        
        
        //if dailyAuthorizationSummarieis is null means, no authorizations happened. it is normal. it is not an error.
        if ( dailyAuthorizationSummaries!= null && dailyAuthorizationSummaries.size() > 0) {
        	acctSnapshotType.setTemporaryAuthorizationsToday(creditCardAgreement.getDailyAuthorizationSummary().get(0).getApprovedCccyamt().getAmount());
        } else {
        	acctSnapshotType.setTemporaryAuthorizationsToday(BigDecimal.ZERO);
        }
        
        AcctOverviewType acctOverview = new AcctOverviewType();
        OfferParamsType offerParamsType = new OfferParamsType();
        
        
        
        BigDecimal availableCredit  = null;
        
        if (creditCardAgreement.getAvailableBeyondCreditLimitDisplayInd() != null && creditCardAgreement.getAvailableBeyondCreditLimitDisplayInd()) {
        	availableCredit = creditCardAgreement.getAvailableCreditLimitAmt();
        } else {
        	if(creditCardAgreement.getAvailableCreditLimitAmt() != null 
            			&& creditCardAgreement.getAvailableBeyondCreditLimitCccyamt() != null 
            			&& creditCardAgreement.getAvailableBeyondCreditLimitCccyamt().getAmount() != null){
            		availableCredit = creditCardAgreement.getAvailableCreditLimitAmt().subtract(creditCardAgreement.getAvailableBeyondCreditLimitCccyamt().getAmount());
            		
            	}
        }
        
        acctOverview.setCreditAvail(availableCredit);
        
        
        BigDecimal availableCash = null;
        if(creditCardAgreement.getRealTimeAvailableCashAmt() != null && creditCardAgreement.getAvailableBeyondCashLimitCccyamt() != null){
        	BigDecimal aval = creditCardAgreement.getRealTimeAvailableCashAmt() == null ? BigDecimal.ZERO : creditCardAgreement.getRealTimeAvailableCashAmt();
        	BigDecimal lmt = creditCardAgreement.getAvailableBeyondCashLimitCccyamt().getAmount() == null ? BigDecimal.ZERO : creditCardAgreement.getAvailableBeyondCashLimitCccyamt().getAmount();
        	availableCash = aval.subtract(lmt);
        }
        
        acctOverview.setCashAdvanceAvail(availableCash);
        
        offerParamsType.setCashAdvanceAvailable(creditCardAgreement.getRealTimeAvailableCashAmt());
        if(creditCardAgreement.getAvailableBeyondCreditLimitCccyamt() != null){
        	offerParamsType.setMoneyPadAmount(creditCardAgreement.getAvailableBeyondCreditLimitCccyamt().getAmount());
        }
        
        acctOverview.setOffersParams(offerParamsType);
        
        
        acctSnapshotType.setAcctOverview(acctOverview);
        
        acctSnapshotType.setPastDueAmount(creditCardAgreement.getPastDueAmt());

        return acctSnapshotType;
    }

    public List<StmtActivityType> convertFromAuthEventsToStmtActivity(List<AuthorizationEvent> authorizationEvents) {

        List<StmtActivityType> stmtActivityTypeList = new ArrayList<>();


        if (authorizationEvents != null && authorizationEvents.size() > 0) {
            StmtActivityType stmtActivityType = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

            for (AuthorizationEvent authorizationEvent : authorizationEvents) {

                //include temp transaction with only approved status
                if (authorizationEvent.getAuthorizationResponseCd() != null && authorizationEvent.getAuthorizationResponseCd().equalsIgnoreCase(APPROVED)) {
                    stmtActivityType = new StmtActivityType();

                    //2019-12-12~2019-12-17~1603492
                    String eventId = authorizationEvent.getEventId();
                    String[] transactionDates = eventId.split("~");

                    stmtActivityType.setAcctId(authorizationEvent.getOriginalCardNum());

                    try {
                        stmtActivityType.setTransactionDate(dateFormat.parse(transactionDates[0]).getTime());
                    } catch (Exception e) {
                        logger.error("TdCardTxAdaptor:convertFromAuthEventsToStmtActivity", "eventId=" + eventId, e);
                        throw ExceptionUtil.genRuntimeException(e);
                    }

                    //this is hard-coded  and will always be debit.
                    stmtActivityType.setTransactionType(TRANSACTION_DEBIT);
                    //this is hard-coded and will always be TEMP
                    stmtActivityType.setReferenceNumber(TRANSACTION_TEMP);
                    //this is hard-coded and always be CAD.
                    stmtActivityType.setCurrencyCode(CURRENCY_CAD);

                    stmtActivityType.setAmount(authorizationEvent.getAmt());

                    stmtActivityType.setMerchantName(authorizationEvent.getTransactionSourceDesc());
                    stmtActivityType.setDescription(authorizationEvent.getMerchantInfo().getName());
                    stmtActivityType.setIpEligibility(false);

                    stmtActivityTypeList.add(stmtActivityType);
                }

            }
        } else {
            logger.debug("TdCardTxAdaptor:convertFromAuthEventsToStmtActivity authorizationEvents is null or empty. Nothing to convert.");
        }

        return stmtActivityTypeList;
    }


}
