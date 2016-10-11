package views

import lib.html.HtmlView
import models.route.RouteLocalhost
import webby.api.mvc.SimpleAction
import webby.mvc.StdCtl

object MainCtl extends StdCtl {
  def main = SimpleAction {req =>
    new HtmlView() {
      DOCTYPE_html
      htmlTag {
        bodyTag {
          h1 ~ "Webby main page"

          a.href(RouteLocalhost.helloPage("webby")) ~ "Greet webby"
        }
      }
    }.resultOk
  }

  def helloPage(name: String) = SimpleAction {req =>
    Ok("Hello, " + name + "!")
  }
}
