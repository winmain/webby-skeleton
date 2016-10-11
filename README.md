_webby-skeleton_ is a minimal working example using [webby].

## Usage

Run in shell

```shell
git clone https://github.com/citrum/webby-skeleton.git
cd webby-skeleton
sbt
```

Sbt commands:

* `wr` - run/restart server in forked process via webrunner
* `ws` - stop webrunner process
* `runMain lib.server.DevServer` - run server in sbt (type Enter to exit)

When server starts, point your browser to [http://localhost:4820](http://localhost:4820)

## License

_webby-skeleton_ is licensed under [Apache License 2.0].

  [webby]: https://github.com/citrum/webby
  [Apache License 2.0]: http://www.apache.org/licenses/LICENSE-2.0
