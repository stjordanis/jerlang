# jerlang

[Erlang/OTP](https://github.com/erlang/otp) on the [Java Virtual Machine](https://en.wikipedia.org/wiki/Java_virtual_machine) (JVM)

[![Build Status](https://img.shields.io/travis/jerlang/jerlang.svg?branch=master&style=flat)](https://travis-ci.org/jerlang/jerlang)
[![Dependency Status](https://www.versioneye.com/user/projects/55acc9853065350023000481/badge.svg?style=flat)](https://www.versioneye.com/user/projects/55acc9853065350023000481)

## Status

* Very early stage of development.
* Not able to run Erlang.
* Looking for contributors.

## Roadmap

|Version|Focus|Milestone|
|:-----:|-----|---------|
|0.1    |File Format     |BEAM files can be parsed|
|0.2    |Proof of Concept|A simple "hello world" can be interpreted|
|0.3    |Interpreter     |Most single-node applications can be interpreted|
|0.4    |Network         |Most multi-node applications can be interpreted|
|0.5    |Compiler        |BEAM files can be compiled to Java bytecode|
|0.6    |Scheduler       |Soft realtime support|
|0.7    |Compatibility   |Jerlang is fully compatible with native Erlang/OTP|
|0.8    |Documentation   |The documentation is complete and awesome|
|0.9    |Performance     |Performance is comparable to native Erlang/OTP|
|1.0    |Stability       |Jerlang is production ready|

## Contribution Process

All contributions are welcome!

This project uses the [C4.1 process](http://rfc.zeromq.org/spec:22)
for all code changes.

> "Everyone, without distinction or discrimination,
> SHALL have an equal right to become a Contributor
> under the terms of this contract."

### tl;dr

1. Check for [open issues](https://github.com/jerlang/jerlang/issues) or
[open a new issue](https://github.com/jerlang/jerlang/issues/new) to start
a discussion around a feature idea or a bug
2. Fork the [jerlang repository on Github](https://github.com/jerlang/jerlang)
to start making your changes
3. Write a test which shows that the bug was fixed or that the feature works
as expected
4. Send a pull request
5. Your pull request is merged and you are added to the
[list of contributors](https://github.com/jerlang/jerlang/graphs/contributors)

## See also

* [erjang](https://github.com/trifork/erjang)

## License

[Apache 2.0 License](LICENSE)
