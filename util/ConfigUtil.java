package com.td.mbna.msec.midtier.util;

import com.td.coreapi.common.config.ApiConfig;
import com.td.mbna.msec.midtier.framework.FrameworkUtil;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;

/**
 * Mid-Tier
 * <p>
 * This class contains several utility methods that allow for the retrieval and processing of properties used to determine how requests from UI to MT should be handled.
 */
public final class ConfigUtil {
    // property name for folder containing mid tier properties
    public final static String CONFIG_FILE = "midtier.properties";
    // property name for file separator
    public final static String FS = System.getProperty("file.separator");
    // property name for config directory
    public final static String SYSTEM_PROPERTY_CONFIG_DIR = "mbna.config.dir";
    // property name for determining whether to use stub or not
    public final static String SYSTEM_PROPERTY_USE_STUB = "mbna.mt.useStub";
    // property name for determining whether to invoke TD WS or not
    public final static String SYSTEM_PROPERTY_INVOKE_TDWS = "mbna.mt.invokeTDws";
    // property name for determining whether audit service is enabled or not
    public final static String SYSTEM_PROPERTY_AUDIT_ACTIVE = "mbna.mt.auditservice.active";
    // property name for determining whether email service is enabled or not
    public final static String SYSTEM_PROPERTY_EMAIL_ACTIVE = "mbna.emailservice.active";
    // property name for mbna test
    public final static String SYSTEM_PROPERTY_TEST = "mbna.test";
    // property name for default hibernate schema
    public final static String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";
    // property name for value of highFidelity (WAS setting)
    public final static String SYSTEM_PROPERTY_HIFI = "jaxws.payload.highFidelity";
    // property name for transaction delay for testing purposes
    public final static String SYSTEM_PROPERTY_TRANSACTION_DELAY = "mbna.test.transaction.delay";
    // property name for transaction throttling to limit concurrent load to TD
    public final static String SYSTEM_PROPERTY_THROTTLING_DELAY = "mbna.transaction.throttling.delay";
    // property name for number of cheques for order cheques
    public final static String SYSTEM_PROPERTY_NUMBORDERCHEQUES = "ordercheques.numcheques.request";

    public final static String SYSTEM_PROPERTY_DEV_MODE = "mbna.dev.mode";
    public final static String SYSTEM_PROPERTY_CHCHE_ENABLED = "mbna.api.cache.enabled";

    public final static String SYSTEM_PROPERTY_ENFORCE_KYC = "mbna.enforce.KYC";

    public final static String SYSTEM_PROPERTY_KYC_UPDATE_PERIOD = "kyc.update.period";

    public final static String TD_API_CONNECT_TIMEOUT = "tdapi.connect.timeout";
    public final static String TD_API_READ_TIMEOUT = "tdapi.read.timeout";
    public final static String SPRING_PROFILES_ACTIVE = "spring.profiles.active";

    private final static String configDir;

    static {
        String tmpConfigDir = System.getProperty(ConfigUtil.SYSTEM_PROPERTY_CONFIG_DIR);
        if (tmpConfigDir != null && !tmpConfigDir.endsWith(FS)) {
            tmpConfigDir += "/";
        }
        configDir = tmpConfigDir;
    }


    public static boolean isTest() {
        return "true".equals(System.getProperty(ConfigUtil.SYSTEM_PROPERTY_TEST, "false"));
    }

    /**
     * get config directory
     */
    public static String getConfigDirectory() {
        return configDir;
    }

    private final static Properties MtProps = new Properties();
    ;

    static {
        try {
            if (Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_TEST, "false"))) {
                try (InputStream propsIn = ConfigUtil.class.getResourceAsStream("/test." + CONFIG_FILE)) {
                    MtProps.load(propsIn);
                }
            } else {
                String path = ConfigUtil.getConfigDirectory() + CONFIG_FILE;

                //try (InputStream propInputStream = (new ClassPathResource(path)).getInputStream()) {
                MtProps.load(ApiConfig.getInstance().getInputStreamFromFile(CONFIG_FILE));
                //}
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        if (getProperty(HIBERNATE_DEFAULT_SCHEMA) != null) {
            System.setProperty(HIBERNATE_DEFAULT_SCHEMA, getProperty(HIBERNATE_DEFAULT_SCHEMA));
        }

        if (getProperty(SYSTEM_PROPERTY_HIFI) != null) {
            System.setProperty(SYSTEM_PROPERTY_HIFI, getProperty(SYSTEM_PROPERTY_HIFI));
        }
    }

