Test case using a Maven extension declaring it in the `<build><extensions>...</extensions></build>` section
of a `pom.xml` file. 

To run this integration test:

* Build and install in the local Maven repository the `test-jsr-330-extension` Maven extension project:
  ```shell
  cd test-jsr-330-extension
  mvn clean install
  ```
* Run the integration test:
  ```shell
  cd maven-it/extension-declared-in-pom-xml
  mvn verify
  ```
  
The extension should be used during the build and the integration test should pass.

The actual behaviour is that the test will fail with the following error message:

```shell
mvn verify                         
[INFO] Scanning for projects...
[INFO] TestJsr330MavenLifecycleParticipant initialized with component: com.cyrilleleclerc.maven.extension.jsr330.TestComponent@2add4d24
[INFO] TestJsr330MavenLifecycleParticipant.afterProjectsRead(org.apache.maven.execution.MavenSession@12b5454f)
[INFO] 
[INFO] --< com.cyrilleleclerc.maven.extension.test:test-jsr-330-extension-it-extension-declared-in-dot-pom-xml >--
[INFO] Building test-jsr-330-extension-it-extension-declared-in-dot-pom-xml 0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-pom-xml/src/main/resources
[INFO] 
[INFO] --- compiler:3.13.0:compile (default-compile) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[INFO] Nothing to compile - all classes are up to date.
[INFO] 
[INFO] --- resources:3.3.1:testResources (default-testResources) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/cyrilleleclerc/git/cyrille-leclerc/maven-extension-test/test-jsr-330-extension/src/maven-it/extension-declared-in-pom-xml/src/test/resources
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[INFO] No sources to compile
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[INFO] No tests to run.
[INFO] 
[INFO] --- jar:3.4.1:jar (default-jar) @ test-jsr-330-extension-it-extension-declared-in-dot-pom-xml ---
[WARNING] JAR will be empty - no content was marked for inclusion!
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.738 s
[INFO] Finished at: 2024-08-19T23:45:55+02:00
[INFO] ------------------------------------------------------------------------
[INFO] TestJsr330MavenLifecycleParticipant.afterSessionEnd(org.apache.maven.execution.MavenSession@12b5454f)
[INFO] TestComponent.preDestroy
[WARNING] Problem stopping: public void com.cyrilleleclerc.maven.extension.jsr330.TestComponent.preDestroy()
java.lang.NoClassDefFoundError: com/cyrilleleclerc/maven/extension/jsr330/SomeClass
    at com.cyrilleleclerc.maven.extension.jsr330.TestComponent.preDestroy (TestComponent.java:21)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.eclipse.sisu.bean.BeanLifecycle.stop (BeanLifecycle.java:133)
    at org.eclipse.sisu.bean.LifecycleManager.unmanage (LifecycleManager.java:85)
    at org.eclipse.sisu.plexus.PlexusLifecycleManager.unmanage (PlexusLifecycleManager.java:177)
    at org.codehaus.plexus.DefaultPlexusContainer.dispose (DefaultPlexusContainer.java:592)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:296)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:203)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)
Caused by: java.lang.ClassNotFoundException: com.cyrilleleclerc.maven.extension.jsr330.SomeClass
    at org.codehaus.plexus.classworlds.strategy.SelfFirstStrategy.loadClass (SelfFirstStrategy.java:42)
    at org.codehaus.plexus.classworlds.realm.ClassRealm.unsynchronizedLoadClass (ClassRealm.java:225)
    at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass (ClassRealm.java:210)
    at org.codehaus.plexus.classworlds.realm.ClassRealm.loadClass (ClassRealm.java:205)
    at com.cyrilleleclerc.maven.extension.jsr330.TestComponent.preDestroy (TestComponent.java:21)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.eclipse.sisu.bean.BeanLifecycle.stop (BeanLifecycle.java:133)
    at org.eclipse.sisu.bean.LifecycleManager.unmanage (LifecycleManager.java:85)
    at org.eclipse.sisu.plexus.PlexusLifecycleManager.unmanage (PlexusLifecycleManager.java:177)
    at org.codehaus.plexus.DefaultPlexusContainer.dispose (DefaultPlexusContainer.java:592)
    at org.apache.maven.cli.MavenCli.doMain (MavenCli.java:296)
    at org.apache.maven.cli.MavenCli.main (MavenCli.java:203)
    at jdk.internal.reflect.DirectMethodHandleAccessor.invoke (DirectMethodHandleAccessor.java:103)
    at java.lang.reflect.Method.invoke (Method.java:580)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced (Launcher.java:255)
    at org.codehaus.plexus.classworlds.launcher.Launcher.launch (Launcher.java:201)
    at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode (Launcher.java:361)
    at org.codehaus.plexus.classworlds.launcher.Launcher.main (Launcher.java:314)
```