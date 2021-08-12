package online.heyworld.kt.easy.test.util

class Size {
    var width = 0
    var height = 0

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    override fun toString(): String {
        return "Size(width=$width, height=$height)"
    }


}


class Rect{
    var left = 0
    var top = 0
    var right = 0
    var bottom = 0

    constructor(left: Int, top: Int, right: Int, bottom: Int) {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }

    fun width():Int{
        return right - left
    }

    fun height():Int{
        return bottom- top
    }
}