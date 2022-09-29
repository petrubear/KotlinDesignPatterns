data class Mail_V2(
        val to: List<String>,
        private var _cc: List<String> = listOf(),
        private var _title: String? = null,
        private var _messange: String? = null,
        private var _important: Boolean? = null,
) {
    fun message(message: String) = apply {
        _messange = message
    }
    fun title(title: String) = apply {
        _title = title
    }
    fun important(important: Boolean) = apply {
        _important = important
    }
    fun cc(cc: List<String>) = apply {
        _cc = cc
    }
}

fun main() {
    val mail = Mail_V2(listOf("mail@mail.com"))
            .message("message")
            .title("title")
            .important(false)
    println(mail)
    val mail2 = Mail_V2(listOf("mail@mail.com")).apply { 
            title("Apply title")
            important(true)
    }
    println(mail2)
}
