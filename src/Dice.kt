class Dice {
    var value = 0
    fun roll(){
        value = (1..6).random()
    }
    var locked  = false
}

