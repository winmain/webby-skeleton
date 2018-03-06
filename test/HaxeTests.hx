package ;

import foo.FooBarTest;
import haxe.unit.TestCase;
import test.HaxeTestRunner;

@globalPrepend("// scriptEntryPoint")
class HaxeTests {
  static function allTests(): Array<Class<TestCase>> return [
    FooBarTest
    // TODO: register your test classes here
  ];

  static function main() {
    HaxeTestRunner.main(allTests());
  }
}
