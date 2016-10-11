package models.route

import webby.route.v2.{BaseRoute, Route, RouteRoute}

/**
  * ------------------------------------- Localhost domain -------------------------------------
  *
  * Attention! No code formatting!
  */
trait RouteLocalhostTrait[R] extends BaseRoute[R] {
  protected val toDomain: String = "localhost:4820"

  def main: R =                                             get"/"
  def helloPage(name: String): R =                          get"/hello/$name"
}

object RouteLocalhost extends RouteRoute with RouteLocalhostTrait[Route]
