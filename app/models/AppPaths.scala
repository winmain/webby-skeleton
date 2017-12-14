package models
import webby.mvc.StdPaths
import webby.mvc.StdPaths.{AppWatchAssetType, AssetType}

/**
  * Common paths used by the application
  */
object AppPaths extends StdPaths.Value with StdPaths.HaxeValue {
  override def cssAssetType: AssetType = AppWatchAssetType("css")
}

object GlobalPaths {
}
