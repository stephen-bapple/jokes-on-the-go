import io.grpc.CallOptions
import io.grpc.ManagedChannel
import io.grpc.TlsChannelCredentials 
import io.grpc.ManagedChannelBuilder
import sb.jokesonthego.jokeservice.JokeServiceGrpcKt.JokeServiceCoroutineStub
import sb.jokesonthego.jokeservice.getAnyRandomJokeRequest
import sb.jokesonthego.jokeservice.GetAnyRandomJokeResponse
import java.io.Closeable
import java.util.concurrent.TimeUnit
import java.security.cert.CertificateFactory
import java.security.KeyStore
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

fun creatTLSChannel(): ManagedChannel {
    val caInput = object {}.javaClass.getResourceAsStream("/certs/ca-cert.pem")
    // val ca = CertificateFactory.getInstance("X.509").generateCertificate(caInput)
    // caInput.close()

    // val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
    // keyStore.load(null, null)
    // keyStore.setCertificateEntry("ca", ca)

    // val tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
    // tmf.init(keyStore)
    // val sslContext = SSLContext.getInstance("TLS")
    // sslContext.init(null, tmf.trustManagers, java.security.SecureRandom())
    
    val credentials = TlsChannelCredentials.newBuilder().trustManager(caInput).build()
    caInput.close()
    return ManagedChannelBuilder.forAddress("localhost", 50051).withCredentials(credentials).build()
}

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
    val client = JokeServiceClient(creatTLSChannel())
    val resp = client.getRandomJoke()
    println(resp)
}
