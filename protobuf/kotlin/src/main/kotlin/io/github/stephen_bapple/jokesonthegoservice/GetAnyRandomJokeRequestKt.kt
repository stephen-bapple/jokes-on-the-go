// Generated by the protocol buffer compiler. DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: protobuf/jokeserver.proto

// Generated files should ignore deprecation warnings
@file:Suppress("DEPRECATION")
package io.github.stephen_bapple.jokesonthegoservice;

@kotlin.jvm.JvmName("-initializegetAnyRandomJokeRequest")
public inline fun getAnyRandomJokeRequest(block: io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequestKt.Dsl.() -> kotlin.Unit): io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest =
  io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequestKt.Dsl._create(io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.newBuilder()).apply { block() }._build()
/**
 * Protobuf type `jokeserver.GetAnyRandomJokeRequest`
 */
public object GetAnyRandomJokeRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  public class Dsl private constructor(
    private val _builder: io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.Builder
  ) {
    public companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest = _builder.build()
  }
}
@kotlin.jvm.JvmSynthetic
public inline fun io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest.copy(block: `io.github.stephen_bapple.jokesonthegoservice`.GetAnyRandomJokeRequestKt.Dsl.() -> kotlin.Unit): io.github.stephen_bapple.jokesonthegoservice.GetAnyRandomJokeRequest =
  `io.github.stephen_bapple.jokesonthegoservice`.GetAnyRandomJokeRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

