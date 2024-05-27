package com.cyrilleleclerc.maven.extension.plexus;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(role = AbstractMavenLifecycleParticipant.class)
public class TestPlexusMavenLifecycleParticipant extends AbstractMavenLifecycleParticipant {
    private final Logger logger = LoggerFactory.getLogger(TestPlexusMavenLifecycleParticipant.class.getName());

    @Requirement(role = TestComponent.class)
    private TestComponent testComponent;

    @Override
    public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
        super.afterProjectsRead(session);
        logger.info("TestPlexusMavenLifecycleParticipant.afterProjectsRead(" + session + ")");
    }

    @Override
    public void afterSessionStart(MavenSession session) throws MavenExecutionException {
        super.afterSessionStart(session);
        logger.info("TestPlexusMavenLifecycleParticipant.afterSessionStart(" + session + ")");
    }

    @Override
    public void afterSessionEnd(MavenSession session) throws MavenExecutionException {
        super.afterSessionEnd(session);
        logger.info("TestPlexusMavenLifecycleParticipant.afterSessionEnd(" + session + ")");
    }
}
