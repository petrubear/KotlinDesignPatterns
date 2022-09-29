class Squad(private val units: List<Trooper>) : Trooper {
    constructor(vararg units: Trooper) : this(units.toList())
    override fun move(x: Long, y: Long) {
        for (u in units) {
            u.move(x, y)
        }
    }

    override fun attackRebel(x: Long, y: Long) {
        for (u in units) {
            u.attackRebel(x, y)
        }
    }

    override fun retreat() {
        for (u in units) {
            u.retreat()
        }
    }
}

fun main() {
    val bobaFett = StormTrooper(Rifle(), RegularLegs())
    val squad = Squad(listOf(bobaFett.copy(), bobaFett.copy(), bobaFett.copy()))
    val squad2 = Squad(bobaFett.copy(), bobaFett.copy(), bobaFett.copy(), bobaFett.copy())
    println(squad)
    println(squad2)
}
