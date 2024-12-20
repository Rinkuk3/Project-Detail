package com.td.mbna.msec.midtier.util.services;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import com.td.mbna.msec.midtier.exception.SystemError;
import com.td.mbna.msec.midtier.persistance.entity.BusinessEvent;
import com.td.mbna.msec.midtier.persistance.entity.BusinessEventAudit;
//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.types.common.BaseRequest;
import com.td.mbna.msec.midtier.types.common.BaseResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;

//import commonj.work.Work;


/**
 * This class initiates the AuditLog properties, creates the BusinessEventAudit object
 * and calls DBMybatsService to insert the object to the database table BusinessEventAudit
 *
 */
public class AuditingServiceWork  {

	// Mask string for card number
	public static final String REDACTED_CARD_MASK = "-XXXX-XXXX-";

	private static MbnaLogger logger = new MbnaLogger(AuditingServiceWork.class);

	private BaseRequest baseRequest;
	private BaseResponse baseResponse;
	private Date startTime;
	private long processingTime;


	private static final Map<String, BusinessEvent> auditLogEventsMap = new ConcurrentHashMap<String, BusinessEvent>();
	static{

		Properties props = null;
		InputStream ist = null;
		try{
			props = new Properties();
			ist = AuditingServiceWork.class.getClassLoader().getResourceAsStream("AuditLogEvents.properties");
			props.load(ist);

			for(Object key : props.keySet()) {

				String eventCode = ((String)key).trim();

				BusinessEvent businessEvent = new BusinessEvent();

				String[] businessEventDetails = props.getProperty(eventCode).split("#");

				businessEvent.setEventCode(eventCode);
				businessEvent.setTransactionType(businessEventDetails[0]);
				businessEvent.setBusinessEventDesc(businessEventDetails[1]);
				businessEvent.setTransactionSubType(businessEventDetails[2]);

				auditLogEventsMap.put(eventCode, businessEvent);
			}
		}
		catch(Throwable ex) {
			logger.error("Could not initialize AuditingService", ex);
		}finally{
			if (props != null) {
				props.clone();
			}
			if(ist != null){
				try {
					ist.close();
				} catch (IOException e) {
					logger.error("AuditingService when closing error ", e);
				}
			}
		}
		logger.debug("EventCodes: " + auditLogEventsMap.keySet());
	}
	public static Map<String, BusinessEvent> getAuditLogEventsMap() {
		return auditLogEventsMap;
	}
	public static void init() { //Used for initialization at server startup
		return;
	}

	/**
	 * Constructor of AuditingServiceWork
	 *
	 * @param baseRequest - this is the application request that needs to be logged to AuditLog
	 * @param baseResponse - this is the application response that needs to be logged to AuditLog
	 * @param startTime - this is the start time of the request to backend
	 * @param processingTime - this is the time taken by the backend to process the request
	 */
	public AuditingServiceWork(BaseRequest baseRequest, BaseResponse baseResponse, Date startTime, long processingTime) {
		this.baseRequest = baseRequest;
		this.baseResponse = baseResponse;
		this.startTime = startTime;
		this.processingTime = processingTime;
	}
	
	/**
	 * Call to create AuditLog that can be executed as a separate thread
	 * 
	 */
	public void run() {
		
		try {
			this.createAuditLog(baseRequest, baseResponse, startTime, processingTime);
		}
		catch(Exception ex) {
			logger.error("Error in AuditingServiceWork", ex); //Don't throw exception since application should still function normally
		}
	}
	
	/**
	 * Contains any clean up code after AuditLog has been created
	 * 
	 */
	public void release() {
        //Nothing to release
	}
	
	/**
	 * Creates AuditLog or saves/updates Customer's Last Login based on the request
	 *
     * @return false which means that this is not run as a daemon thread 
     */
	public boolean isDaemon() {
		return false;
	}

	private void createAuditLog(BaseRequest baseRequest, BaseResponse baseResponse, Date startTime, long processingTime) throws SystemError {
		createAuditLogEntry(baseRequest, baseResponse, startTime, processingTime);

	}
	
	private void createAuditLogEntry(BaseRequest baseRequest, BaseResponse baseResponse, Date startTime, long processingTime) throws SystemError {

		if(baseRequest.getAuditInfo() != null) {

			if ("SS0905".equals(baseRequest.getAuditInfo().getTransactionCode())) {
				if (baseRequest instanceof com.td.mbna.msec.midtier.auditlog.payload.request.CreateAuditLogRequest) {
					com.td.mbna.msec.midtier.auditlog.payload.request.CreateAuditLogRequest creAReq = (com.td.mbna.msec.midtier.auditlog.payload.request.CreateAuditLogRequest)baseRequest;
					if (creAReq.getRequestPayload() != null) {
						createAuditLogEntry(baseRequest, baseResponse, startTime, processingTime, creAReq.getRequestPayload().getBtAmt(), 0);
					}
				}
			}				
			else {
			
				createAuditLogEntry(baseRequest, baseResponse, startTime, processingTime, null, 0);
			}
		}
		else {
			
			logger.info("Skipping AuditLog since request does not contain AuditInfo");
		}
	}
	
