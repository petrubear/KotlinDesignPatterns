// asume configuration similar to spring
/*
server:
    port: 8080
environment: production
*/
interface Property {
    val name: String
    val value: Any
}

interface ServerConfiguration {
    val properties: List<Property>
}

data class PropertyImpl(override val name: String, override val value: Any) : Property

data class IntProperty(override val name: String, override val value: Int) : Property

data class StringProperty(override val name: String, override val value: String) : Property

data class ServerConfigurationImpl(override val properties: List<Property>) : ServerConfiguration

class Parser {
    companion object utils {
        fun property(prop: String): Property {
            val (name, value) = prop.split(":")
            return when (name) {
                "port" -> IntProperty(name, value.trim().toInt())
                "environment" -> StringProperty(name, value.trim())
                else -> throw IllegalArgumentException("Unknown property $name")
            }
        }

        fun server(propertyStrings: List<String>): ServerConfiguration {
            val parsedProperties = mutableListOf<Property>()
            for (prop in propertyStrings) {
                parsedProperties += property(prop)
            }
            return ServerConfigurationImpl(parsedProperties)
        }
    }
}

fun main() {
    val portProperty = Parser.property("port: 8080")
    val environmentProperty = Parser.property("environment: production")
    val port: Int = (portProperty as IntProperty).value
    val environment: String = (environmentProperty as StringProperty).value

    println("Configuration port: $port")
    println("Configuration environment: $environment")
    println(Parser.server(listOf("port: 8080", "environment: production")))
}
