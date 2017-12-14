logLevel := Level.Warn

resolvers += Resolver.bintrayIvyRepo("citrum", "sbt-plugins")

// Common webby sbt plugins
addSbtPlugin("com.github.citrum.webby" % "webby-sbt-plugin" % "0.1.5")
addSbtPlugin("com.github.citrum.webby" % "sbt-web-runner" % "0.8.2")

// Haxe support
addSbtPlugin("com.github.citrum" % "sbt-haxe-idea" % "0.2.1")
