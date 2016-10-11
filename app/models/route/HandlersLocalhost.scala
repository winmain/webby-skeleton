package models.route

import views.MainCtl
import webby.api.mvc.Handler
import webby.route.v2.RouteHandlers

object HandlersLocalhost extends RouteHandlers with RouteLocalhostTrait[Handler] {
  override def main: Handler = MainCtl.main
  override def helloPage(name: String): Handler = MainCtl.helloPage(name)
}
