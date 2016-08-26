package com.example;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4j2Config {

    @Bean
    public ConsoleAppender consoleAppender() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n");

        ConsoleAppender consoleAppender = new ConsoleAppender(patternLayout, ConsoleAppender.SYSTEM_OUT);
        consoleAppender.setName("Console");
        return consoleAppender;
    }

    @Bean
    public Logger rootLogger() {
        Logger logger = Logger.getRootLogger();
        logger.setLevel(Level.INFO);
        logger.addAppender(consoleAppender());
        return logger;
    }

}

