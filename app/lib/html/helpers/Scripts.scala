package lib.html.helpers

import webby.html.{HtmlBuffer, PageScripts, PageScriptsCommonPrepender}

/**
  * Специальный класс, созданный для удобства описания скриптов в конце страницы.
  * Экземпляр этого класса обычно передаётся через implicit параметр, и вставляется в главном шаблоне
  * в конце страницы кодом scripts.printForPage, либо если это подгружаемый js-код, то через метод scripts.printForJs
  */
case class Scripts() extends PageScripts

object Scripts {
  private val commonPrepender = new PageScriptsCommonPrepender("assets/js/raw/prepend.js", "assets/js/raw/prepend-dev.js")

  def prependForPage()(implicit buf: HtmlBuffer): Unit = commonPrepender.prependForPage()
}