	private void createAuditLogEntry(BaseRequest baseRequest, BaseResponse baseResponse, Date startTime, long processingTime, BigDecimal balanceTransferToCreditorAmount, int index) throws SystemError {
			
		if(baseRequest.getAuditInfo() != null) {
		
			BusinessEventAudit businessEventAudit = new BusinessEventAudit();
			
			businessEventAudit.setConnectId(baseRequest.getAuditInfo().getConnectId());
			businessEventAudit.setMdmCifId(baseRequest.getCustId());
			businessEventAudit.setStartDateTime(startTime);
			businessEventAudit.setDeliveryChannelCode("MWB");
			businessEventAudit.setSessionID(baseRequest.getSessionInfo().getSessionId());
			if(baseRequest.getAuditInfo().getTransactionCode() != null) {
				BusinessEvent businessEvent = auditLogEventsMap.get(baseRequest.getAuditInfo().getTransactionCode());
				if(businessEvent != null) {
					businessEventAudit.setEventCode(businessEvent.getEventCode());			
					businessEventAudit.setTransactionType(businessEvent.getTransactionType());
					businessEventAudit.setTransactionSubType(businessEvent.getTransactionSubType());
					businessEventAudit.setBusinessEvent(businessEvent.getBusinessEventDesc(baseRequest.getAuditInfo().getDescription()));
				} else {
					logger.warning(baseRequest.getAuditInfo().getTransactionCode() + " is not defined in AuditLogEvents.properties");
					return;  // don't generate anything
				}
			}
			businessEventAudit.setApplicationLogonID(baseRequest.getSessionInfo().getLoginId());
			businessEventAudit.setProcessingTime(processingTime);
            if (baseResponse != null) {
				businessEventAudit.setApplicationResponseCode(baseResponse.getStatus());
			}
            if(baseRequest.getAuditInfo().getCardEnding() != null) {
            	String cardEnding = baseRequest.getAuditInfo().getCardEnding();
            	String cardStarting = baseRequest.getAuditInfo().getCardStarting();
            	if(cardEnding.length() > 4 && cardStarting.length() > 4) {
            		cardEnding = cardEnding.substring(cardEnding.length() - 4);
            		cardStarting = cardStarting.substring(0,4);
            	}
            	businessEventAudit.setRedactedCardNumber(cardStarting+ REDACTED_CARD_MASK + cardEnding);
            }
			businessEventAudit.setPaaTsysSequence(baseRequest.getAuditInfo().getPaaSequence());
			businessEventAudit.setGroupAffinityCode(baseRequest.getAuditInfo().getGroupAffinityCode());
			businessEventAudit.setAccountStatusCode(baseRequest.getAuditInfo().getAccountStatusCode());
			businessEventAudit.setAccountDelinquencyCode(baseRequest.getAuditInfo().getAccountDelinquencyCode());
			businessEventAudit.setBalanceTransferAmount(balanceTransferToCreditorAmount);
			businessEventAudit.setOperatingSystem(baseRequest.getAuditInfo().getOperatingSystem());
			businessEventAudit.setBrowser(baseRequest.getAuditInfo().getBrowser());
			businessEventAudit.setCustomerIPAddress(baseRequest.getSessionInfo().getIpAddr());
			businessEventAudit.setUrl(baseRequest.getAuditInfo().getUrl());
			String serverID = baseRequest.getAuditInfo().getServerID();
			businessEventAudit.setServerID(serverID);

			businessEventAudit.setLanguage(baseRequest.getLanguagePref());
			
			businessEventAudit.setBrowserLanguage(baseRequest.getAuditInfo().getBrowserLanguage());
			if(baseRequest.getAuditInfo().getBrowserTime() != null){
				businessEventAudit.setBrowserTime(new Date(baseRequest.getAuditInfo().getBrowserTime().longValue()));
			}
			businessEventAudit.setCardRole(baseRequest.getAuditInfo().getCardHolderRole());

			if(baseRequest.getAcctNum() != null){
				businessEventAudit.setTsysAccountId(baseRequest.getAcctNum());
			}
			businessEventAudit.setBusinessEventReason(baseRequest.getAuditInfo().getBusinessEventReason());
			
			
//			DBService.createAuditLogEntry(businessEventAudit);
			DBMybatisService.createAuditLogEntry(businessEventAudit);
		}
	}



}