    /**
     * determeine whether to invoke TD WS or not
     */
    public static boolean invokeTDws(Class<?> tdservice, String loginId) {

        // whether MT should use stubbing at all
        if (inDevMode() == false) {    // in production mode
            return true;            // always invoke TD services no matter what
        }
        String invokeTDws = getProperty(SYSTEM_PROPERTY_INVOKE_TDWS, "false");
        boolean rc = Boolean.parseBoolean(invokeTDws);


        if (loginId != null && loginId.length() > 0 && (isLogonWithUcid(loginId))) {
            rc = true;
        }

        if (rc) {
            try {
                Method m = tdservice.getDeclaredMethod("isEnabled", (Class[]) null);
                rc = (Boolean) m.invoke(null, (Object[]) null);
            } catch (Exception e) {
                throw ExceptionUtil.genRuntimeException(e);
            }
        }
        return rc;
    }

    /**
     * whether MT should use stubbing at all
     */
    public static boolean useStub() {
        if (inDevMode() == false) {    // in production mode
            return false;            // disable reading from stub files
        }
        String globalUseStub = getProperty(SYSTEM_PROPERTY_USE_STUB, "false");
        return Boolean.parseBoolean(globalUseStub);
    }

    /**
     * set use stub value
     */
    public static void setUseStub(boolean value) {
        setProperty(SYSTEM_PROPERTY_USE_STUB, "" + value);
    }

    /**
     * whether MT should use stub impl for this operation
     */
    public static boolean useStub(Class<?> opClass) {
        if (inDevMode() == false) {    // in production mode
            return false;            // disable reading from stub files
        }
        return useStub(FrameworkUtil.getOpName(opClass));
    }

    /**
     * whether MT should use stub impl for this operation
     */
    public static boolean useStub(String opName) {
        if (inDevMode() == false) {        // in production mode
            return false;                // disable reading from stub files
        }
        boolean rc = false;
        if (useStub()) {
            String opUseStub = getProperty(SYSTEM_PROPERTY_USE_STUB + "." + opName, "true");
            rc = Boolean.parseBoolean(opUseStub);
        }
        return rc;
    }

    /**
     * whether MT should write audit log messages
     */
    public static boolean auditActive() {
        String auditActive = getProperty(SYSTEM_PROPERTY_AUDIT_ACTIVE, "true");
        return Boolean.parseBoolean(auditActive);
    }

    /**
     * whether MT should send email
     */
    public static boolean emailActive() {
        String emailActive = getProperty(SYSTEM_PROPERTY_EMAIL_ACTIVE, "true");
        return Boolean.parseBoolean(emailActive);
    }

    /**
     * Determine whether it's an MDM test login or not
     */
    public static boolean isLogonWithUcid(String loginId) {
        if (inDevMode() == false) {    // in production mode
            return false;            // disable UCID logon
        }
        if (loginId == null) {
            return false;
        }
        boolean rc;
        try {
            // If the login is all digits, then treat it as a test account and use the digits as the MDM key
            NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.CANADA);
            NUMBER_FORMAT.parse(loginId).longValue();
            rc = true;
        } catch (ParseException ignore) {
            rc = false;
        }
        return rc;
    }

    /**
     * get property from properties file
     */
    public static String getProperty(String propKey) {
        String value = MtProps.getProperty(propKey);
        if (value != null) {
            value = value.trim();
        }
        return value;
    }

    /**
     * set property in properties file
     */
    public static void setProperty(String propKey, String propValue) {
        MtProps.setProperty(propKey, propValue);
    }

    /**
     * get property from properties file
     */
    public static String getProperty(String propKey, String defaultValue) {
        String value = MtProps.getProperty(propKey, defaultValue);
        if (value != null) {
            value = value.trim();
        }
        return value;
    }

    /**
     * get number of cheques
     */
    public static String getNumberCheques() {
        return getProperty(SYSTEM_PROPERTY_NUMBORDERCHEQUES, "3");
    }

    // The mbna.dev.mode controls whether DEV-only (and potentially unsafe) features will be enabled
    public final static boolean inDevMode() {
        return Boolean.parseBoolean(getProperty(SYSTEM_PROPERTY_DEV_MODE, "false"));
    }

    public final static boolean isCacheEnabled() {
        return Boolean.parseBoolean(getProperty(SYSTEM_PROPERTY_CHCHE_ENABLED, "true"));
    }

    public static boolean isEnforceKYC() {
        String enforceKYC = getProperty(SYSTEM_PROPERTY_ENFORCE_KYC, "false");
        return Boolean.parseBoolean(enforceKYC);
    }

    public static int getKycUpdatePeriod() {
        return Integer.parseInt(getProperty(SYSTEM_PROPERTY_KYC_UPDATE_PERIOD, "30"));
    }

    public static boolean isTestProfile() {
        final var activeProfile = System.getProperty(SPRING_PROFILES_ACTIVE,"test");
        return activeProfile.equals("test");
    }
}