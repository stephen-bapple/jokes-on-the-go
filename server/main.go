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
			Punchline: "It was two-tired.",
		},
		{
			Setup: "I once submited 10 puns to a content to see which would win.",
			Punchline: "But no pun in-ten-did",
		},
		{
			Setup: "Which month has 28 days?",
			Punchline: "All of them do.",
		},
	}
	harcodedJoke := &hardCodedJokes[rand.Intn(4)]

	return &pb.GetAnyRandomJokeResponse{
		Joke: harcodedJoke,
	}, nil
}

func loadEnvOrAbort(varName string) string {
	envValue := os.Getenv(varName)
	if envValue == "" {
		log.Fatalf("Cannot start server without %s present in environment", varName)
	}
	return envValue
}

func main() {
	jwtSecret := loadEnvOrAbort("JWT_SECRET")
	certFile := loadEnvOrAbort("CERT_FILE")
	keyFile := loadEnvOrAbort("KEY_FILE")

	tlsCredentials, err := credentials.NewServerTLSFromFile(certFile, keyFile)
	if err != nil {
		log.Fatalf("Failed to load key pair: %s", err)
	}

	opts := []grpc.ServerOption{
		grpc.UnaryInterceptor(makeValidator(jwtSecret)),
		grpc.Creds(tlsCredentials),
	}

	s := grpc.NewServer(opts...)
	pb.RegisterJokeServiceServer(s, &server{})
	
	lis, err := net.Listen("tcp", fmt.Sprintf(":%d", port))
	if err != nil {
		log.Fatalf("Failed to listen: %v", err)
	}
	log.Printf("Server listening at %v", lis.Addr())
	if err := s.Serve(lis); err != nil {
		log.Fatalf("Failed to serve: %v", err)
	}
}
