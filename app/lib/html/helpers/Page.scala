package lib.html.helpers
import webby.api.mvc.{RequestHeader, Result, WrappedRequestHeader}

class Page(val req: RequestHeader) extends WrappedRequestHeader(req) with PageTrait {
  override def mobile: Boolean = ???
  override def body: Array[Byte] = ???
  override def prependFinalizer(finalizer: (Result) => Result): Unit = ???
  override def throwResult(result: => Result): Nothing = ???
}
