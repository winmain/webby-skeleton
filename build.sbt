name := "webby-skeleton"

version := "1.0"

scalaVersion := "2.12.4"

resolvers += Resolver.bintrayRepo("citrum", "maven")

// Webby library
libraryDependencies += "com.github.citrum.webby" %% "webby" % "0.7.2"

// Haxe support
libraryDependencies += "com.github.citrum.webby" % "webby-haxe" % "0.7.2" classifier "haxe"

// SASS support
libraryDependencies += "io.bit3" % "jsass" % "5.5.3" % "optional" // Used in webby.mvc.script.compiler.LibSassCompiler

// Google Closure Compiler & Library
libraryDependencies += "com.google.javascript" % "closure-compiler" % "v20170124" exclude("com.google.guava", "guava") // Guava already imported by webby
libraryDependencies += "org.clojure" % "google-closure-library" % "0.0-20160609-f42b4a24" // Google Closure Library

// Webrunner support.
mainClass in wr := Some("lib.server.DevServer")
// TODO: Change port for webrunner web client
wrWebServerPort := 4822
wrRestartExitCode := Some(2)

// Haxe support for development
haxeIdeaSettings
javaOptions in wr ++= haxeCompilerJavaParams.value
