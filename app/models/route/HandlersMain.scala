package models.route

import lib.mvc.GoogleClosureServers
import models.AppPaths
import models.adm.AdmCookies
import views.MainCtl
import webby.api.controllers.StaticCtl
import webby.api.controllers.StaticCtl.ResourceRestriction
import webby.api.mvc.Handler
import webby.mvc.script.{StdRouteAssetsUseSassHandlers, StdRouteJsSourceMapHandlers, StdScriptRouteUtils}
import webby.route.v2.RouteHandlers

object HandlersMain extends RouteHandlers with RouteLocalhostTrait[Handler] with StdRouteAssetsUseSassHandlers with StdRouteJsSourceMapHandlers {
  // Initialize RouteUtils to build JS via GCC and Haxe for development mode
  override object RouteUtils extends StdScriptRouteUtils(AppPaths, GoogleClosureServers.builder(_).build)
  // Restrict access to source maps only for users having cookie [[AdmCookies.JsSourceMap]]
  override val jsSourceMapRestriction: ResourceRestriction = StaticCtl.CookieRestriction(AdmCookies.JsSourceMap)

  // Route handlers

  override def main: Handler = MainCtl.main
  override def helloPage(name: String): Handler = MainCtl.helloPage(name)
}
