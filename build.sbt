name := "webby-skeleton"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Local Nexus" at "http://nexus/content/groups/public"
resolvers += Resolver.bintrayRepo("citrum", "maven")

libraryDependencies += "com.github.citrum.webby" %% "webby" % "0.2.16"

// Webrunner support.
mainClass in wr := Some("lib.server.DevServer")
// TODO: Change port for webrunner web client
wrWebServerPort := 4822
wrRestartExitCode := Some(2)
