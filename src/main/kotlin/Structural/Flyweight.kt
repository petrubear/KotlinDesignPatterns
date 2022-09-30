enum class Direction {
    LEFT, RIGHT
}

object SnailSprites {
    val sprites = List(8) { i ->
        java.io.File(
            when (i) {
                0 -> "snail-left.png"
                1 -> "snail-right.png"
                in 2..4 -> "snail-move-left${i - 1}.png"
                else -> "snail-move-right${4 - i}.png"
            }
        )
    }
}

class TanzanianSnail {
    val directionFacing = Direction.LEFT
    val sprites = SnailSprites.sprites

    fun getCurrentSprite(): java.io.File {
        return when (directionFacing) {
            Direction.LEFT -> sprites[0]
            Direction.RIGHT -> sprites[1]
        }
    }
}
