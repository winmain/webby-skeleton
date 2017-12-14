package views
import java.io.{File, FileInputStream}

import lib.html.HtmlView
import lib.html.helpers.PageTrait
import models.AppPaths
import models.route.RouteLocalhost
import webby.api.{App, Profile}
import webby.commons.io.{IOUtils, Url}
import webby.html.CommonTag

object Public {
  // -------------------- static css, js --------------------

  lazy val mainCss = CssAsset("main")

  lazy val mainJs = ScriptClosure("main")


  private def crcAsset(assetPath: String): Url = App.profile match {
    case Profile.Dev => RouteLocalhost._assets(assetPath)
    case _ => RouteLocalhost._assets(assetPath + "?" + crcFile(new File(AppPaths.assets.toFile, assetPath)))
  }
  private def crcFile(file: File): Long = {
    val stream: FileInputStream = new FileInputStream(file)
    try IOUtils.crc32(stream)
    finally stream.close()
  }

  case class CssAsset(name: String) {
    def pathInAssets: String = "css/" + name + ".css"
    val url = crcAsset(pathInAssets)
    def include(implicit view: HtmlView): CommonTag = view.linkStylesheet(url)
    def includeMedia(media: String)(implicit view: HtmlView): CommonTag = view.linkStylesheet(media, url)
  }

  case class ScriptClosure(name: String) {
    val url = crcAsset("js/" + name + ".js")
    private def getUrl(implicit page: PageTrait): Url =
      if (App.isDev && page.admCookies.jsClosure) RouteLocalhost._assetsJsGcc(name + ".js")
      else url
    def include(implicit page: PageTrait): Unit = page.scripts.addJsPart(name, getUrl.toString)
  }
}
