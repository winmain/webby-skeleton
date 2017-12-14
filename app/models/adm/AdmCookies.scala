package models.adm

import webby.api.mvc.{Cookies, PlainResult, Request, RequestHeader}

/**
  * Простой класс, определяющий есть ли у юзера заданные админские печеньки.
  */
class AdmCookies(cookies: Cookies) {

  import AdmCookies._

  lazy val jsClosure: Boolean = cookies.contains(JsClosure)
  lazy val jsSourceMap: Boolean = cookies.contains(JsSourceMap)

  // Add your cookies here
}

object AdmCookies {
  /** Использовать скомпилированный и оптимизированный js в dev режиме (как в продакшне) */
  val JsClosure = "_webby_js_closure"

  /** Доступ к javascript source maps */
  val JsSourceMap = "_webby_js_sourcemap"

  // Add your cookies here

  def apply(request: RequestHeader) = new AdmCookies(request.cookies)

  def withCookies(block: AdmCookies => PlainResult)(implicit request: Request[_]): PlainResult = block(apply(request))
}
