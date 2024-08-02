#!/usr/bin/env bash

# See https://github.com/grpc/grpc-kotlin/blob/master/compiler/README.md
DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
java -jar $DIR/protoc-gen-grpc-kotlin-1.4.1-jdk8.jar "$@"