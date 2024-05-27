# Maven Extension Test

Test the differences of behavior of Maven Extension APIs between Plexus and JSR-330/Sisu

<table><tbody>

<tr><th>Maven Extension API</th><th>Maven Event</th><th colspan="4">Extension loading mechanism</th></tr>

<tr><td></td><td></td><td>${maven.home}/lib/ext</td><td>mvn -Dmaven.ext.class.path=</td><td>pom.xml's &lt;extensions&gt;</td><td>.mvn/extensions.xml</td></tr>

<tr><td colspan="6"><hr/></td></tr>

<tr><td>JSR330</td><td>AbstractExecutionListener</td><td> 🔴 </td><td> 🔴 </td><td> 🔴 </td><td> 🔴 </td></tr>

<tr><td>JSR330</td><td>AbstractMavenLifecycleParticipant#afterSessionStart</td><td> 🟢 </td><td> 🟢 </td><td> 🔴 </td><td> 🟢 </td></tr>

<tr><td>JSR330</td><td>AbstractMavenLifecycleParticipant#afterProjectsRead</td><td> 🟢 </td><td> 🟢 </td><td> 🟢 </td><td> 🟢 </td></tr>

<tr><td>JSR330</td><td>AbstractMavenLifecycleParticipant#afterSessionEnd</td><td> 🟢 </td><td> 🟢 </td><td> 🟢 </td><td> 🟢 </td></tr>

<tr><td>JSR330</td><td>AbstractEventSpy#init</td><td> 🟢 </td><td> 🟢 </td><td> 🔴 </td><td> 🟢 </td></tr>

<tr><td>JSR330</td><td>AbstractEventSpy#onEvent</td><td> 🟢 </td><td> 🟢 </td><td> 🔴 </td><td> 🟢 </td></tr>

<tr><td>JSR330</td><td>AbstractEventSpy#close</td><td> 🟢 </td><td> 🟢 </td><td> 🔴 </td><td> 🟢 </td></tr>

<tr><td colspan="6"><hr/></td></tr>

<tr><td>Plexus</td><td>AbstractExecutionListener</td><td> 🔴 </td><td> 🔴 </td><td> 🔴 </td><td> 🔴 </td></tr>

<tr><td>Plexus</td><td>AbstractMavenLifecycleParticipant#afterSessionStart</td><td> 🟢 </td><td>  🟢  </td><td> 🔴 </td><td> 🟢 </td></tr>

<tr><td>Plexus</td><td>AbstractMavenLifecycleParticipant#afterProjectsRead</td><td> 🟢 </td><td>  🟢  </td><td> 🟢 </td><td> 🟢 </td></tr>

<tr><td>Plexus</td><td>AbstractMavenLifecycleParticipant#afterSessionEnd</td><td> 🟢 </td><td>  🟢  </td><td> 🟢 </td><td> 🟢 </td></tr>

<tr><td>Plexus</td><td>AbstractEventSpy#init</td><td> 🟢 </td><td>  🟢 </td><td> 🔴 </td><td>  🟢 </td></tr>

<tr><td>Plexus</td><td>AbstractEventSpy#onEvent</td><td> 🟢 </td><td>  🟢 </td><td> 🔴 </td><td>  🟢 </td></tr>

<tr><td>Plexus</td><td>AbstractEventSpy#close</td><td> 🟢 </td><td>  🟢 </td><td> 🔴 </td><td>  🟢 </td></tr>

</tbody></table>


* Documentation
    * https://maven.apache.org/maven-jsr330.html
    * https://github.com/eclipse/sisu.plexus/wiki/Plexus-to-JSR330
* The maven-sisu-plugin with `@Named` and `@Inject` just generates `META-INF/sisu/javax.inject.Named`
* When in the past, the `plexus-component-metadata:generate-metadata` did generate `META-INF/plexus/components.xml`
* Don't forget to update `META-INF/maven/extension.xml`, see https://maven.apache.org/ref/3.9.6/maven-core/extension.html
