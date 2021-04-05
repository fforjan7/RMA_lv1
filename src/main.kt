import Dice

fun main() {
    val dices = List(6) { Dice() }
    var rollCounter = 0;

    fun printDices() {
        for (dice in dices) {
            println(dice.value)
        }
    }

    fun checkResult() {
        var num1 = 0
        var num2 = 0
        var num3 = 0
        var num4 = 0
        var num5 = 0
        var num6 = 0

        for (dice in dices) {
            if(dice.value == 1){
                num1++
            }
            if(dice.value==2){
                num2++
            }
            if(dice.value==3){
                num3++
            }
            if(dice.value==4){
                num4++
            }
            if(dice.value==5){
                num5++
            }
            if(dice.value==6){
                num6++
            }
        }
        if (num1>0 && num2>0 && num3>0 && num4>0 && num5>0) {
            println("LOWER SCALE")
        }
        if( num2>0 && num3>0 && num4>0 && num5>0 && num6>0){
            println("HIHGER SCALE")
        }
        if (num1==4 || num2==4 || num3==4 || num4==4 || num5==4 || num6==4) {
            println("POKER")
        }
        if (num1==5 || num2==5 || num3==5 || num4==5 || num5==5 || num6==5) {
            println("JAMB")
        }
    }

    fun resetDices() {
        rollCounter = 0
        for (dice in dices) {
            dice.locked = false
        }
        println("You are out of rolls")
        checkResult()

    }


    fun rollDices() {
        for (dice in dices) {
            if (dice.locked == false)
                dice.roll()
        }
        printDices()

        rollCounter++
        println("You rolled  :$rollCounter time")
        if (rollCounter < 3) {
            for (i in 1..6) {
                println("Would you like to lock dice $i(number ${dices[i - 1].value})")
                println("Press 1 for YES and 0 for NO\n")
                val num = readLine()!!
                if (num.toInt() == 1) {
                    dices[i - 1].locked = true
                } else if (num.toInt() == 0) {
                    dices[i - 1].locked = false
                }
            }
        } else {
            resetDices()
        }
    }

    for(i in 0..2){
        rollDices()
    }
}