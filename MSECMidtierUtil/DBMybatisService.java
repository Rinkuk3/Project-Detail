package com.td.mbna.msec.midtier.persistance.mybatis;

import java.util.Date;
import java.util.List;

import com.td.mbna.msec.midtier.persistance.mybatis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.persistance.entity.*;
import com.td.mbna.msec.midtier.persistance.mybatis.mapper.*;
import com.td.mbna.msec.midtier.types.common.CustomerActionItemType;
import com.td.mbna.msec.midtier.types.common.InterceptorDispositionType;
import com.td.mbna.msec.midtier.types.common.OfferPreferenceType;
import com.td.mbna.msec.midtier.util.ConfigUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;

import javax.annotation.PostConstruct;

@Service
public class DBMybatisService {

	private static ApplicationContext applicationContext;

	@Autowired
	private DBMybatisRepository dbMybatisRepository;

	@Autowired
	private PlasticCodeRepository plasticCodeRepository;

	@Autowired
	private ChatEligibilityRepository chatEligibilityRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionFeeRepository transactionFeeRepository;

	private static DBMybatisRepository dbMybatisRepositoryStatic;

	private static PlasticCodeRepository plasticCodeRepositoryStatic;
	private static ChatEligibilityRepository chatEligibilityRepositoryStatic;
	private static CustomerRepository customerRepositoryStatic;
	private static TransactionFeeRepository transactionFeeRepositoryStatic;
	@PostConstruct
	private void initStaticDao () {
		dbMybatisRepositoryStatic = dbMybatisRepository;
		plasticCodeRepositoryStatic = plasticCodeRepository;
		chatEligibilityRepositoryStatic = chatEligibilityRepository;
		customerRepositoryStatic = customerRepository;
		transactionFeeRepositoryStatic = transactionFeeRepository;
	}

	private static MbnaLogger logger = new MbnaLogger(DBMybatisService.class);

	static {

		try {
			if (ConfigUtil.isTest() || ConfigUtil.isTestProfile()) {
				//applicationContext = new ClassPathXmlApplicationContext("classpath:src/test/resources/persistance/mybatis/MybatisSpringContextTest.xml");
			} else {
				applicationContext = new ClassPathXmlApplicationContext("persistance/mybatis/MybatisSpringContext.xml");
			}
		} catch (Throwable ex) {
			logger.error("init", "init error", ex);
			throw ExceptionUtil.genRuntimeException(ex);
		}

	}

