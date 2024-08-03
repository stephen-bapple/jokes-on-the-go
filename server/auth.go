package main

import (
	"context"
	"strings"

	jwt "github.com/golang-jwt/jwt/v5"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/metadata"
	"google.golang.org/grpc/status"
)

var (
	errMissingMetadata = status.Errorf(codes.InvalidArgument, "missing metadata")
	errInvalidToken    = status.Errorf(codes.Unauthenticated, "invalid token")
)

func validateJwtToken(authorization []string, secret string) bool {
	if len(authorization) < 1 {
		return false
	}
	rawToken := strings.TrimPrefix(authorization[0], "Bearer ")
	parseOpts := []jwt.ParserOption{
		// https://auth0.com/blog/critical-vulnerabilities-in-json-web-token-libraries/
		jwt.WithValidMethods([]string{jwt.SigningMethodHS256.Alg()}),
	}
	_, err := jwt.Parse(rawToken, func(*jwt.Token) (interface{}, error) {
		return []byte(secret), nil
	}, parseOpts...)

	return err == nil
}

type Interceptor = func(context.Context, any, *grpc.UnaryServerInfo, grpc.UnaryHandler) (any, error)

func makeValidator(secret string) (Interceptor) {
	return func (ctx context.Context, req any, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (any, error) {
		meta, ok := metadata.FromIncomingContext(ctx)
		if !ok {
			return nil, errMissingMetadata
		}
	
		if !validateJwtToken(meta["authorization"], secret) {
			return nil, errInvalidToken
		}
	
		return handler(ctx, req)
	}
	
}
