SERVICE="joke-service"
GO_DIR="go"
KT_DIR="kotlin"

# Ensure go plugins are available
export PATH="$PATH:$(go env GOPATH)/bin"

# Clean directories
rm -rf $SERVICE/$GO_DIR/*
rm -rf $SERVICE/$KT_DIR/*
mkdir -p $SERVICE/$GO_DIR
mkdir -p $SERVICE/$KT_DIR

echo "$(pwd)"

# Generate Go stubs
protoc --go_out=$SERVICE/$GO_DIR --go_opt=paths=source_relative \
  --go-grpc_out=$SERVICE/$GO_DIR --go-grpc_opt=paths=source_relative \
  $SERVICE/jokeserver.proto

# Generate Kotlin stubs
# protoc --plugin=protoc-gen-grpckt=protoc-gen-grpc-kotlin.sh \
#   --grpckt_out="$SERVICE" \
#   $SERVICE/jokeserver.proto

echo "Finished generating gRPC stubs."