	public static void init() {

	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	// accounts table
	/**
	 * get accounts by customer id and account number
	 */
	public static Accounts getAccount(String customerId, String acctNum) {
		try {
			//AccountMapper mapper = (AccountMapper) applicationContext.getBean("accountMapper");
			return dbMybatisRepositoryStatic.getAccount(customerId, acctNum);
		} catch (Exception e) {
			logger.error("getAccount", "getAccount failed for CustomerId = " + customerId +" and account number = " +acctNum, e);
			return null;
		}
	}

	public static void createAccounts(Accounts accounts) {
		try {
			//AccountMapper mapper = (AccountMapper) applicationContext.getBean("accountMapper");
			dbMybatisRepositoryStatic.create(accounts);
		} catch (Exception e) {
			logger.error("createAccounts", "createAccounts failed "+accounts.toString() , e);
		}
	}
	public static void updateAccounts(Accounts accounts) {
		try {
			//AccountMapper mapper = (AccountMapper) applicationContext.getBean("accountMapper");
			dbMybatisRepositoryStatic.update(accounts);
		} catch (Exception e) {
			logger.error("updateAccounts", "updateAccounts failed " +accounts.toString(), e);
		}
	}
	
	//	AFFINITYINFO table
    public static AffinityInfo getAffinityInfo(String productCodes, String arqCode, String lang, String poCode) throws Exception {
    	AffinityInfoMapper mapper = (AffinityInfoMapper) applicationContext.getBean("affinityInfoMapper");
		final String VISA_CODE = ConfigUtil.getProperty("mbna.code.visa");
		logger.info("Retrieving affinity info. Parameters: " + productCodes.trim() + " - "+ lang + "; arqCode: " + arqCode);
		String arqInfo = "";
		
		String tmpproductCodes = productCodes;
		if (arqCode != null && arqCode.trim().length() > 0) {
			tmpproductCodes = productCodes.trim()+"-"+arqCode;
			logger.info("combine productiCode and arqCode together: "+tmpproductCodes);
		}
		
		List<AffinityInfo> afinityInfos = null;
		try {
			//afinityInfos = mapper.findByProductCodes(tmpproductCodes, lang, poCode);
			afinityInfos = dbMybatisRepositoryStatic.findByProductCodes(tmpproductCodes, lang, poCode);
			if(afinityInfos.isEmpty() || afinityInfos.get(0) == null){
				String productType = productCodes.substring(0, 1);
				tmpproductCodes = "DEFAULT";
				if(productType.equalsIgnoreCase(VISA_CODE)){
					tmpproductCodes = "VISA-DEFAULT";
				}
				logger.debug(" getAffinityInfo by default code : " +tmpproductCodes);
				//afinityInfos = mapper.findByProductCodes(tmpproductCodes, lang, poCode);
				afinityInfos = dbMybatisRepositoryStatic.findByProductCodes(tmpproductCodes, lang, poCode);
			}
		} catch (Exception e) {
			logger.error("getAffinityInfo", "getAffinityInfo failed for productCodes = " + productCodes +" and arqCode = " +arqCode+" and lang = " +lang+" and poCode = " +poCode, e);
		}
		
		if(afinityInfos.isEmpty() || afinityInfos.get(0) == null){
			logger.warning(" SSMT004: missing affinity name  for "+productCodes + arqInfo + ". Using default product name");
			return null;
		}
		return afinityInfos.get(0);
    }

    
    //    BTDESTINATIONS table
    
    public static List<BtDestinations> findBtDestinationsByCustomerId(String custId) {
    	try {
    		BtDestinationMapper mapper = (BtDestinationMapper) applicationContext.getBean("btDestinationMapper");
    		return mapper.findByCustomer(custId);
    	} catch (Exception e) {
    		logger.error("findBtDestinationsByCustomerId", "findBtDestinationsByCustomerId failed for CustomerId = " + custId, e);
    		return null;
    	}
    }
    
    public static List<BtDestinations> findBtDestinationsByNickname(String custId, String nickname) {
    	try {
			BtDestinationMapper mapper = (BtDestinationMapper) applicationContext.getBean("btDestinationMapper");;
			return mapper.findByNickname(custId, nickname);
		} catch (Exception e) {
			logger.error("findBtDestinationsByNickname", "findBtDestinationsByNickname failed for CustomerId = " + custId +" and nickname = " +nickname, e);
			return null;
		}
    }
    
    public static void saveBtDestination(BtDestinations payee) {
    	try {
			BtDestinationMapper mapper = (BtDestinationMapper) applicationContext.getBean("btDestinationMapper");
			mapper.save(payee);
		} catch (Exception e) {
			logger.error("saveBtDestination", "saveBtDestination failed! "+payee.toString(), e);
		}
    }

    public static void updateBtDestination(BtDestinations payee) {
    	try {
	    	BtDestinationMapper mapper = (BtDestinationMapper) applicationContext.getBean("btDestinationMapper");
	    	mapper.update(payee);
	    } catch (Exception e) {
	    	logger.error("updateBtDestination", "updateBtDestination failed! "+payee.toString(), e);
	    }
    }

    public static void deleteBtDestination(BtDestinations payee) {
    	try {
	    	BtDestinationMapper mapper = (BtDestinationMapper) applicationContext.getBean("btDestinationMapper");
	    	mapper.delete(payee);
	    } catch (Exception e) {
	    	logger.error("deleteBtDestination", "deleteBtDestination failed! "+payee.toString(), e);
	    }
    }

//    BUSINESSEVENTAUDIT table
    public static void createAuditLogEntry(BusinessEventAudit businessEventAudit) {

        try {

        	BusinessEventAuditMapper mapper = (BusinessEventAuditMapper) applicationContext.getBean("businessEventAuditMapper");

            mapper.create(businessEventAudit);

            logger.debug("Saved AuditLog for EventCode: " + businessEventAudit.getEventCode());
        } catch (Exception ex) {
            logger.error("createAuditLogEntry", "createAuditLogEntry failed:" + businessEventAudit.toString(), ex);
			// Don't throw exception since application should still function normally
        }
    }
    
//    CHATELIGIBILITY table
    public static boolean getChatEligibility(String pc, String arqCode) {
    	logger.info("getChatEligibility by productcode = "+pc +" and arqcode = "+ arqCode);
        boolean rc = false;
        ChatEligibilityMapper mapper = (ChatEligibilityMapper) applicationContext.getBean("chatEligibilityMapper");
        
        String tmpproductCodes = pc;
        if (arqCode != null && arqCode.trim().length() > 0) {
        	tmpproductCodes = pc+"-"+arqCode;
        	logger.info("combine productcode and arqCode together =" +tmpproductCodes);
        }
        
        try {
            //List<ChatEligibility> cbs = mapper.getChatEligiblityByProductCodes(tmpproductCodes);
			List<ChatEligibility> cbs = chatEligibilityRepositoryStatic.getChatEligiblityByProductCodes(tmpproductCodes);
            if(cbs.isEmpty() || cbs.get(0) == null){
            	logger.debug("getChatEligibility by default productcode = DEFAULT");
            	//cbs = mapper.getChatEligiblityByProductCodes("DEFAULT");
				cbs = chatEligibilityRepositoryStatic.getChatEligiblityByProductCodes("DEFAULT");
            }
            if (cbs.isEmpty() || cbs.get(0) == null) {
                logger.warning(" getChatEligibility Unable to get chat eligibility for " + pc + "," + arqCode);
                return false;
            }
            rc = cbs.get(0).isOnlineChatAllowed();
        } catch (Exception e) {
            logger.error("getChatEligibility", "getChatEligibility failed:" + pc + "," + arqCode, e);
        }
        return rc;

    }
    
//    CREDITLIMITINCEVENT table
    public static void saveCLIEvent(CreditLimitIncEvent cliEvent) {
    	try {
	    	CreditLimitIncEventMapper mapper = (CreditLimitIncEventMapper) applicationContext.getBean("creditLimitIncEventMapper");
	        mapper.create(cliEvent);
	        
	        logger.toJson("save CLI evnt", cliEvent);
	    } catch (Exception ex) {
	        logger.error("save CLI event", " failed:" + cliEvent.toString(), ex);
			// Don't throw exception since application should still function normally
	    }
    }
    
//    CREDITORS table
    public static List<Creditors> getAllCreditors() {
    	try {
	    	CreditorMapper mapper = (CreditorMapper) applicationContext.getBean("creditorMapper");
	        return mapper.getAllCreditors();
		} catch (Exception e) {
			logger.error("getAllCreditors", "getAllCreditors failed", e);
			return null;
		}
    }

    public static Creditors getCreditorById(String creditorId) {
        try {
        	CreditorMapper mapper = (CreditorMapper) applicationContext.getBean("creditorMapper");
            return mapper.getCreditorById(creditorId);
        } catch (Exception e) {
            logger.error("getCreditorById", "getCreditorById failed for creditorId = " + creditorId, e);
            return null;
        }
    }

    public static Creditors getCreditorByMerchantId(String merchantId) {
    	try {
	    	CreditorMapper mapper = (CreditorMapper) applicationContext.getBean("creditorMapper");
	        return mapper.getCreditorByMerchantId(merchantId);
	    } catch (Exception e) {
	    	logger.error("getCreditorByMerchantId", "getCreditorByMerchantId failed for merchantId = " + merchantId, e);
	    	return null;
	    }
    }
    
//    CUSTOMER_ACTION_ITEMS table
    public static List<CustomerActionItem> getCustomerActionItemByUcid(String ucid) {
    	try {
	    	CustomerActionItemMapper mapper = (CustomerActionItemMapper) applicationContext.getBean("customerActionItemMapper");
	        return mapper.findByUCID(ucid);
	    } catch (Exception e) {
	    	logger.error("getCustomerActionItemByUcid", "getCustomerActionItemByUcid failed for ucid = " + ucid, e);
	    	return null;
	    }
    }
    
    public static void updateCustomerActionItem(CustomerActionItemType customerActionItemType) {
        CustomerActionItem customerActionItem = buildCustomerActionItem(customerActionItemType);
       try{
            CustomerActionItemMapper mapper = (CustomerActionItemMapper) applicationContext.getBean("customerActionItemMapper");
            mapper.saveOrUpdate(customerActionItem);
        } catch (Exception e) {
	    	logger.error("updateCustomerActionItem", "updateCustomerActionItem failed  " , e);
	    }
    }
    
	private static CustomerActionItem buildCustomerActionItem(CustomerActionItemType customerActionItemType) {
		CustomerActionItem customerActionItem = new CustomerActionItem();
		customerActionItem.setActionID(customerActionItemType.getActionID().longValue());
		customerActionItem.setCustomerID(customerActionItemType.getCustomerID());
		customerActionItem.setAccountNumber(customerActionItemType.getAccountNumber());
		customerActionItem.setDismissed(customerActionItemType.getDismissed() == null ? "N" : (customerActionItemType.getDismissed().booleanValue()?"Y":"N"));
		customerActionItem.setVisited(customerActionItemType.getVisited() == null ? "N" : (customerActionItemType.getVisited().booleanValue()?"Y":"N"));
		return customerActionItem;
	}
    
//    CUSTOMERS table
    /**
     * find customer by customer id
     */
    public static List<Customers> findCustomersByCustomerId(String custId) {
    	try {
	    	CustomerMapper mapper = (CustomerMapper) applicationContext.getBean("customerMapper");
	        return customerRepositoryStatic.findCustomersByCustomerId(custId);
	    } catch (Exception e) {
	    	logger.error("findCustomersByCustomerId", "findCustomersByCustomerId failed for ucid=" + custId, e);
	    	return null;
	    }
    }
    
    public static void logEAAPublishedDateAccepted(String customerId, Date eAAPublishedDateAccepted) {
    	
    	List<Customers> customers = findCustomersByCustomerId(customerId);
    	Customers newCust = new Customers();
    	if(customers.isEmpty() || customers.get(0) == null){
    		newCust.setFirstLogin(new Date());
    		newCust.setLastLogin(new Date());
    	}else{
    		Customers existCust=customers.get(0);
    		Date firstLogin = existCust.getFirstLogin();
    		Date lastLogin = existCust.getLastLogin();
    		
        	if (lastLogin != null) {
        		newCust.setLastLogin(lastLogin);
        	} else {
        		if(firstLogin != null){
        			newCust.setLastLogin(firstLogin);
        		}
        	}
        	
        	if (firstLogin != null) {
        		newCust.setFirstLogin(firstLogin);
        	} else{
        		logger.warning(" first Login is somehow null, set it to last login:" + lastLogin + " for customer " + customerId);
        		newCust.setFirstLogin(lastLogin);
        	}
    	}
        try {
            newCust.setCustomerId(customerId);
            newCust.setEAAPublishedDateAccepted(eAAPublishedDateAccepted);

            CustomerMapper mapper = (CustomerMapper) applicationContext.getBean("customerMapper");

            customerRepositoryStatic.updateOrSave(newCust);

            logger.debug("Updated EAA Published Date Accepted for Customer ID: " + customerId);
        } catch (Exception ex) {
            logger.error("logEAAPublishedDateAccepted", "logEAAPublishedDateAccepted failed:" + customerId + "," + eAAPublishedDateAccepted, ex);
            //site should continue, don't throw exception
        }
    }
    
    public static void logLastLogin(String customerId, Date lastLoginTime) {
    	
    	List<Customers> customers = findCustomersByCustomerId(customerId);
    	Customers newCust = new Customers();
    	if(customers.isEmpty() || customers.get(0) == null){
    		newCust.setFirstLogin(new Date());
    		newCust.setLastLogin(new Date());
    	}else{
    		newCust = customers.get(0);
    		Date eAAPublishedDateAccepted = newCust.getEAAPublishedDateAccepted();
	        Date firstLogin = newCust.getFirstLogin();
	        
	        if (eAAPublishedDateAccepted != null) {
	        	newCust.setEAAPublishedDateAccepted(eAAPublishedDateAccepted);
        	} else {
        		logger.warning(" eAAPublishedDateAccepted is null: " +customerId);
        	}
        	
        	if (firstLogin != null) {
        		newCust.setFirstLogin(firstLogin);
        	}else{
        		logger.warning(" first Login is somehow null, set it to last login for customerid = " + customerId + " ,lastLoginTime = " + lastLoginTime);
        		newCust.setFirstLogin(lastLoginTime);
        	}
    	}

        try {
            newCust.setCustomerId(customerId);
            newCust.setLastLogin(lastLoginTime);

            CustomerMapper mapper = (CustomerMapper) applicationContext.getBean("customerMapper");

            customerRepositoryStatic.updateOrSave(newCust);

            logger.debug("Updated Last Login for Customer ID: " + customerId);

        } catch (Exception ex) {
            logger.error("logLastLogin", "logLastLogin failed for customerId = " + customerId + ",lastLoginTime = " + lastLoginTime, ex);
            //don't throw the exception. Users should be able to continue
        }
    }
//    INTERCEPTOR_DISPOSITION table
    // interceptor disposition
    public static List<InterceptorDisposition> getInterceptorByUCID(String ucid) {
    	try {
	    	InterceptorDispositionMapper mapper = (InterceptorDispositionMapper) applicationContext.getBean("interceptorDispositionMapper");
	    	return mapper.findByUCID(ucid);
	    } catch (Exception e) {
	    	logger.error("getInterceptorByUCID", "getInterceptorByUCID failed for ucid=" + ucid, e);
	    	return null;
	    }
    }
    
    public static void createInterceptor(InterceptorDispositionType type) {
    	InterceptorDisposition interceptor = new InterceptorDisposition();
    	processInterceptor(interceptor,type);
    	try {
	    	InterceptorDispositionMapper mapper = (InterceptorDispositionMapper) applicationContext.getBean("interceptorDispositionMapper");
	    	mapper.create(interceptor);
	    } catch (Exception ex) {
	        logger.error("createInterceptor", "createInterceptor failed!" + type.toString() , ex);
	        //don't throw the exception. Users should be able to continue
	    }
    }
    
    public static void updateInterceptor(InterceptorDispositionType type) {
    	InterceptorDisposition interceptor = new InterceptorDisposition();
    	processInterceptor(interceptor,type);
    	try {
	    	InterceptorDispositionMapper mapper = (InterceptorDispositionMapper) applicationContext.getBean("interceptorDispositionMapper");
	    	mapper.update(interceptor);
	    } catch (Exception ex) {
	        logger.error("updateInterceptor", "updateInterceptor failed! " + type.toString() , ex);
	        //don't throw the exception. Users should be able to continue
	    }
    }
    
	private static void processInterceptor(InterceptorDisposition interceptor,	InterceptorDispositionType type) {
		interceptor.setUcid(type.getUcid());
		interceptor.setInterceptorId(type.getInterceptorId());
		interceptor.setInterceptorType(type.getInterceptorType());
		interceptor.setCardRole(type.getCardRole());
		interceptor.setConnectId(type.getConnectId());
		interceptor.setDispositionStatus(type.getDispositionStatus());
		interceptor.setOfferId(type.getOfferId());
		interceptor.setTimestamp(new Date());
		interceptor.setTsysAccountId(type.getTsysAccountId());
		
	}
    // end of interceptor disposition
	/**
	 * key: 'ZPKIMPORTER'/WTK/ZPKEXPORTER
	 * @param effdate
	 * @param key
	 * @return
	 */
    public static KmsKeys getKmsKeys(Date effdate, String key) {
    	try {
	    	KmsKeyMapper mapper = (KmsKeyMapper) applicationContext.getBean("kmsKeyMapper");
	    	List<KmsKeys> kmskeys  = mapper.getKmsKeysByDate(effdate, key);
	    	  if (kmskeys.isEmpty() || kmskeys.get(0) == null) {
		        	throw new Exception("getKmsKeys is null for effdate=" + effdate +" , key ="+key);
		        }
	    	return kmskeys.get(0);
	    } catch (Exception e) {
	    	logger.error("getKmsKeys", "getKmsKeys failed for effdate=" + effdate +" , key ="+key, e);
	    	return null;
	    }
    }
//    OFFER_PREFERENCE table
// 	offer  preference
    public static List<OfferPreference> getOfferPreferenceByUCID(String ucid) {
    	try {
	    	OfferPreferenceMapper mapper = (OfferPreferenceMapper) applicationContext.getBean("offerPreferenceMapper");
	    	return mapper.findByUCID(ucid);
	    } catch (Exception e) {
	    	logger.error("getOfferPreferenceByUCID", "getOfferPreferenceByUCID failed for ucid=" + ucid , e);
	    	return null;
	    }
    }
    
    public static void createOfferPreference(OfferPreferenceType type) {
    	OfferPreference pref = new OfferPreference();
    	processPref(pref, type);
    	try {
	    	OfferPreferenceMapper mapper = (OfferPreferenceMapper) applicationContext.getBean("offerPreferenceMapper");
	    	mapper.create(pref);
	    } catch (Exception ex) {
	        logger.error("createOfferPreference", "createOfferPreference failed! " + type.toString() , ex);
	        //don't throw the exception. Users should be able to continue
	    }
    }
    
    public static void updateOfferPreference(OfferPreferenceType type) {
    	OfferPreference pref = new OfferPreference();
    	processPref(pref, type);
    	try {
	    	OfferPreferenceMapper mapper = (OfferPreferenceMapper) applicationContext.getBean("offerPreferenceMapper");
	    	mapper.update(pref);
	    } catch (Exception ex) {
	    	logger.error("updateOfferPreference", "updateOfferPreference failed! " + type.toString() , ex);
	    	//don't throw the exception. Users should be able to continue
	    }
    }
    
	private static void processPref(OfferPreference pref, OfferPreferenceType type) {
		pref.setUcid(type.getUcid());
		pref.setOfferType(type.getOfferType());
		pref.setCardRole(type.getCardRole());
		pref.setConnectId(type.getConnectId());
		if("true".equalsIgnoreCase(type.getEnabled())){
			pref.setEnabled("E");
			pref.setEnabledTS(new Date());
		}
		if("true".equalsIgnoreCase(type.getDisabled())){
			pref.setDisabled("D");
			pref.setDisabledTS(new Date());
		}
		
	}

    // end of offerpreference
	
//	ONBOARDING_ACTION_ITEMS table
//    public static List<OnboardingActionItem> getOnboardingActionItems() {
//    	try {
//	    	OnboardingActionItemMapper mapper = (OnboardingActionItemMapper) applicationContext.getBean("onboardingActionItemMapper");
//	        return mapper.findAllOnboardingActionItems();
//	    } catch (Exception e) {
//	    	logger.error("getOnboardingActionItems", "getOnboardingActionItems failed "  , e);
//	    	return null;
//	    }
//    }
//
//    private static OnboardingActionItem getOnboardingActionItemById(long actionID) {
//    	try {
//	    	OnboardingActionItemMapper mapper = (OnboardingActionItemMapper) applicationContext.getBean("onboardingActionItemMapper");
//	        return mapper.findActionItemByID(actionID);
//	    } catch (Exception e) {
//	    	logger.error("getOnboardingActionItemById", "getOnboardingActionItemById failed  for actionID = "+actionID  , e);
//	    	return null;
//	    }
//    }
    
//    PLASTICSCODE table
    public static PlasticsCode getPlasticsCode(String productCodes, String arqCode, String lang, String poCode) {
    	String arqInfo = "";
    	String tmpproductCodes = productCodes.trim();
    	if(arqCode != null && arqCode.trim().length() > 0){
    		tmpproductCodes = productCodes.trim()+"-"+arqCode.trim();
    		arqInfo = " with ArqCode " + arqCode;
    	}
    	List<PlasticsCode> pcs = null;
    	try {
	    	PlasticsCodeMapper mapper = (PlasticsCodeMapper) applicationContext.getBean("plasticsCodeMapper");
			//pcs = mapper.findByProductCodes(tmpproductCodes, lang, poCode);
			pcs = plasticCodeRepositoryStatic.findByProductCodes(tmpproductCodes, lang, poCode);
	    	if(pcs.isEmpty() || pcs.get(0) == null){
	    		//pcs = mapper.findByProductCodes(productCodes, lang, "--");
				pcs = plasticCodeRepositoryStatic.findByProductCodes(productCodes, lang, "--");
	    	}
	    	if(pcs.isEmpty() || pcs.get(0) == null){
	    		logger.warning(" SSMT004: missing card image Id for "+productCodes+" with POCode " + poCode + arqInfo+". using no image");
	    		return null;
	    	}
	    	return pcs.get(0);
	    } catch (Exception e) {
	    	logger.error("getPlasticsCode", "getPlasticsCode failed  for productCodes = "+productCodes+",arqCode = " +arqCode+",lang = " +lang+",poCode = " +poCode , e);
	    	return null;
	    }
    }
    
//    TRANSACTION_FEE table
    public static TransactionFee getTransactionFee(String txnFeeNum, String subType){
    	try {
	    	TransactionFeeMapper mapper = (TransactionFeeMapper) applicationContext.getBean("transactionFeeMapper");
	    	//List<TransactionFee> txFees = mapper.getTransactionFee(txnFeeNum, subType);
			List<TransactionFee> txFees = transactionFeeRepositoryStatic.getTransactionFee(txnFeeNum, subType);
	    	if(txFees.isEmpty() || txFees.get(0) == null){
	    		logger.error("getTransactionFee", "getTransactionFee returns null  for txnFeeNum = "+txnFeeNum+",subType = " +subType);
	    		return null;
	    	}
	        return txFees.get(0);
	    } catch (Exception e) {
	    	logger.error("getTransactionFee", "getTransactionFee failed  for txnFeeNum = "+txnFeeNum+",subType = " +subType , e);
	    	return null;
	    }
    }
    
//    TTCDESTINATIONS table 
    public static List<TtcDestinations> findTtcDestinationsByCustomer(String custId) {
    	try {
    		TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");
    		return mapper.findByCustomer(custId);
    	} catch (Exception e) {
    		logger.error("findTtcDestinationsByCustomer", "findTtcDestinationsByCustomer failed for " + custId, e);
    		return null;
    	}
    }

    public static List<TtcDestinations> findTtcDestinationsByNickname(String custId, String nickname) {
        try {
        	TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");;
            return mapper.findByNickname(custId, nickname);
        } catch (Exception e) {
            logger.error("findTtcDestinationsByNickname", "findTtcDestinationsByNickname failed for " + custId + "," + nickname, e);
            return null;
        }
    }
    
    public static TtcDestinations getLatestTtcSavedPayee(String custId) {
    	try {
    		TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");
			List<TtcDestinations> tds = dbMybatisRepositoryStatic.findLatestSavedPayee(custId);
    		if(tds.isEmpty() || tds.get(0) == null){
    			logger.warning(" getLatestTtcSavedPayee returns null for custId = " + custId);
    			return null;
    		}
    		return tds.get(0);
    	} catch (Exception e) {
    		logger.error("getLatestTtcSavedPayee", " getLatestTtcSavedPayee failed for custId = " + custId, e);
    		return null;
    	}
    }

    public static void saveTtcDestination(TtcDestinations payee) {
    	try {
	    	TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");
	    	mapper.save(payee);
		} catch (Exception e) {
			logger.error("saveTtcDestination", "saveTtcDestination failed for " + payee.toString(), e);
		}
    }

    public static void updateTtcDestination(TtcDestinations payee) {
    	try {
	    	TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");
	    	mapper.update(payee);
	    } catch (Exception e) {
			logger.error("updateTtcDestination", "updateTtcDestination failed for " + payee.toString(), e);
		}
    }

    public static void deleteTtcDestination(TtcDestinations payee) {
    	try {
	    	TtcDestinationMapper mapper = (TtcDestinationMapper) applicationContext.getBean("ttcDestinationMapper");
	    	mapper.delete(payee);
	    } catch (Exception e) {
	    	logger.error("deleteTtcDestination", "deleteTtcDestination failed for " + payee.toString(), e);
	    }
    }

    
}
