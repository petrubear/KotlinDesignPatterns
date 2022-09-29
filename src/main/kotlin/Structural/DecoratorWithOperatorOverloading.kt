interface StarTrekRepositoryOp {
    operator fun get(starshipName: String): String
    operator fun set(starshipName: String, captainName: String)
}

class DefaultStarkTrekRepositoryOp : StarTrekRepositoryOp {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")
    override operator fun get(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override operator fun set(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}

// "by" indica que la interfaz StarTrekRepository se implementa por el objeto que se le pasa
class LoggingGetCaptainOp(private val repository: StarTrekRepositoryOp) :
        StarTrekRepositoryOp by repository {
    override fun get(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository[starshipName]
    }
}

class ValidatingAddCaptainOp(private val repository: StarTrekRepositoryOp) :
        StarTrekRepositoryOp by repository {
    private val maxLen = 15
    override fun set(starshipName: String, captainName: String) {
        require(captainName.length < maxLen) { "Captain name must be less than $maxLen characters" }
        repository[starshipName] =  captainName
    }
}

fun main() {
    val starTrekRepository = DefaultStarkTrekRepositoryOp()
    val withValidating = ValidatingAddCaptainOp(starTrekRepository)
    val withLoggingAndValidating = LoggingGetCaptainOp(withValidating)
    withLoggingAndValidating["USS Enterprise"]
    withLoggingAndValidating["USS Voyager"] = "Kathryn"
}
