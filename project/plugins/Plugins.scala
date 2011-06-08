import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val jawsyMavenReleases = "Jawsy.fi M2 releases" at "http://oss.jawsy.fi/maven2/releases"
  val jrebel = "fi.jawsy" % "sbt-jrebel-plugin" % "0.2.1"
  val vaadin = "fi.jawsy" % "sbt-vaadin-plugin" % "0.1.3"
}
