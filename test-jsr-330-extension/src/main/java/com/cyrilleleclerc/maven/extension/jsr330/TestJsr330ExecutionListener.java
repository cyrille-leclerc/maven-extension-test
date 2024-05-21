package com.cyrilleleclerc.maven.extension.jsr330;

import org.apache.maven.execution.AbstractExecutionListener;
import org.apache.maven.execution.ExecutionEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class TestJsr330ExecutionListener extends AbstractExecutionListener {
    private final Logger logger = LoggerFactory.getLogger(TestJsr330ExecutionListener.class);

    @Override
    public void sessionStarted(ExecutionEvent event) {
        super.sessionStarted(event);
        logger.info("TestJsr330ExecutionListener.sessionStarted(" + event + ")");
    }

    @Override
    public void projectStarted(ExecutionEvent event) {
        super.projectStarted(event);
        logger.info("TestJsr330ExecutionListener.projectStarted(" + event + ")");
    }

    @Override
    public void projectSucceeded(ExecutionEvent event) {
        super.projectSucceeded(event);
        logger.info("TestJsr330ExecutionListener.projectSucceeded(" + event + ")");
    }

    @Override
    public void projectFailed(ExecutionEvent event) {
        super.projectFailed(event);
        logger.info("TestJsr330ExecutionListener.projectFailed(" + event + ")");
    }

    @Override
    public void mojoStarted(ExecutionEvent event) {
        super.mojoStarted(event);
        logger.info("TestJsr330ExecutionListener.mojoStarted(" + event + ")");
    }

    @Override
    public void mojoSucceeded(ExecutionEvent event) {
        super.mojoSucceeded(event);
        logger.info("TestJsr330ExecutionListener.mojoSucceeded(" + event + ")");
    }

    @Override
    public void mojoFailed(ExecutionEvent event) {
        super.mojoFailed(event);
        logger.info("TestJsr330ExecutionListener.mojoFailed(" + event + ")");
    }

    @Override
    public void sessionEnded(ExecutionEvent event) {
        super.sessionEnded(event);
        logger.info("TestJsr330ExecutionListener.sessionEnded(" + event + ")");
    }
}
