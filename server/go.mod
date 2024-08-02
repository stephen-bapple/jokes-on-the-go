module github.com/stephen-bapple/jokes-on-the-go/server

go 1.22.5

require google.golang.org/grpc v1.65.0

require google.golang.org/protobuf v1.34.2 // indirect

require (
	github.com/stephen-bapple/jokes-on-the-go/joke-service v0.0.0-20240727182245-87e683967802
	golang.org/x/net v0.25.0 // indirect
	golang.org/x/sys v0.20.0 // indirect
	golang.org/x/text v0.15.0 // indirect
	google.golang.org/genproto/googleapis/rpc v0.0.0-20240528184218-531527333157 // indirect
)

replace github.com/stephen-bapple/jokes-on-the-go/joke-service v0.0.0 => ../joke-service
