package main

import (
	"context"
	"fmt"
	"log"
	"net"
	pb "github.com/stephen-bapple/jokes-on-the-go/protobuf/go/joke-service"
	"google.golang.org/grpc"
)

const (
	// Realistically, this won't change.
	port = 50051
)

type server struct {
	pb.UnimplementedJokeServiceServer
}

func (s *server) GetAnyRandomJoke(ctx context.Context, in *pb.GetAnyRandomJokeRequest) (*pb.GetAnyRandomJokeResponse, error) {
	harcodedJoke := pb.Joke{
		Setup: "Why do seagulls live by the sea?",
		// Say it out loud :)
		Punchline: "Because if they lived by the bay, they'd be bay-gulls.",
	}

	return &pb.GetAnyRandomJokeResponse{
		Joke: &harcodedJoke,
	}, nil
}

func main() {
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}

	s := grpc.NewServer()
	pb.RegisterJokeServiceServer(s, &server{})

	log.Printf("server listening at %v", lis.Addr())
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
