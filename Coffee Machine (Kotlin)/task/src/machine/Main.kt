package machine

import java.lang.Error
import java.util.Objects
import kotlin.math.min


interface CoffeeTypes {
    val water: Int
    val milk: Int
    val beans: Int
    val amount: Int
}

val Expresso = object : CoffeeTypes {
    override val water = 250
    override val milk = 0
    override val beans = 16
    override val amount: Int = 4
}

val Latte = object : CoffeeTypes {
    override val water = 350
    override val milk = 75
    override val beans = 20
    override val amount: Int = 7
}

val Cappuccino = object : CoffeeTypes {
    override val water = 200
    override val milk = 100
    override val beans = 12
    override val amount: Int = 6
}


class Coffee(
    private var water: Int,
    private var milk: Int,
    private var beans: Int,
    private var glasses: Int,
    private var amount: Int
) {

    fun buyCoffee(
        coffeeType: CoffeeTypes
    ) {
        if (
            water >= coffeeType.water &&
            milk >= coffeeType.milk &&
            beans >= coffeeType.beans &&
            glasses >= 1
        ) {

            water -= coffeeType.water
            milk -= coffeeType.milk
            beans -= coffeeType.beans
            glasses -= 1
            amount += coffeeType.amount

            println("I have enough resources, making you a coffee!")

        } else {

            if (water < coffeeType.water) {
                println("Sorry, not enough water!")
            } else if (milk < coffeeType.milk) {
                println("Sorry, not enough milk!")
            } else if (beans < coffeeType.beans) {
                println("Sorry, not enough beans!")
            } else {
                println("Sorry, not enough cups!")
            }

        }
    }

    fun fillCoffee(
        aWater: Int,
        aMilk: Int,
        aBeans: Int,
        aGlasses: Int
    ) {
        water += aWater
        milk += aMilk
        beans += aBeans
        glasses += aGlasses
    }

    fun withDraw() {
        println("I gave you \$$amount")
        amount = 0
    }

    fun printRemaining() {
        println(
            "The coffee machine has:\n" +
                    "$water ml of water\n" +
                    "$milk ml of milk\n" +
                    "$beans g of coffee beans\n" +
                    "$glasses disposable cups\n" +
                    "\$$amount of money"
        )
    }

}

fun main() {


    var water = 400
    var milk = 540
    var beans = 120
    var glasses = 9
    var amount = 550

    val coffeeMachine = Coffee(water, milk, beans, glasses, amount)

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        when (val action = readln()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino,back - to main menu:")
                val coffeeType = when (readln()) {
                    "1" -> Expresso
                    "2" -> Latte
                    "3" -> Cappuccino
                    "back" -> continue
                    else -> {
                        throw Error("Unknown Coffee Type")
                    }
                }
                coffeeMachine.buyCoffee(coffeeType)
            }

            "fill" -> {
                println("Write how many ml of water you want to add:")
                val aWater = readln().toInt()
                println("Write how many ml of milk you want to add:")
                val aMilk = readln().toInt()
                println("Write how many grams of coffee beans you want to add:")
                val aBeans = readln().toInt()
                println("Write how many disposable cups you want to add:")
                val aGlasses = readln().toInt()
                coffeeMachine.fillCoffee(aWater, aMilk, aBeans, aGlasses)

            }

            "take" -> {
                coffeeMachine.withDraw()
            }

            "remaining" -> {
                coffeeMachine.printRemaining()
            }

            "exit" -> {
                break
            }
        }
    }

}
