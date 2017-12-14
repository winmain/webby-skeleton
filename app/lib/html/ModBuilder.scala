package lib.html

import webby.html.CommonTag

/**
  * Class for convenient usage of modifiers while building a tag.
  *
  * Example usage in template:
  * {{{
  *   Pane.div.mods(_.whiteWithShadowMod, _.bottomMarginMod) {
  *     ...
  *   }
  * }}}
  *
  * Example usage in element:
  * {{{
  *   def div(implicit v: HtmlView) = new ModBuilder(this, v.div)
  * }}}
  */
class ModBuilder[Type, Tag <: CommonTag](tpe: Type, tag: Tag) {
  final def mods(mod1: Type => String): Tag =
    tag.cls(mod1(tpe))

  final def mods(mod1: Type => String,
                 mod2: Type => String): Tag =
    tag.cls(mod1(tpe)).cls(mod2(tpe))

  final def mods(mod1: Type => String,
                 mod2: Type => String,
                 mod3: Type => String): Tag =
    tag.cls(mod1(tpe)).cls(mod2(tpe)).cls(mod3(tpe))

  final def mods(mod1: Type => String,
                 mod2: Type => String,
                 mod3: Type => String,
                 mod4: Type => String): Tag =
    tag.cls(mod1(tpe)).cls(mod2(tpe)).cls(mod3(tpe)).cls(mod4(tpe))

  final def mods(mod1: Type => String,
                 mod2: Type => String,
                 mod3: Type => String,
                 mod4: Type => String,
                 mod5: Type => String): Tag =
    tag.cls(mod1(tpe)).cls(mod2(tpe)).cls(mod3(tpe)).cls(mod4(tpe)).cls(mod5(tpe))

  final def mods(mod1: Type => String,
                 mod2: Type => String,
                 mod3: Type => String,
                 mod4: Type => String,
                 mod5: Type => String,
                 mod6: Type => String): Tag =
    tag.cls(mod1(tpe)).cls(mod2(tpe)).cls(mod3(tpe)).cls(mod4(tpe)).cls(mod5(tpe)).cls(mod6(tpe))
}
