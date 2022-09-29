data class Mail_V3(
        val to: List<String>,
        val cc: List<String> = listOf(),
        val title: String = "",
        val message: String = "",
        val important: Boolean = false
)

fun main() {
    val mail = Mail_V3(to = listOf("mail@mail.com"), message = "default", important = true)
    println(mail)
}
