package main

import (
	"context"
	"strings"

	jwt "github.com/golang-jwt/jwt/v5"
	"google.golang.org/grpc"
	"google.golang.org/grpc/metadata"
)

func validateJwtToken(authorization []string) bool {
	if len(authorization) < 1 {
		return false
	}
	rawToken := strings.TrimPrefix(authorization[0], "Bearer ")
	parseOpts := []jwt.ParserOption{
		// https://auth0.com/blog/critical-vulnerabilities-in-json-web-token-libraries/
		jwt.WithValidMethods([]string{jwt.SigningMethodHS256.Alg()}),
	}
	_, err := jwt.Parse(rawToken, func(*jwt.Token) (interface{}, error) {
		return []byte(jwtSecret), nil
	}, parseOpts...)

	return err == nil
}

func validateRequestToken(ctx context.Context, req any, info *grpc.UnaryServerInfo, handler grpc.UnaryHandler) (any, error) {
	meta, ok := metadata.FromIncomingContext(ctx)
	if !ok {
		return nil, errMissingMetadata
	}

	if !validateJwtToken(meta["authorization"]) {
		return nil, errInvalidToken
	}

	return handler(ctx, req)
}
