import fi.jawsy.sbtplugins.jrebel.JRebelWebPlugin
import fi.jawsy.sbtplugins.vaadin.VaadinPlugin
import sbt._

class VaadinSkeleton(info: ProjectInfo) extends DefaultWebProject(info) with JRebelWebPlugin with VaadinPlugin {

  object Versions {
    val gwt = "2.0.4"
    val geronimoServlet = "1.2"
    val jetty = "7.0.2.v20100331"
    val vaadin = "6.6.1"
  }

  val geronimoServletSpec = "org.apache.geronimo.specs" % "geronimo-servlet_2.5_spec" % Versions.geronimoServlet % "provided"
  val gwtDev = "com.google.gwt" % "gwt-dev" % Versions.gwt
  val gwtUser = "com.google.gwt" % "gwt-user" % Versions.gwt
  val vaadin = "com.vaadin" % "vaadin" % Versions.vaadin

  val jettyServer = "org.eclipse.jetty" % "jetty-server" % Versions.jetty % "test"
  val jettyWebapp = "org.eclipse.jetty" % "jetty-webapp" % Versions.jetty % "test"

  val localMaven = "Local Maven Repository" at "file://" + Path.userHome + "/.m2/repository"

  override def jettyContextPath = "/vaadinskel"
  override def jettyRunClasspath = super.jettyRunClasspath +++ ("lib_local") +++ ("lib_local" ** "*.jar")
  override def compileClasspath = super.compileClasspath --- (managedDependencyRootPath ** ("*-sources.jar" | "*-javadoc.jar"))
  override def publicClasspath = super.publicClasspath --- (managedDependencyRootPath ** ("*-sources.jar" | "*-javadoc.jar"))

  override def ivyXML =
    <dependencies>
      <exclude org="javax.servlet" module="servlet-api" />
    </dependencies>

  override def vaadinWidgetSet = "vaadinskel.WidgetSet"
  override def vaadinCompilerJvmArgs = List("-Xmx256M", "-XX:MaxPermSize=128M")

}
