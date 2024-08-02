import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import sb.jokesonthego.jokeservice.JokeServiceGrpcKt.JokeServiceCoroutineStub
import sb.jokesonthego.jokeservice.getAnyRandomJokeRequest
import sb.jokesonthego.jokeservice.GetAnyRandomJokeResponse
import java.io.Closeable
import java.util.concurrent.TimeUnit

class JokeServiceClient(private val channel: ManagedChannel) : Closeable {
    private val stub: JokeServiceCoroutineStub = JokeServiceCoroutineStub(channel)

    suspend fun getRandomJoke() : GetAnyRandomJokeResponse {
        val request = getAnyRandomJokeRequest {}
        val response = stub.getAnyRandomJoke(request)
        return response
    }

    override fun close() {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS)
    }
}

suspend fun main() {
    val channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build()
    val client = JokeServiceClient(channel)
    val resp = client.getRandomJoke()
    println(resp)
}
