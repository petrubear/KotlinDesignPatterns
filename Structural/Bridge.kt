typealias Meters = Long

typealias PointsOfDamage = Long

const val RIFLE_DAMAGE: PointsOfDamage = 3L
const val REGULAR_SPEED: Meters = 1

class Rifle : Weapon {
    override fun attack() = RIFLE_DAMAGE
}

class Flamethrower : Weapon {
    override fun attack() = RIFLE_DAMAGE * 2
}

class Batton : Weapon {
    override fun attack() = RIFLE_DAMAGE * 3
}

class RegularLegs : Legs {
    override fun move() = REGULAR_SPEED
}

class AthleticLegs : Legs {
    override fun move() = REGULAR_SPEED * 2
}

interface Tropper {
    fun move(x: Long, y: Long)
    fun attackRevel(x: Long, y: Long)
}

interface Weapon {
    fun attack(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

data class StormTropper(
        private val weapon: Weapon,
        private val legs: Legs,
) : Tropper {
    override fun move(x: Long, y: Long) {
        legs.move()
    }

    override fun attackRevel(x: Long, y: Long) {
        weapon.attack()
    }
}

val stormTropper = StormTropper(Rifle(), RegularLegs())
val flameTropper = StormTropper(Flamethrower(), RegularLegs())
val scoutTropper = StormTropper(Rifle(), AthleticLegs())