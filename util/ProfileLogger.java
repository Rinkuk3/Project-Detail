package com.td.mbna.msec.midtier.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ProfileLogger implements CommandLineRunner {
    private static MbnaLogger logger = new MbnaLogger(ProfileLogger.class);

    @Autowired
    private Environment environment;

    @Override
    public void run(String... args) throws Exception {
        String[] activeProfiles = environment.getActiveProfiles();
        logger.debug("Active Spring profile(s): " + Arrays.toString(activeProfiles));
        logger.debug("Server port: " + environment.getProperty("server.port"));
        logger.debug("Debug: " + environment.getProperty("debug"));
        logger.debug("Allow bean definition overriding: " + environment.getProperty("spring.main.allow-bean-definition-overriding"));
    }
}
