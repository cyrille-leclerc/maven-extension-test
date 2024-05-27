package com.cyrilleleclerc.maven.extension.plexus;

import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Disposable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Component that will be injected into Maven lifecycle listeners
 */
@Component(role = TestComponent.class, hint = "test-component")
public class TestComponent implements Initializable, Disposable {
    private final Logger logger = LoggerFactory.getLogger(TestComponent.class);

    @Override
    public void dispose() {
        logger.info("TestComponent.dispose");
    }

    @Override
    public void initialize() {
        logger.info("TestComponent.initialize");
    }
}
