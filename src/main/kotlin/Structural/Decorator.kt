interface StarTrekRepository {
    fun getCaptain(starshipName: String): String
    fun addCaptain(starshipName: String, captainName: String)
}

class DefaultStarkTrekRepository : StarTrekRepository {
    private val starshipCaptains = mutableMapOf("USS Enterprise" to "Jean-Luc Picard")
    override fun getCaptain(starshipName: String): String {
        return starshipCaptains[starshipName] ?: "Unknown"
    }

    override fun addCaptain(starshipName: String, captainName: String) {
        starshipCaptains[starshipName] = captainName
    }
}

// "by" indica que la interfaz StarTrekRepository se implementa por el objeto que se le pasa
class LoggingGetCaptain(private val repository: StarTrekRepository) :
        StarTrekRepository by repository {
    override fun getCaptain(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository.getCaptain(starshipName)
    }
}

class ValidatingAddCaptain(private val repository: StarTrekRepository) :
        StarTrekRepository by repository {
    private val maxLen = 15
    override fun addCaptain(starshipName: String, captainName: String) {
        require(captainName.length < maxLen) { "Captain name must be less than $maxLen characters" }
        repository.addCaptain(starshipName, captainName)
    }
}

fun main() {
    val starTrekRepository = DefaultStarkTrekRepository()
    val withValidating = ValidatingAddCaptain(starTrekRepository)
    val withLoggingAndValidating = LoggingGetCaptain(withValidating)
    withLoggingAndValidating.getCaptain("USS Enterprise")
    withLoggingAndValidating.addCaptain("USS Voyager", "Kathryn Janeway")
}
