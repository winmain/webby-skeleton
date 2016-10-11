package models.route

import webby.route.v2.{RouteConfigV2, RoutePack}
import webby.route.{BasePathSplitter, OneDomainProvider, SimpleBasePathSplitterWithAdmEqual}

object RouteConfig extends RouteConfigV2 {
  def basePathSplitter: BasePathSplitter = SimpleBasePathSplitterWithAdmEqual

  override def routePacks: Array[RoutePack[_]] = Array(
    RoutePack(HandlersLocalhost, RouteLocalhost, new OneDomainProvider("localhost"))
  )
}
