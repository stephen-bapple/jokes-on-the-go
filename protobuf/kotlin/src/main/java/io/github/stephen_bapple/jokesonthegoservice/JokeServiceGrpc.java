package io.github.stephen_bapple.jokesonthegoservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: protobuf/jokeserver.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JokeServiceGrpc {

  private JokeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "jokeserver.JokeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
      io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnyRandomJoke",
      requestType = io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.class,
      responseType = io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
      io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJokeMethod() {
    io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest, io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJokeMethod;
    if ((getGetAnyRandomJokeMethod = JokeServiceGrpc.getGetAnyRandomJokeMethod) == null) {
      synchronized (JokeServiceGrpc.class) {
        if ((getGetAnyRandomJokeMethod = JokeServiceGrpc.getGetAnyRandomJokeMethod) == null) {
          JokeServiceGrpc.getGetAnyRandomJokeMethod = getGetAnyRandomJokeMethod =
              io.grpc.MethodDescriptor.<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest, io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnyRandomJoke"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JokeServiceMethodDescriptorSupplier("GetAnyRandomJoke"))
              .build();
        }
      }
    }
    return getGetAnyRandomJokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
      io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJoke2TestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnyRandomJoke2Test",
      requestType = io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.class,
      responseType = io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
      io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJoke2TestMethod() {
    io.grpc.MethodDescriptor<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest, io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getGetAnyRandomJoke2TestMethod;
    if ((getGetAnyRandomJoke2TestMethod = JokeServiceGrpc.getGetAnyRandomJoke2TestMethod) == null) {
      synchronized (JokeServiceGrpc.class) {
        if ((getGetAnyRandomJoke2TestMethod = JokeServiceGrpc.getGetAnyRandomJoke2TestMethod) == null) {
          JokeServiceGrpc.getGetAnyRandomJoke2TestMethod = getGetAnyRandomJoke2TestMethod =
              io.grpc.MethodDescriptor.<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest, io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnyRandomJoke2Test"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse.getDefaultInstance()))
              .setSchemaDescriptor(new JokeServiceMethodDescriptorSupplier("GetAnyRandomJoke2Test"))
              .build();
        }
      }
    }
    return getGetAnyRandomJoke2TestMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JokeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JokeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JokeServiceStub>() {
        @java.lang.Override
        public JokeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JokeServiceStub(channel, callOptions);
        }
      };
    return JokeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JokeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JokeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JokeServiceBlockingStub>() {
        @java.lang.Override
        public JokeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JokeServiceBlockingStub(channel, callOptions);
        }
      };
    return JokeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JokeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JokeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JokeServiceFutureStub>() {
        @java.lang.Override
        public JokeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JokeServiceFutureStub(channel, callOptions);
        }
      };
    return JokeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getAnyRandomJoke(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request,
        io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnyRandomJokeMethod(), responseObserver);
    }

    /**
     */
    default void getAnyRandomJoke2Test(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request,
        io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnyRandomJoke2TestMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service JokeService.
   */
  public static abstract class JokeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return JokeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service JokeService.
   */
  public static final class JokeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<JokeServiceStub> {
    private JokeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JokeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JokeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAnyRandomJoke(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request,
        io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnyRandomJokeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnyRandomJoke2Test(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request,
        io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnyRandomJoke2TestMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service JokeService.
   */
  public static final class JokeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<JokeServiceBlockingStub> {
    private JokeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JokeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JokeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse getAnyRandomJoke(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnyRandomJokeMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse getAnyRandomJoke2Test(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnyRandomJoke2TestMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service JokeService.
   */
  public static final class JokeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<JokeServiceFutureStub> {
    private JokeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JokeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JokeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getAnyRandomJoke(
        io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnyRandomJokeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse> getAnyRandomJoke2Test(
        io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnyRandomJoke2TestMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ANY_RANDOM_JOKE = 0;
  private static final int METHODID_GET_ANY_RANDOM_JOKE2TEST = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ANY_RANDOM_JOKE:
          serviceImpl.getAnyRandomJoke((io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest) request,
              (io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>) responseObserver);
          break;
        case METHODID_GET_ANY_RANDOM_JOKE2TEST:
          serviceImpl.getAnyRandomJoke2Test((io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest) request,
              (io.grpc.stub.StreamObserver<io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetAnyRandomJokeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
              io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>(
                service, METHODID_GET_ANY_RANDOM_JOKE)))
        .addMethod(
          getGetAnyRandomJoke2TestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest,
              io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeResponse>(
                service, METHODID_GET_ANY_RANDOM_JOKE2TEST)))
        .build();
  }

  private static abstract class JokeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JokeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.github.stephen_bapple.jokesonthegoservice.JokeServerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JokeService");
    }
  }

  private static final class JokeServiceFileDescriptorSupplier
      extends JokeServiceBaseDescriptorSupplier {
    JokeServiceFileDescriptorSupplier() {}
  }

  private static final class JokeServiceMethodDescriptorSupplier
      extends JokeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    JokeServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JokeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JokeServiceFileDescriptorSupplier())
              .addMethod(getGetAnyRandomJokeMethod())
              .addMethod(getGetAnyRandomJoke2TestMethod())
              .build();
        }
      }
    }
    return result;
  }
}
