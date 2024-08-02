package main

import (
	"context"
	"log"
	"time"

	pb "github.com/stephen-bapple/jokes-on-the-go/protobuf/go/joke-service"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

/*
A Temporary test script that will be removed later.
*/
func main() {
	const addr = "localhost:50051"
	conn, err := grpc.NewClient(addr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("could not connect due to: %v", err)
	}
	defer conn.Close()
	client := pb.NewJokeServiceClient(conn)

	ctx, cancel := context.WithTimeout(context.Background(), time.Second)
	defer cancel()

	r, err := client.GetAnyRandomJoke(ctx, &pb.GetAnyRandomJokeRequest{})
	if err != nil {
		log.Fatalf("Could not ping due to %v", err)
	}
	log.Println(r.GetJoke().GetSetup())
	log.Println(r.GetJoke().GetPunchline())
}