package lib.server

import webby.core.server.WebbyDevServer

object DevServer extends WebbyDevServer(4820) {
  def main(args: Array[String]): Unit = {
    DevServer
  }
}
