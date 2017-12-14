package views

import lib.html.HtmlView
import lib.html.helpers.{Page, Scripts}
import models.route.RouteLocalhost
import views.blocks.Button
import webby.api.mvc.SimpleAction
import webby.mvc.StdCtl

object MainCtl extends StdCtl {
  def main = SimpleAction {req =>
    implicit val page = new Page(req)
    new HtmlView() {
      DOCTYPE_html
      htmlTag {
        headTag {
          // Add link to `main.css` style
          Public.mainCss.include
          // Inline some scripts in the page header
          Scripts.prependForPage()
        }
        bodyTag {
          h1 ~ "Webby main page"

          p {
            +"See " + code ~ "views.MainCtl" + " class for this page source"
          }
          p {
            a.href(RouteLocalhost.helloPage("webby")) ~ "Greet webby"
          }

          div.style("margin-top:30px") {
            Button.buttonButton.mods(_.blueMod) ~ "blue button"
            Button.buttonButton.mods(_.greenMod).style("margin-left:20px") ~ "green button"
            Button.buttonButton.mods(_.disabledMod).style("margin-left:20px") ~ "disabled button"
          }

          // Include `main.js` asynchronous script to the `page.scripts`
          Public.mainJs.include
          // Print all page scripts here
          page.scripts.printForPage()
        }
      }
    }.resultOk
  }

  def helloPage(name: String) = SimpleAction {req =>
    Ok("Hello, " + name + "!")
  }
}
