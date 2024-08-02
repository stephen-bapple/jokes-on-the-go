# jokes-on-the-go
Golang gRPC server for tracking all my dad jokes

## Dependencies
Currently there is no proper dependency management. And even if there was these steps would likely still be manual.

#TODO: Add versions.

The following must be manually installed:
1. Golang
2. Protoc compiler
3. Golang protoc compiler plugins
4. Protoc gRPC plugin for Kotlin
5. Protoc gRPC plugin for Java 

Instructions for 1-3 can found here: https://grpc.io/docs/languages/go/quickstart/
For 4, see https://github.com/grpc/grpc-kotlin/blob/master/compiler/README.md#manual-protoc-usage and download the .jar file. The script `protoc-gen-grpc-kotlin.sh` expects the file to have the name `protoc-gen-grpc-kotlin-1.4.1-jdk8.jar`.
For 5, see https://github.com/grpc/grpc-java/blob/master/README.md#download  
However, I found it easier to just download an ELF from https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/, although something like SDKMAN! is probably a better choice.

## Scripts
### generate_proto.sh
Run `./generate_proto.sh` to generate both the Go protobuf stubs and the Kotlin protobuf stubs.

### protoc-gen-grpc-kotlin.sh
The script `./protoc-gen-grpc-kotlin.sh` is used as a facade to the .jar file plugin for kotlin code stub generation. The protoc compiler expects a direct executable, requiring wrapping the jar.

## Directory
### client
This folder holds temporary test code for developing the server's capabilities. I am planning to replace it with a separate mobile app, perhaps in another repo.

### joke-service
This folder holds protobuf definitions and generated stubs.

### server
This folder holds the Go code for the gRPC server.
