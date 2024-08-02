SERVICE="joke-service"
export PATH="$PATH:$(go env GOPATH)/bin"
rm -rf $SERVICE/*.go
protoc --go_out=. --go_opt=paths=source_relative \
  --go-grpc_out=. --go-grpc_opt=paths=source_relative \
  $SERVICE/jokeserver.proto
