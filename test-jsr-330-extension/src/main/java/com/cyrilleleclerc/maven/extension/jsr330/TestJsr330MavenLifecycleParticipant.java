package com.cyrilleleclerc.maven.extension.jsr330;

import org.apache.maven.AbstractMavenLifecycleParticipant;
import org.apache.maven.MavenExecutionException;
import org.apache.maven.execution.MavenSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class TestJsr330MavenLifecycleParticipant extends AbstractMavenLifecycleParticipant {
    private final Logger logger = LoggerFactory.getLogger(TestJsr330MavenLifecycleParticipant.class.getName());

    @Override
    public void afterProjectsRead(MavenSession session) throws MavenExecutionException {
        super.afterProjectsRead(session);
        logger.info("TestJsr330MavenLifecycleParticipant.afterProjectsRead(" + session + ")");
    }

    @Override
    public void afterSessionStart(MavenSession session) throws MavenExecutionException {
        super.afterSessionStart(session);
        logger.info("TestJsr330MavenLifecycleParticipant.afterSessionStart(" + session + ")");
    }

    @Override
    public void afterSessionEnd(MavenSession session) throws MavenExecutionException {
        super.afterSessionEnd(session);
        logger.info("TestJsr330MavenLifecycleParticipant.afterSessionEnd(" + session + ")");
    }
}
