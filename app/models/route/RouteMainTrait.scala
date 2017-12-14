package models.route

import webby.mvc.script.{StdRouteAssetsTrait, StdRouteJsSourceMapTrait}
import webby.route.v2.{BaseRoute, Route, RouteRoute}

/**
  * ------------------------------------- Localhost domain -------------------------------------
  *
  * Attention! No code formatting!
  */
trait RouteLocalhostTrait[R] extends BaseRoute[R] with StdRouteAssetsTrait[R] with StdRouteJsSourceMapTrait[R] {
  protected val toDomain: String = "localhost:4820"

  def main: R =                                             get"/"
  def helloPage(name: String): R =                          get"/hello/$name"
}

object RouteLocalhost extends RouteRoute with RouteLocalhostTrait[Route]
