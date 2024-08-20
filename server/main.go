package main

import (
	"context"
	"fmt"
	"log"
	"net"
	"os"
	"math/rand"
	pb "github.com/stephen-bapple/jokes-on-the-go/protobuf/go/joke-service"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"
)

const (
	// Realistically, this won't change.
	port = 50051
)

type server struct {
	pb.UnimplementedJokeServiceServer
}

func (s *server) GetAnyRandomJoke(ctx context.Context, in *pb.GetAnyRandomJokeRequest) (*pb.GetAnyRandomJokeResponse, error) {
	var hardCodedJokes = []pb.Joke{
		{
			Setup: "Why do seagulls live by the sea?",
			Punchline: "Because if they lived by the bay, they'd be bay-gulls.",
		},
		{
			Setup: "Why couldn't the bicycle stand up straight?",
			Punchline: "It was two-tired",
		},
	}
	harcodedJoke := &hardCodedJokes[rand.Intn(2)]

	return &pb.GetAnyRandomJokeResponse{
		Joke: harcodedJoke,
	}, nil
}

func main() {
	jwtSecret := os.Getenv("JWT_SECRET")
	if jwtSecret == "" {
		log.Fatalf("Cannot start server with JWT_SECRET present in environment")
	}

	tlsCredentials, err := credentials.NewServerTLSFromFile("certs/server-cert.pem", "certs/server-key.pem")
	if err != nil {
		log.Fatalf("failed to load key pair: %s", err)
	}
	opts := []grpc.ServerOption{
		grpc.UnaryInterceptor(makeValidator(jwtSecret)),
		grpc.Creds(tlsCredentials),
	}

	s := grpc.NewServer(opts...)
	pb.RegisterJokeServiceServer(s, &server{})
	
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		log.Fatalf("failed to listen: %v", err)
	}
	log.Printf("server listening at %v", lis.Addr())
	if err := s.Serve(lis); err != nil {
		log.Fatalf("failed to serve: %v", err)
	}
}
