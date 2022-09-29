data class Mail_V1(
        val to: List<String>,
        val cc: List<String>,
        val title: String?,
        val messange: String?,
        val important: Boolean,
)

class MailBuilder {
    private var to: List<String> = listOf()
    private var cc: List<String> = listOf()
    private var title: String = ""
    private var message: String = ""
    private var important: Boolean = false

    data class Mail
    internal constructor(
            val to: List<String>,
            val cc: List<String>,
            val title: String?,
            val message: String?,
            val important: Boolean,
    )

    fun build(): Mail {
        if (to.isEmpty()) {
            throw RuntimeException("To property is empty")
        }
        return Mail(to, cc, title, message, important)
    }

    fun to(to: List<String>): MailBuilder {
        this.to = to
        return this
    }

    fun message(message: String): MailBuilder {
        this.message = message
        return this
    }

    fun title(title: String): MailBuilder {
        this.title = title
        return this
    }

    fun important(important: Boolean): MailBuilder {
        this.important = important
        return this
    }
}

fun main() {
    val mail = Mail_V1(listOf("manager@company.com"), listOf(), "Ping", null, true)
    println(mail)
    val mail2 = MailBuilder()
                    .to(listOf("manager@company.com"))
                    .message("message")
                    .title("title")
                    .important(false)
                    .build()
    println(mail2)
}
