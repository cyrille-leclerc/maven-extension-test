package com.cyrilleleclerc.maven.extension.jsr330;

import org.apache.maven.eventspy.AbstractEventSpy;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.plugin.MojoExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class TestJsr330EventSpy extends AbstractEventSpy {
    private final Logger logger = LoggerFactory.getLogger(TestJsr330EventSpy.class);

    @Override
    public void init(Context context) throws Exception {
        super.init(context);
        logger.info("TestJsr330EventSpy.init(" + context + ")");
    }

    @Override
    public void onEvent(Object event) throws Exception {
        super.onEvent(event);
        if (event instanceof ExecutionEvent) {
            ExecutionEvent executionEvent = (ExecutionEvent) event;
            if (executionEvent.getType() == ExecutionEvent.Type.SessionStarted) {
                logger.info("TestJsr330EventSpy.onSessionStarted()");
            } else if (executionEvent.getType() == ExecutionEvent.Type.SessionEnded) {
                logger.info("TestJsr330EventSpy.onSessionEnded()");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectStarted) {
                logger.info("TestJsr330EventSpy.onProjectStarted(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectSucceeded) {
                logger.info("TestJsr330EventSpy.onProjectSucceeded(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectFailed) {
                logger.info("TestJsr330EventSpy.onProjectFailed(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoStarted) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestJsr330EventSpy.onMojoStarted(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoSucceeded) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestJsr330EventSpy.onMojoSucceeded(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoFailed) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestJsr330EventSpy.onMojoFailed(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            }
        } else {
            logger.debug("TestJsr330EventSpy.onEvent(" + event.getClass() + ", " + event + ")");
        }
    }

    @Override
    public void close() throws Exception {
        super.close();
        logger.info("TestJsr330EventSpy.close()");
    }
}
