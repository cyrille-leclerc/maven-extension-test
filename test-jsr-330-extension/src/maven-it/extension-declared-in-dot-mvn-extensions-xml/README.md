Test case using a Maven extension declaring it in the `.mvn/extensions.xml` file. 

To run this integration test:

* Build and install in the local Maven repository the `test-jsr-330-extension` Maven extension project:
  ```shell
  cd test-jsr-330-extension
  mvn clean install
  ```
* Run the integration test:
  ```shell
  cd maven-it/ extension-declared-in-dot-mvn-extensions-xml
  mvn verify
  ```
  
The extension should be used during the build and the integration test should pass.

The actual behaviour is successful with the following message:

```shell
mvn verify                                        
[INFO] TestJsr330EventSpy initialized with component: com.cyrilleleclerc.maven.extension.jsr330.TestComponent@6107165
[INFO] TestJsr330EventSpy.init(org.apache.maven.cli.event.DefaultEventSpyContext@5a00eb1e)
[INFO] TestJsr330MavenLifecycleParticipant initialized with component: com.cyrilleleclerc.maven.extension.jsr330.TestComponent@6107165
[INFO] TestJsr330MavenLifecycleParticipant.afterSessionStart(org.apache.maven.execution.MavenSession@3a543f31)
[INFO] Scanning for projects...
[INFO] TestJsr330MavenLifecycleParticipant.afterProjectsRead(org.apache.maven.execution.MavenSession@3a543f31)
[INFO] TestJsr330EventSpy.onSessionStarted()
[INFO] TestJsr330EventSpy.onProjectStarted(MavenProject: com.cyrilleleclerc.maven.extension.test:test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml:0.1-SNAPSHOT @ /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-dot-mvn-extensions-xml/pom.xml)
[INFO] 
[INFO] --< com.cyrilleleclerc.maven.extension.test:test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml >--
[INFO] Building test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml 0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] TestJsr330EventSpy.onMojoStarted(phase=process-resources, maven-resources-plugin:resources)
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-dot-mvn-extensions-xml/src/main/resources
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=process-resources, maven-resources-plugin:resources)
[INFO] TestJsr330EventSpy.onMojoStarted(phase=compile, maven-compiler-plugin:compile)
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=compile, maven-compiler-plugin:compile)
[INFO] TestJsr330EventSpy.onMojoStarted(phase=process-test-resources, maven-resources-plugin:testResources)
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-dot-mvn-extensions-xml/src/test/resources
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=process-test-resources, maven-resources-plugin:testResources)
[INFO] TestJsr330EventSpy.onMojoStarted(phase=test-compile, maven-compiler-plugin:testCompile)
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[INFO] No sources to compile
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=test-compile, maven-compiler-plugin:testCompile)
[INFO] TestJsr330EventSpy.onMojoStarted(phase=test, maven-surefire-plugin:test)
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[INFO] No tests to run.
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=test, maven-surefire-plugin:test)
[INFO] TestJsr330EventSpy.onMojoStarted(phase=package, maven-jar-plugin:jar)
[INFO] 
[INFO] --- jar:3.4.1:jar (default-jar) @ test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml ---
[WARNING] JAR will be empty - no content was marked for inclusion!
[INFO] Building jar: /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-dot-mvn-extensions-xml/target/test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml-0.1-SNAPSHOT.jar
[INFO] TestJsr330EventSpy.onMojoSucceeded(phase=package, maven-jar-plugin:jar)
[INFO] TestJsr330EventSpy.onProjectSucceeded(MavenProject: com.cyrilleleclerc.maven.extension.test:test-jsr-330-extension-it-extension-declared-in-dot-mvn-extensions-xml:0.1-SNAPSHOT @ /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-dot-mvn-extensions-xml/pom.xml)
[INFO] TestJsr330EventSpy.onSessionEnded()
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.635 s
[INFO] Finished at: 2024-08-19T23:44:31+02:00
[INFO] ------------------------------------------------------------------------
[INFO] TestJsr330MavenLifecycleParticipant.afterSessionEnd(org.apache.maven.execution.MavenSession@3a543f31)
[INFO] TestJsr330EventSpy.close()
[INFO] TestComponent.preDestroy
SomeClass.doSomething
```