package com.cyrilleleclerc.maven.extension.plexus;

import org.apache.maven.eventspy.AbstractEventSpy;
import org.apache.maven.eventspy.EventSpy;
import org.apache.maven.execution.ExecutionEvent;
import org.apache.maven.plugin.MojoExecution;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(role = EventSpy.class, hint = "test-plexus-event-spy")
public class TestPlexusEventSpy extends AbstractEventSpy implements Disposable {
    private final Logger logger = LoggerFactory.getLogger(TestPlexusEventSpy.class);

    @Requirement(role = TestComponent.class)
    private TestComponent testComponent;

    @Override
    public void init(Context context) throws Exception {
        super.init(context);
        logger.info("TestPlexusEventSpy.init(" + context + ")");
    }

    @Override
    public void onEvent(Object event) throws Exception {
        super.onEvent(event);
        if (event instanceof ExecutionEvent) {
            ExecutionEvent executionEvent = (ExecutionEvent) event;
            if (executionEvent.getType() == ExecutionEvent.Type.SessionStarted) {
                logger.info("TestPlexusEventSpy.onSessionStarted()");
            } else if (executionEvent.getType() == ExecutionEvent.Type.SessionEnded) {
                logger.info("TestPlexusEventSpy.onSessionEnded()");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectStarted) {
                logger.info("TestPlexusEventSpy.onProjectStarted(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectSucceeded) {
                logger.info("TestPlexusEventSpy.onProjectSucceeded(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.ProjectFailed) {
                logger.info("TestPlexusEventSpy.onProjectFailed(" + executionEvent.getProject() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoStarted) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestPlexusEventSpy.onMojoStarted(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoSucceeded) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestPlexusEventSpy.onMojoSucceeded(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            } else if (executionEvent.getType() == ExecutionEvent.Type.MojoFailed) {
                MojoExecution mojoExecution = executionEvent.getMojoExecution();
                String phase = mojoExecution.getLifecyclePhase();
                logger.info("TestPlexusEventSpy.onMojoFailed(phase=" + phase + ", " + mojoExecution.getArtifactId() + ":" + mojoExecution.getGoal() + ")");
            }
        } else {
            logger.debug("TestPlexusEventSpy.onEvent(" + event.getClass() + ", " + event + ")");
        }
    }


    @Override
    public void dispose() {
        logger.info("TestPlexusEventSpy.dispose()");
    }

    @Override
    public void close() throws Exception {
        super.close();
        logger.info("TestPlexusEventSpy.close()");
    }
}
