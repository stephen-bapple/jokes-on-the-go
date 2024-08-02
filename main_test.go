package main

import (
	"errors"
	"fmt"
	"net"

	"github.com/google/go-cmp/cmp"
	"github.com/google/go-cmp/cmp/cmpopts"

	"testing"
)

type fakeListener struct{}

func (lis fakeListener) Accept() (net.Conn, error) {
	return nil, nil
}

func (lis fakeListener) Close() error {
	return nil
}

func (lis fakeListener) Addr() net.Addr {
	return nil
}

func makeFakeListener() (net.Listener, error) {
	return fakeListener{}, nil
}

type fakeServer struct{}

func (f *fakeServer) Serve(net.Listener) error {
	return nil
}

func makeFakeServer() (Servable, error) {
	return &fakeServer{}, nil
}

func TestMakeServer(t *testing.T) {
	errorChecker := cmpopts.EquateErrors()
	listenerError := errors.New("I CAN'T HEAR YOU")
	listenerProviderThatErrs := func() (net.Listener, error) {
		return nil, listenerError
	}

	t.Run("should_err_if_listener_cannot_start", func(t *testing.T) {
		options := ServerOptions{injectListener: listenerProviderThatErrs, injectNewRPCServer: makeFakeServer}

		_, err := MakeServer(options)
		if diff := cmp.Diff(listenerError, err, errorChecker); diff != "" {
			t.Fatalf(diff)
		}
	})

	t.Run("should_not_return_server_on_error", func(t *testing.T) {
		options := ServerOptions{injectListener: listenerProviderThatErrs, injectNewRPCServer: makeFakeServer}
		svc, _ := MakeServer(options)
		if svc != nil {
			t.Fatalf("created a server despite erroring")
		}
	})

	t.Run("should_return_a_new_server", func(t *testing.T) {
		var thePlantedServer = &fakeServer{}
		options := ServerOptions{
			injectListener: makeFakeListener,
			injectNewRPCServer: func() (Servable, error) {
				return &fakeServer{}, nil
			},
		}
		svc, err := MakeServer(options)
		if diff := cmp.Diff(thePlantedServer, svc); diff != "" {
			t.Fatalf(diff)
		}
		if diff := cmp.Diff(nil, err, errorChecker); diff != "" {
			t.Fatalf(diff)
		}
	})

	t.Run("should_err_if_cannot_inject_server", func(t *testing.T) {
		expectedError := errors.New("No server for you")
		options := ServerOptions{
			injectListener: makeFakeListener,
			injectNewRPCServer: func() (Servable, error) {
				return &fakeServer{}, expectedError
			},
		}
		svc, err := MakeServer(options)
		var diffs []string
	
		if diff := cmp.Diff(expectedError, err, errorChecker); diff != "" {
			diffs = append(diffs, diff)
		}
		if diff := cmp.Diff(nil, svc); diff != "" {
			diffs = append(diffs, diff)
		}
		if len(diffs) != 0 {
			fmt.Println(len(diffs))
			t.Fatalf("Test failed, errors: %v", diffs)
		}
	})
}
