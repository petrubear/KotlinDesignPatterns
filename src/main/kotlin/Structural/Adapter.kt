interface USPlug {
    val hasPower: Int
}

interface EUPlug {
    val hasPower: String // "TRUE" or "FALSE"
}

interface UsbMini {
    val hasPower: Power
}

interface UsbTypeC {
    val hasPower: Boolean
}

enum class Power {
    TRUE,
    FALSE
}

fun cellphone(chargeable: UsbTypeC) {
    if (chargeable.hasPower) {
        println("Charging cellphone")
    } else {
        println("No power")
    }
}

fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower: Int = 1
    }
}

fun charger(plug: EUPlug): UsbMini {
    return object : UsbMini {
        override val hasPower: Power = Power.valueOf(plug.hasPower)
    }
}

// Adapter en koltin se puede lograr usando extension functions
fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug {
        override val hasPower: String = hasPower
    }
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object : UsbTypeC {
        override val hasPower: Boolean = hasPower
    }
}

fun main() {
    // cellphone(charger(usPowerOutlet()))
    cellphone(charger(usPowerOutlet().toEUPlug()).toUsbTypeC())
}
