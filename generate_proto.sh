# Define paths
PREFIX="github.com/stephen-bapple/jokes-on-the-go"
FOLDER="protobuf"
SERVICE="joke-service"
GO_DIR="go"
KT_ROOT="kotlin/src"
KT_DIR="$KT_ROOT/main/kotlin"
JAVA_DIR="$KT_ROOT/main/java"

# TODO: this seems fragile as it's specified in the .proto file as well.
GO_PACKAGE="$PREFIX/$FOLDER/$GO_DIR/$SERVICE"

# Ensure go plugins are available
export PATH="$PATH:$(go env GOPATH)/bin"

# Clean directories
rm -rf $FOLDER/$GO_DIR/*
rm -rf $FOLDER/$KT_ROOT/*
mkdir -p $FOLDER/$GO_DIR
mkdir -p $FOLDER/$KT_DIR
mkdir -p $FOLDER/$JAVA_DIR

# Generate Go stubs
protoc --go_out=. --go-grpc_out=. \
  --go_opt=module=$PREFIX --go-grpc_opt=module=$PREFIX \
  $FOLDER/jokeserver.proto

# Make it a real go package for easier usage.
pushd $FOLDER/$GO_DIR/$SERVICE
go mod init $GO_PACKAGE
go mod tidy
popd

# Generate Kotlin stubs
protoc --plugin=protoc-gen-grpckt=protoc-gen-grpc-kotlin.sh \
  --kotlin_out=$FOLDER/$KT_DIR --grpckt_out=$FOLDER/$KT_DIR \
  $FOLDER/jokeserver.proto

# Generate Java GRPC stubs - Kotlin needs these
protoc --plugin=protoc-gen-grpc-java \
  --java_out=$FOLDER/$JAVA_DIR --grpc-java_out=$FOLDER/$JAVA_DIR \
  $FOLDER/jokeserver.proto

echo "Finished generating gRPC stubs."
