# Jokes on the Go - Server
Golang gRPC server for tracking all my dad jokes

This repository holds a small Golang server to implement the server-side stubs, a protobuf folder holding generated stubs, and a Kotlin client purely for testing the Kotlin stubs.

Because the generated stubs are in both Kotlin and Java (required by Kotlin gRPC library) the Github shows it as a Java/Kotlin repo despite the handwritten code being mostly Go and a smaller amount of Kotlin.

## Protobuf Releases
This repository publishes protobuf stubs for Kotlin clients whenever a release is generated in Github.

This feature leverages Github Actions to build the package and Github Packages to store it, making it available to any client (or server) that wishes to use the stubs.

Although the server uses the stubs directly through a Golang-specific local package trick, it could potentially install the stubs too. Although currently Golang stubs are not published, they could be.

## Platform Dependencies
The server uses Go modules and the protobuf stubs and test client use Gradle, but there are some prerequisites that need to be installed in order to generate protobuf stubs.

The following must be manually installed:
1. Golang
2. Protoc compiler
3. Golang protoc compiler plugins
4. Protoc gRPC plugin for Kotlin (1.4.1)
5. Protoc gRPC plugin for Java  (1.65.1)

Instructions for 1-3 can found here: https://grpc.io/docs/languages/go/quickstart/  
For 4, see https://github.com/grpc/grpc-kotlin/blob/master/compiler/README.md#manual-protoc-usage and download the .jar file. The script `protoc-gen-grpc-kotlin.sh` expects the file to have the name `protoc-gen-grpc-kotlin-1.4.1-jdk8.jar`.  
For 5, see https://github.com/grpc/grpc-java/blob/master/README.md#download  
However, I found it easier to just download an ELF from https://repo1.maven.org/maven2/io/grpc/protoc-gen-grpc-java/, although something like SDKMAN! is probably a better choice. Note that this executable must be named `protoc-gen-grpc-java` as the protoc compiler expects it.

I've included the versions for the separate compilers, but everything else is likely to be relatively stable and the latest versions should work.

## Scripts
### generate_proto.sh
Run `./generate_proto.sh` to generate both the Go protobuf stubs and the Kotlin protobuf stubs.

### protoc-gen-grpc-kotlin.sh
The script `./protoc-gen-grpc-kotlin.sh` is used as a facade to the .jar file plugin for kotlin code stub generation. The protoc compiler expects a direct executable, requiring wrapping the jar.
