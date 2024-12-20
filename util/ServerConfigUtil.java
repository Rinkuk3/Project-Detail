package com.td.mbna.msec.midtier.util;

import java.io.File;
import java.net.MalformedURLException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import ch.qos.logback.core.joran.spi.JoranException;
import com.td.coreapi.common.config.ApiConfig;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
public final class ServerConfigUtil {
    // property name for file separator
    public final static String FS = System.getProperty("file.separator");
    // property name for config directory
    public final static String SYSTEM_PROPERTY_CONFIG_DIR = "mbna.config.dir";
    // property name for mbna test
    public final static String SYSTEM_PROPERTY_TEST = "mbna.test";
    // property name for folder containing mid tier properties
    public final static String CONFIG_FILE = "midtier.properties";
    // property name for log folder
    public final static String SYSTEM_PROPERTY_LOG_DIR = "log.root.dir";

    public final static String SYSTEM_PROPERTY_DEV_MODE = "mbna.dev.mode";

    private static final String LOG4J2 = "log4j2_midtier.xml";

    private final static String configDir;

    static {
        String tmpConfigDir = System.getProperty(ServerConfigUtil.SYSTEM_PROPERTY_CONFIG_DIR);
        if (!tmpConfigDir.endsWith(FS)) {
            tmpConfigDir += FS;
        }
        configDir = tmpConfigDir;
    }


    public static boolean isTest() {
        return "true".equals(System.getProperty(ServerConfigUtil.SYSTEM_PROPERTY_TEST, "false"));
    }

    public static String getConfigDirectory() {
        return configDir;
    }

    private final static Properties MtProps = new Properties();

    static {
        try {
            if (Boolean.parseBoolean(System.getProperty(SYSTEM_PROPERTY_TEST, "false"))) {
                try (InputStream propsIn = ServerConfigUtil.class.getResourceAsStream("/test." + CONFIG_FILE)) {
                    MtProps.load(propsIn);
                }
            } else {
                String path = getConfigDirectory() + CONFIG_FILE;
                //try (FileReader fr = new FileReader(new File(path))) {
                //UiProps.load((new ClassPathResource(path)).getInputStream());
                //}
                MtProps.load(ApiConfig.getInstance().getInputStreamFromFile(CONFIG_FILE));
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() {
        String methodName = ServerConfigUtil.class.getName() + ":init() -- ";
        System.setProperty(SYSTEM_PROPERTY_LOG_DIR, "/td/logs/WebLogs/MSEC");
        if (getProperty(SYSTEM_PROPERTY_LOG_DIR) != null) {
            System.setProperty(SYSTEM_PROPERTY_LOG_DIR, getProperty(SYSTEM_PROPERTY_LOG_DIR));
        }
        try {
            String s = InetAddress.getLocalHost().getHostName();
//            System.out.println(methodName + "hostName:" + s);
            System.setProperty("hostName", s);
//			InitialContext ic = new javax.naming.InitialContext();
//			String serverName = ic.lookup("servername").toString();
//			System.setProperty("serverName",serverName);
//            System.out.println(methodName + "serverName:" + s);
           // System.setProperty("serverName", s);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        LoggerContext context = (LoggerContext) LogManager.getContext(false);
//        File file = new File(configDir + LOG4J2);
//        System.out.println(methodName + "Midtier log4j config file: " + file.toURI());
//        context.setConfigLocation(file.toURI());
//        System.setProperty("log4j.configurationFile", configDir + LOG4J2);

//        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
//        File file = new File(configDir, LOG4J2);
//        System.out.println(methodName + "Midtier log4j config file: " + file.toURI());
//        try{
//            JoranConfigurator configurator = new JoranConfigurator();
//            configurator.setContext(context);
//            context.reset();
//            configurator.doConfigure(file.toURI().toURL());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        } catch (JoranException e) {
//            throw new RuntimeException(e);
//        }
    }


    public static String getProperty(String propKey) {
        String value = MtProps.getProperty(propKey);
        if (value != null) {
        	value = value.trim();
        }
        return value;
    }

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


    // The mbna.dev.mode controls whether DEV-only (and potentially unsafe) features will be enabled
    public final static boolean inDevMode() {
        return Boolean.parseBoolean(getProperty(SYSTEM_PROPERTY_DEV_MODE, "false"));
    }
}