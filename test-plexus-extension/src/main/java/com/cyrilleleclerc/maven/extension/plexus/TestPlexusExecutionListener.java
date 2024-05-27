package com.cyrilleleclerc.maven.extension.plexus;

import org.apache.maven.execution.AbstractExecutionListener;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.execution.ExecutionListener;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(role = ExecutionListener.class)
public class TestPlexusExecutionListener extends AbstractExecutionListener {
    private final Logger logger = LoggerFactory.getLogger(TestPlexusExecutionListener.class);

    @Requirement(role = TestComponent.class)
    private  TestComponent testComponent;

    @Override
    public void sessionStarted(ExecutionEvent event) {
        super.sessionStarted(event);
        logger.info("TestPlexusExecutionListener.sessionStarted(" + event + ")");
    }

    @Override
    public void projectStarted(ExecutionEvent event) {
        super.projectStarted(event);
        logger.info("TestPlexusExecutionListener.projectStarted(" + event + ")");
    }

    @Override
    public void projectSucceeded(ExecutionEvent event) {
        super.projectSucceeded(event);
        logger.info("TestPlexusExecutionListener.projectSucceeded(" + event + ")");
    }

    @Override
    public void projectFailed(ExecutionEvent event) {
        super.projectFailed(event);
        logger.info("TestPlexusExecutionListener.projectFailed(" + event + ")");
    }

    @Override
    public void mojoStarted(ExecutionEvent event) {
        super.mojoStarted(event);
        logger.info("TestPlexusExecutionListener.mojoStarted(" + event + ")");
    }

    @Override
    public void mojoSucceeded(ExecutionEvent event) {
        super.mojoSucceeded(event);
        logger.info("TestPlexusExecutionListener.mojoSucceeded(" + event + ")");
    }

    @Override
    public void mojoFailed(ExecutionEvent event) {
        super.mojoFailed(event);
        logger.info("TestPlexusExecutionListener.mojoFailed(" + event + ")");
    }

    @Override
    public void sessionEnded(ExecutionEvent event) {
        super.sessionEnded(event);
        logger.info("TestPlexusExecutionListener.sessionEnded(" + event + ")");
    }
}
