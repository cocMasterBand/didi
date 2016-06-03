package com.diwa.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by di on 3/6/2016.
 */
public class BootStrap {
    private static final Logger logger = LoggerFactory.getLogger(BootStrap.class);

    public static void main(String[] args) {
        logger.info("BootStrap Main begin.");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/root-context.xml");

        String displayName = applicationContext.getDisplayName();

        System.out.println(displayName);

    }
}
