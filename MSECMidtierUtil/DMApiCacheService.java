package com.td.mbna.msec.midtier.util.cache;

import com.td.api.dms.response.DocumentList;
import com.td.mbna.msec.midtier.cache.ServiceCommand;
import com.td.mbna.msec.midtier.services.TdStatementServiceUtil;
import com.td.mbna.msec.midtier.util.ExceptionUtil;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.services.TDRestServiceUtil;

public class DMApiCacheService extends ServiceCommand {

    private static MbnaLogger logger = new MbnaLogger(DMApiCacheService.class);

    private static final long serialVersionUID = 269343145704857990L;

    /**
     * Cache key main component.
     */
    private String insertId;

    private DocumentList documentList;

    private transient TDRestServiceUtil tdRestServiceUtil;

    private String token;

    private String dmApiPortal;

    private String insertsFolder;

    /**
     * Pre-command execution intercepted by DynaCache service.
     **/
    @Override
    public boolean isReadyToCallExecute() {
        return insertId != null && tdRestServiceUtil != null && super.isReadyToCallExecute();
    }

    /**
     * Target command to be intercepted by DynaCache service.
     **/
    @Override
    public void performExecute() {
        logger.debug("performExecute", "NO CACHE: documentList, " + insertId);
        documentList = TdStatementServiceUtil.searchInserts(insertId, dmApiPortal, insertsFolder, token, tdRestServiceUtil);
        logger.debug("performExecute", "CACHE LOADED: documentList, " + insertId);
    }

    public static synchronized DocumentList getInsertInfo(String insertId, String token, String dmApiPortal, String insertsFolder, TDRestServiceUtil tdRestServiceUtil) {
        try {
            DMApiCacheService dcs = new DMApiCacheService();
            dcs.insertId = insertId;
            dcs.token = token;
            dcs.dmApiPortal = dmApiPortal;
            dcs.insertsFolder = insertsFolder;
            dcs.tdRestServiceUtil = tdRestServiceUtil;
           // dcs.execute();
            return dcs.documentList;
        } catch (Exception e) {
            logger.error("getInsertInfo", e.getMessage(), e);
            throw ExceptionUtil.genRuntimeException(e);
        }
    }


    // Cache key method
    public String getInsertId() {
        return insertId;
    }

    
}