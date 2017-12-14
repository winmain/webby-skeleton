package lib.mvc

import models.AppPaths
import webby.mvc.script.compiler.ExternalHaxeCompiler
import webby.mvc.script.{GccSourceMapConfig, GoogleClosure, GoogleClosureServerBuilder}


object GoogleClosureServers {
  def builder(profile: String): GoogleClosureServerBuilder = {
    GoogleClosure.serverBuilder
      .jsSourceDir(AppPaths.profile(profile))
      .addJsSourceDirs(AppPaths.haxeCp)
      .preCompiler(new ExternalHaxeCompiler(profile, AppPaths))
      .extern(AppPaths.assets.resolve("js/externs/app.js"))
      .remapEntryPoints(Map(
        // For Haxe - map js entry point names to Haxe classes (note for '.js' extension)
        "main.js" -> "MainEntryPoint.js"))
      .sourceMapConfig(GccSourceMapConfig())
      .jsErrorRenderer
      .muteGCCWarnings(true) // for haxe compiler
  }

  def forTests(): GoogleClosureServerBuilder = {
    import java.nio.file.Paths.get
    GoogleClosure.serverBuilder
      .addJsSourceDirs(AppPaths.haxeCp)
      .preCompiler(new ExternalHaxeCompiler(profile = "test", AppPaths))
      .targetDir(get("app-js/out"))
      .targetGccDir(get("app-js/out"))
      .muteGCCWarnings(true)
  }
}


/**
  * To run Google Closure Compiler in production profile.
  */
object GoogleClosureAdvancedCompiler {
  def main(args: Array[String]) {
    require(args.length == 1, "Must be one arg: profile name")

    GoogleClosure.runAdvancedCompiler(
      AppPaths,
      GoogleClosureServers.builder(args(0)),
      // List all js entry points with '.js' extension
      Seq("main"))
  }
}
