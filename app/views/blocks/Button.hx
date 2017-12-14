package views.blocks;

class Button {
  // ------------------------------- Classes -------------------------------

  public static inline var cls: String = "button";

  public static inline var blueMod: String = cls + "--blue";
  public static inline var greenMod: String = cls + "--green";
  public static inline var disabledMod: String = cls + "--disabled";

  // ------------------------------- Api -------------------------------

  // Patch all buttons
  public static function init(): Void {
    for (tag in Tag.findAllByCls(cls)) {
      patchButton(tag);
    }
  }

  // ------------------------------- Private & protected methods -------------------------------

  private static function patchButton(tag: Tag) {
    tag.onClick(function() {
      G.alert(tag.getHtml() + ' pressed.\nThis code is called from Button.hx class');
    });
  }
}
