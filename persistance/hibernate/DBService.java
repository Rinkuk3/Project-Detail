package com.td.mbna.msec.midtier.persistance.hibernate;

//import com.td.mbna.msec.midtier.persistance.hibernate.dao.AccountsDao;
//import com.td.mbna.msec.midtier.persistance.entity.*;
//import com.td.mbna.msec.midtier.persistance.hibernate.dao.*;
//import com.td.mbna.msec.midtier.types.common.CustomerActionItemType;
//import com.td.mbna.msec.midtier.types.common.InterceptorDispositionType;
//import com.td.mbna.msec.midtier.types.common.OfferPreferenceType;
////import com.td.mbna.msec.midtier.types.common.OfferPreferenceType;
//import com.td.mbna.msec.midtier.util.ConfigUtil;
//import com.td.mbna.msec.midtier.util.ExceptionUtil;
//import com.td.mbna.msec.midtier.util.MbnaLogger;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;

public class DBService {
//    private static ApplicationContext applicationContext;
//
//    private static MbnaLogger logger = new MbnaLogger(DBService.class);
//
//    static {
//
//        try {
//            if (Boolean.parseBoolean(System.getProperty(ConfigUtil.SYSTEM_PROPERTY_TEST, "false"))) {
//                applicationContext = new ClassPathXmlApplicationContext("persistance/hibernate/MsecPersistanceContextTest.xml");
//            } else {
//                applicationContext = new ClassPathXmlApplicationContext("persistance/hibernate/MsecPersistanceContext.xml");
//            }
//        } catch (Throwable ex) {
//            logger.error("init", "init error", ex);
//            throw ExceptionUtil.genRuntimeException(ex);
//        }
//
//    }
//
//
//    public static void init() {
//
//    }
//
//    public static void logLastLogin(String customerId, Date lastLoginTime) {
//
//        try {
//            Customers customers = new Customers();
//            customers.setCustomerId(customerId);
//            customers.setLastLogin(lastLoginTime);
//
//            CustomersDao dao = (CustomersDao) applicationContext.getBean("customersDao");
//
//            dao.updateLastLogin(customers);
//
//            logger.debug("Updated Last Login for Customer ID: " + customerId);
//
//        } catch (Exception ex) {
//            logger.error("logLastLogin", "logLastLogin failed:" + customerId + "," + lastLoginTime, ex);
//            //don't throw the exception. Users should be able to continue
//        }
//    }
//
//    public static void logEAAPublishedDateAccepted(String customerId, Date eAAPublishedDateAccepted) {
//
//        try {
//            Customers customers = new Customers();
//            customers.setCustomerId(customerId);
//            customers.setEAAPublishedDateAccepted(eAAPublishedDateAccepted);
//
//            CustomersDao dao = (CustomersDao) applicationContext.getBean("customersDao");
//
//            dao.updateEAA(customers);
//
//            logger.debug("Updated EAA Published Date Accepted for Customer ID: " + customerId);
//        } catch (Exception ex) {
//            logger.error("logEAAPublishedDateAccepted", "logEAAPublishedDateAccepted failed:" + customerId + "," + eAAPublishedDateAccepted, ex);
//            //site should continue, don't throw exception
//        }
//    }
//
//    protected static List<Customers> getCustomers() {
//        CustomersDao dao = (CustomersDao) applicationContext.getBean("customersDao");
//        return dao.findCustomers();
//    }
//
//    /**
//     * find customer by customer id
//     */
//    public static List<Customers> findCustomersByCustomerId(String custId) {
//        CustomersDao dao = (CustomersDao) applicationContext.getBean("customersDao");
//        return dao.findCustomersByCustomerId(custId);
//    }
//
//    /**
//     * get accounts by customer id
//     */
//    public static Accounts getAccount(String customerId, String acctNum) {
//        AccountsDao dao = (AccountsDao) applicationContext.getBean("accountsDao");
//        return dao.getAccount(customerId, acctNum);
//    }
//
//    public static void saveOrUpdateAccounts(Accounts accounts) {
//        AccountsDao dao = (AccountsDao) applicationContext.getBean("accountsDao");
//        dao.saveOrUpdate(accounts);
//    }
//
//    public static void createAuditLogEntry(BusinessEventAudit businessEventAudit) {
//
//        try {
//
//            BusinessEventAuditDao dao = (BusinessEventAuditDao) applicationContext.getBean("businessEventAuditDao");
//
//            dao.save(businessEventAudit);
//
//            logger.debug("Saved AuditLog for EventCode: " + businessEventAudit.getEventCode());
//        } catch (Exception ex) {
//            logger.error("createAuditLogEntry", "createAuditLogEntry failed:" + businessEventAudit, ex);
//			// Don't throw exception since application should still function normally
//        }
//    }
//
//    public static Collection<Creditors> getAllCreditors() {
//        CreditorsDao dao = (CreditorsDao) applicationContext.getBean("creditorsDao");
//        return dao.getAllCreditors();
//    }
//
//    public static Creditors getCreditorById(String creditorId) {
//        try {
//            CreditorsDao dao = (CreditorsDao) applicationContext.getBean("creditorsDao");
//            return dao.getCreditorById(creditorId);
//        } catch (Exception e) {
//            logger.error("getCreditorById", "getCreditorById return null for " + creditorId, e);
//            return null;
//        }
//    }
//
//    public static Creditors getCreditorByMerchantId(String merchantId) {
//        CreditorsDao dao = (CreditorsDao) applicationContext.getBean("creditorsDao");
//        return dao.getCreditorByMerchantId(merchantId);
//    }
//
//    public static void saveBtDestination(BtDestinations payee) {
//        BtDestinationsDao dao = (BtDestinationsDao) applicationContext.getBean("btDestinationsDao");
//        dao.save(payee);
//    }
//
//    public static void updateBtDestination(BtDestinations payee) {
//        BtDestinationsDao dao = (BtDestinationsDao) applicationContext.getBean("btDestinationsDao");
//        dao.update(payee);
//    }
//
//    public static void deleteBtDestination(BtDestinations payee) {
//        BtDestinationsDao dao = (BtDestinationsDao) applicationContext.getBean("btDestinationsDao");
//        dao.delete(payee);
//    }
//
//    public static Collection<BtDestinations> findBtDestinationsByCustomerId(String custId) {
//        try {
//            BtDestinationsDao dao = (BtDestinationsDao) applicationContext.getBean("btDestinationsDao");
//            return dao.findByCustomer(custId);
//        } catch (Exception e) {
//            logger.error("findBtDestinationsByCustomerId", "findBtDestinationsByCustomerId returns null for " + custId, e);
//            return null;
//        }
//    }
//
//    public static Collection<BtDestinations> findBtDestinationsByNickname(String custId, String nickname) {
//        BtDestinationsDao dao = (BtDestinationsDao) applicationContext.getBean("btDestinationsDao");
//        return dao.findByNickname(custId, nickname);
//    }
//
//    public static TtcDestinations getLatestTtcSavedPayee(String custId) {
//        try {
//            TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//            return dao.findLatestSavedPayee(custId);
//        } catch (Exception e) {
//            logger.error("getLatestTtcSavedPayee", "getLatestTtcSavedPayee returns null for " + custId, e);
//            return null;
//        }
//    }
//
//    public static Collection<TtcDestinations> findTtcDestinationsByNickname(String custId, String nickname) {
//        try {
//            TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//            return dao.findByNickname(custId, nickname);
//        } catch (Exception e) {
//            logger.error("findTtcDestinationsByNickname", "findTtcDestinationsByNickname returns null for " + custId + "," + nickname, e);
//            return null;
//        }
//    }
//
//    public static void saveTtcDestination(TtcDestinations payee) {
//        TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//        dao.save(payee);
//    }
//
//    public static void updateTtcDestination(TtcDestinations payee) {
//        TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//        dao.update(payee);
//    }
//
//    public static void deleteTtcDestination(TtcDestinations payee) {
//        TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//        dao.delete(payee);
//    }
//
//    public static Collection<TtcDestinations> findTtcDestinationsByCustomer(String custId) {
//        try {
//            TtcDestinationsDao dao = (TtcDestinationsDao) applicationContext.getBean("ttcDestinationsDao");
//            return dao.findByCustomer(custId);
//        } catch (Exception e) {
//            logger.error("findTtcDestinationsByCustomer", "findTtcDestinationsByCustomer returns null for " + custId, e);
//            return null;
//        }
//    }
//
//    public static ApplicationContext getApplicationContext() {
//        return applicationContext;
//    }
//
//    public static void setApplicationContext(ApplicationContext applicationContext) {
//        DBService.applicationContext = applicationContext;
//    }
//
//    public static AffinityInfo getAffinityInfo(String productCodes, String arqCode, String lang, String poCode) throws Exception {
//        AffinityInfoDao dao = (AffinityInfoDao) applicationContext.getBean("affinityInfoDao");
//        return dao.findByProductCodes(productCodes, arqCode, lang, poCode);
//    }
//
//    public static PlasticsCode getPlasticsCode(String productCodes, String arqCode, String lang, String poCode) {
//        PlasticsCodeDao dao = (PlasticsCodeDao) applicationContext.getBean("plasticsCodeDao");
//        return dao.findByProductCodes(productCodes, arqCode, lang, poCode);
//    }
//
//    public static boolean getChatEligibility(String pc, String arqCode) {
//        boolean rc = false;
//        ChatEligibilityDao dao = (ChatEligibilityDao) applicationContext.getBean("chatEligibilityDao");
//        try {
//            ChatEligibility cb = dao.getChatEligiblityByProductCodes(pc, arqCode);
//            if (cb == null) {
//                logger.error("getChatEligibility", "Unable to get chat eligibility for " + pc + "," + arqCode);
//                return false;
//            }
//            rc = cb.isOnlineChatAllowed();
//        } catch (Exception toleratedException) {
//            logger.error("getChatEligibility", "getChatEligibility failed:" + pc + "," + arqCode, toleratedException);
//        }
//        return rc;
//
//    }
//
//    public static void saveCLIEvent(CreditLimitIncEvent cliEvent) {
//        CreditLimitIncDao dao = (CreditLimitIncDao) applicationContext.getBean("creditLimitIncDao");
//        dao.save(cliEvent);
//    }
//
//    public static KmsKeys getViewPinZpk(Date date) throws Exception {
//        KmsKeysDao dao = (KmsKeysDao) applicationContext.getBean("kmskeysDao"); 
//        return dao.getZpkExporterByDate(date);
//    }
//
//    public static KmsKeys getChangePinZpk(Date date) throws Exception {
//        KmsKeysDao dao = (KmsKeysDao) applicationContext.getBean("kmskeysDao");
//        return dao.getZpkImporterByDate(date);
//    }
//
//    public static KmsKeys getWtk(Date date) throws Exception {
//        KmsKeysDao dao = (KmsKeysDao) applicationContext.getBean("kmskeysDao");
//        return dao.getWtkByDate(date);
//    }
//
//    public static TransactionFee getTransactionFee(String txnFeeNum, String subType){
//        TransactionFeeDao dao = (TransactionFeeDao) applicationContext.getBean("transactionFeeDao");
//        return dao.getTransactionFee(txnFeeNum, subType);
//    }
//
//    
//    // interceptor disposition
//    public static List<InterceptorDisposition> getInterceptorByUCID(String ucid) {
//    	InterceptorDispositionDao dao = (InterceptorDispositionDao) applicationContext.getBean("interceptorDispositionDao");
//    	return dao.findByUCID(ucid);
//    }
//    
//    public static void createInterceptor(InterceptorDispositionType type) {
//    	InterceptorDispositionDao dao = (InterceptorDispositionDao) applicationContext.getBean("interceptorDispositionDao");
//    	dao.saveOrUpdate(type);
//    }
//    
//    public static void updateInterceptor(InterceptorDispositionType type) {
//    	InterceptorDispositionDao dao = (InterceptorDispositionDao) applicationContext.getBean("interceptorDispositionDao");
//    	dao.update(type);
//    }
// // end of interceptor disposition
//    
//// 	offer  preference
//    public static List<OfferPreference> getOfferPreferenceByUCID(String ucid) {
//    	OfferPreferenceDao dao = (OfferPreferenceDao) applicationContext.getBean("offerPreferenceDao");
//    	return dao.findByUCID(ucid);
//    }
//    
//    public static void createOfferPreference(OfferPreferenceType type) {
//    	OfferPreferenceDao dao = (OfferPreferenceDao) applicationContext.getBean("offerPreferenceDao");
//    	dao.saveOrUpdate(type);
//    }
//    
//    public static void updateOfferPreference(OfferPreferenceType type) {
//    	OfferPreferenceDao dao = (OfferPreferenceDao) applicationContext.getBean("offerPreferenceDao");
//    	dao.update(type);
//    }
//    // end of offerpreference
//    
//
//    public static void updateCustomerActionItem(CustomerActionItemType customerActionItemType) {
//            CustomerActionItemsDao dao = (CustomerActionItemsDao) applicationContext.getBean("customerActionItemsDao");
//            CustomerActionItem customerActionItem = buildCustomerActionItem(customerActionItemType);
//            dao.saveOrUpdate(customerActionItem);
//    }
//
//    private static CustomerActionItem buildCustomerActionItem(CustomerActionItemType customerActionItemType) {
//        CustomerActionItem customerActionItem = new CustomerActionItem();
//        customerActionItem.setActionID(customerActionItemType.getActionID().longValue());
//        customerActionItem.setCustomerID(customerActionItemType.getCustomerID());
//        customerActionItem.setAccountNumber(customerActionItemType.getAccountNumber());
//        customerActionItem.setDismissed(customerActionItemType.getDismissed() == null ? false : customerActionItemType.getDismissed().booleanValue());
//        customerActionItem.setVisited(customerActionItemType.getVisited() == null ? false : customerActionItemType.getVisited().booleanValue());
//        return customerActionItem;
//    }
//
//    public static List<CustomerActionItem> getCustomerActionItemByUcid(String ucid) {
//        CustomerActionItemsDao customerActionItemsDao = (CustomerActionItemsDao) applicationContext.getBean("customerActionItemsDao");
//        return customerActionItemsDao.findByUCID(ucid);
//    }
}
