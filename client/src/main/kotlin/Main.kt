import io.github.cdimascio.dotenv.dotenv
import io.grpc.ManagedChannel
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder
import io.grpc.Metadata
import io.grpc.stub.MetadataUtils
import sb.jokesonthego.jokeservice.JokeServiceGrpcKt.JokeServiceCoroutineStub
import sb.jokesonthego.jokeservice.getAnyRandomJokeRequest
import sb.jokesonthego.jokeservice.GetAnyRandomJokeResponse
import java.io.Closeable
import java.util.concurrent.TimeUnit

fun createTLSChannel(): ManagedChannel {
    val path = "/certs/ca-cert.pem"
    val caInput = object {}.javaClass.getResourceAsStream(path)
        ?: throw IllegalArgumentException("CA certificate not found in $path")
    val sslContext = GrpcSslContexts.forClient().trustManager(caInput).build()
    caInput.close()
    return NettyChannelBuilder.forTarget("localhost:50051").sslContext(sslContext).build()
}

class JokeServiceClient(private val channel: ManagedChannel, private val apiKey: String) : Closeable {
    private val stub: JokeServiceCoroutineStub = run {
        val header = Metadata()
        val authorizationKey = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER)
        header.put(authorizationKey, "Bearer $apiKey")

        JokeServiceCoroutineStub(channel).withInterceptors(
            MetadataUtils.newAttachHeadersInterceptor(header)
        )
    }

    suspend fun getRandomJoke(): GetAnyRandomJokeResponse {
        val request = getAnyRandomJokeRequest {}
        val response = stub.getAnyRandomJoke(request)
        return response
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}

suspend fun main() {
    val client = JokeServiceClient(createTLSChannel(), dotenv()["API_KEY"])
    val resp = client.getRandomJoke()
    println(resp)
}
