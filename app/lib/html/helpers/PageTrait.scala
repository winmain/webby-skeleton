package lib.html.helpers
import models.adm.AdmCookies
import webby.html.WebbyPage

trait PageTrait extends WebbyPage {
  override val scripts: Scripts = Scripts()
  val admCookies = new AdmCookies(cookies)
}
