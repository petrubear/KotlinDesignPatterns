class Server private constructor(port: Long) {
    init {
        println("Server started on port $port")
    }
    companion object {
        fun withPort(port: Long) = Server(port)
    }
}

fun main() {
    //val server = Server(8080) // cant do this, is private
    val server = Server.withPort(8080)
}