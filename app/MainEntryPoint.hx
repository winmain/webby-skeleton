package ;

import views.blocks.Button;

@globalPrepend("// scriptEntryPoint")
@googProvide("main_js")
//@googRequire("script")
class MainEntryPoint {
  static function main() {
    Button.init();

    // Add your initialization here
  }
}
