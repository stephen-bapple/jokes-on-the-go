package main

import (
	"fmt"
	"net"
)

type ServerOptions struct {
	injectListener     func() (net.Listener, error)
	injectNewRPCServer func() (Servable, error)
}

type Servable interface {
	Serve(lis net.Listener) error
}

type TechDebtServer struct{}

func (t *TechDebtServer) Serve(net.Listener) error { return nil }

func MakeServer(options ServerOptions) (Servable, error) {
	_, err := options.injectListener()
	if err != nil {
		return nil, err
	}

	svc, err := options.injectNewRPCServer()
	if err != nil {
		return nil, err
	}

	return svc, nil
}

func main() {
	fmt.Println("Hello program structure")
}
