// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: protobuf/jokeserver.proto
// Protobuf Java Version: 4.27.1

package io.github.stephenbapple.jokesonthegoservice;

public final class JokeServerProto {
  private JokeServerProto() {}
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 27,
      /* patch= */ 1,
      /* suffix= */ "",
      JokeServerProto.class.getName());
  }
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jokeserver_GetAnyRandomJokeRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jokeserver_GetAnyRandomJokeRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jokeserver_GetAnyRandomJokeResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jokeserver_GetAnyRandomJokeResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_jokeserver_Joke_descriptor;
  static final 
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_jokeserver_Joke_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\031protobuf/jokeserver.proto\022\njokeserver\"" +
      "\031\n\027GetAnyRandomJokeRequest\":\n\030GetAnyRand" +
      "omJokeResponse\022\036\n\004joke\030\001 \001(\0132\020.jokeserve" +
      "r.Joke\"(\n\004Joke\022\r\n\005setup\030\001 \001(\t\022\021\n\tpunchli" +
      "ne\030\002 \001(\t2\332\001\n\013JokeService\022_\n\020GetAnyRandom" +
      "Joke\022#.jokeserver.GetAnyRandomJokeReques" +
      "t\032$.jokeserver.GetAnyRandomJokeResponse\"" +
      "\000\022j\n\033TriggerUpdateForPackageTest\022#.jokes" +
      "erver.GetAnyRandomJokeRequest\032$.jokeserv" +
      "er.GetAnyRandomJokeResponse\"\000B\204\001\n+io.git" +
      "hub.stephenbapple.jokesonthegoserviceB\017J" +
      "okeServerProtoP\001ZBgithub.com/stephen-bap" +
      "ple/jokes-on-the-go/protobuf/go/joke-ser" +
      "viceb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_jokeserver_GetAnyRandomJokeRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_jokeserver_GetAnyRandomJokeRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_jokeserver_GetAnyRandomJokeRequest_descriptor,
        new java.lang.String[] { });
    internal_static_jokeserver_GetAnyRandomJokeResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_jokeserver_GetAnyRandomJokeResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_jokeserver_GetAnyRandomJokeResponse_descriptor,
        new java.lang.String[] { "Joke", });
    internal_static_jokeserver_Joke_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_jokeserver_Joke_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_jokeserver_Joke_descriptor,
        new java.lang.String[] { "Setup", "Punchline", });
    descriptor.resolveAllFeaturesImmutable();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
