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

interface Trooper {
    fun move(x: Long, y: Long)
    fun attackRebel(x: Long, y: Long)
    fun retreat()
}

interface Weapon {
    fun attack(): PointsOfDamage
}

interface Legs {
    fun move(): Meters
}

data class StormTrooper(
        private val weapon: Weapon,
        private val legs: Legs,
) : Trooper {
    override fun move(x: Long, y: Long) {
        legs.move()
    }

    override fun attackRebel(x: Long, y: Long) {
        weapon.attack()
    }

    override fun retreat() {
        println("Retreat!")
        legs.move()
    }
}

val stormTrooper = StormTrooper(Rifle(), RegularLegs())
val flameTrooper = StormTrooper(Flamethrower(), RegularLegs())
val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())

fun main() {
    println(stormTrooper)
    println(flameTrooper)
    println(scoutTrooper)
}