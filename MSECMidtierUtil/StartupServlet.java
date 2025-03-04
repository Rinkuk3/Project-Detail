package com.td.mbna.msec.midtier.util;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//import com.td.mbna.msec.midtier.persistance.hibernate.DBService;
import com.td.mbna.msec.midtier.persistance.mybatis.DBMybatisService;
import com.td.mbna.msec.midtier.services.AuditServiceWork;

public class StartupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config) {
        MbnaLogger logger = new MbnaLogger(StartupServlet.class);
        try {

            // logger.info("Initializing MidTier ConfigUtil..."); // log4j not initialized yet, so cannot invoke logger
            ServerConfigUtil.init();
            //ConfigUtil.init();
            //logger.info("MidTier ConfigUtil initialization successful");
            logger.info("Initializing MidTier SpringBeanProvider...");
            SpringBeanProvider.getApplicationContext();
            logger.info("MidTier SpringBeanProvider initialization successful");

            logger.info("Initializing MidTier PersistanceContext...");
//            DBService.init();
            DBMybatisService.init();
            logger.info("MidTier PersistanceContext initialization successful");

//            logger.info("Initializing MidTier TDWebServices...");
//            TDwsServiceUtil.init();
//            logger.info("MidTier TDWebServices initialization successful");

//            logger.info("Initializing MidTier ExceptionMapping...");
//            ExceptionMappingProcessor.init();
//            logger.info("MidTier ExceptionMapping initialization successful");
            //ThreadContext.put("sessionID", (String) config.getServletContext().getAttribute("connectId"));
        } catch (Throwable ex) {
            throw new RuntimeException(ex);
        }

        try {
            logger.info("Initializing MidTier AuditService...");
            AuditServiceWork.init();

            //CustomerNoteServiceWork.init();

            //logger.info("Initializing MidTier EmailService...");
            //EmailServiceWork.init();

            logger.info("MidTier AuditService initialization successful");
            //logger.info("MidTier EmailService initialization successful");
        } catch (Throwable ex) {
            throw ExceptionUtil.genRuntimeException(ex);
        }
    }

    public void destroy() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }

}
