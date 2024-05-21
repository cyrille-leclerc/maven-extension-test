package com.cyrilleleclerc.maven.extension.jsr330;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Component that will be injected into Maven lifecycle listeners
 */
@Named
@Singleton
public class TestComponent {
    private final Logger logger = LoggerFactory.getLogger(TestComponent.class);

    @PreDestroy
    public void preDestroy() {
        logger.info("TestComponent.preDestroy");
    }
}
