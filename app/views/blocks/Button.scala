package views.blocks
import lib.html.{HtmlView, ModBuilder}

/**
  * Button is a BEM component example
  *
  * @see https://tech.yandex.com/bem/
  */
object Button {
  // ------------------------------- Classes -------------------------------

  val cls: String = "button"

  val blueMod: String = cls + "--blue"
  val greenMod: String = cls + "--green"
  val disabledMod: String = cls + "--disabled"

  // ------------------------------- Api -------------------------------

  def a(implicit v: HtmlView) = new ModBuilder(this, v.a.cls(cls))

  def buttonButton(implicit v: HtmlView) = new ModBuilder(this, v.buttonButton.cls(cls))

  def buttonSubmit(implicit v: HtmlView) = new ModBuilder(this, v.buttonSubmit.cls(cls))
}
