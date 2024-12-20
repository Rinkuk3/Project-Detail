package com.td.mbna.msec.midtier.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * Spring Bean Provider
 *
 */
public class SpringBeanProvider {
	
	// bean service
    public static final String BEAN_Service = "SpringServiceImpl.xml";
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext(BEAN_Service);
    }
    
    /**
     * Get application context
     * @return
     */
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }
}
