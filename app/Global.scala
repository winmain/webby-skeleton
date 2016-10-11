import models.route.RouteConfig
import webby.api._
import webby.api.mvc.{Handler, RequestHeader}
import webby.commons.concurrent.ExecutionPlugin
import webby.route.v2.RequestHandlerV2

import scala.collection.mutable
import scala.concurrent.ExecutionContext

object Global extends GlobalSettings {
  private var requestHandler: RequestHandlerV2 = _

  def reqHandler: RequestHandlerV2 = requestHandler

  override def onStart(app: Application) {
    implicit def executionContext: ExecutionContext = ExecutionPlugin.getExecutionContext

    // Обработчик запросов
    setRequestHandler()
  }

  override def createPlugins(app: Application): Iterable[Plugin] = {
    val p = mutable.Buffer[Plugin]()

    // TODO: register your plugins here

    p += new GlobalPlugin(app)
    p
  }

  override def onRouteRequest(request: RequestHeader): Option[Handler] = {
    requestHandler.handle(request)
  }

  private def setRequestHandler() {
    requestHandler = RouteConfig.parse.createRequestHandler
  }
}
