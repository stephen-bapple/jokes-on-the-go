package main

import (
	"context"
	"fmt"
	"log"
	"net"
	"os"
	pb "github.com/stephen-bapple/jokes-on-the-go/protobuf/go/joke-service"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/credentials"
	"google.golang.org/grpc/status"
)

const (
	// Realistically, this won't change.
	port = 50051
)
var (
	errMissingMetadata = status.Errorf(codes.InvalidArgument, "missing metadata")
	errInvalidToken    = status.Errorf(codes.Unauthenticated, "invalid token")
	jwtSecret string
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
	jwtSecret = os.Getenv("JWT_SECRET")
	if jwtSecret == "" {
		log.Fatalf("Cannot start server with JWT_SECRET present in environment")
	}

	tlsCredentials, err := credentials.NewServerTLSFromFile("certs/server-cert.pem", "certs/server-key.pem")
	if err != nil {
		log.Fatalf("failed to load key pair: %s", err)
	}
	opts := []grpc.ServerOption{
		grpc.UnaryInterceptor(validateRequestToken),
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
