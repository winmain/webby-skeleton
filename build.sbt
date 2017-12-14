name := "webby-skeleton"

version := "1.0"

scalaVersion := "2.12.4"

resolvers += Resolver.bintrayRepo("citrum", "maven")

// Webby library
libraryDependencies += "com.github.citrum.webby" %% "webby" % "0.7.2"

// Haxe support
libraryDependencies += "com.github.citrum.webby" % "webby-haxe" % "0.7.2" classifier "haxe"

// Webrunner support.
mainClass in wr := Some("lib.server.DevServer")
// TODO: Change port for webrunner web client
wrWebServerPort := 4822
wrRestartExitCode := Some(2)
