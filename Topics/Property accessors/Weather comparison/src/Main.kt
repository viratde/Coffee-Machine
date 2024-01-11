class City(val name: String) {
    var degrees: Int = 0
        set(value) {
            field = if (value < -92 || value > 57) {
                if (name == "Moscow") {
                    5
                } else if (name == "Hanoi") {
                    20
                } else if (name == "Dubai") {
                    30
                } else {
                    value
                }
            } else {
                value
            }
        }
}

fun main() {
    val first = readln().toInt()
    val second = readln().toInt()
    val third = readln().toInt()
    val firstCity = City("Dubai")
    firstCity.degrees = first
    val secondCity = City("Moscow")
    secondCity.degrees = second
    val thirdCity = City("Hanoi")
    thirdCity.degrees = third

    val cities = listOf(firstCity, secondCity, thirdCity)
    val fCities = cities.filter {
        it.degrees == cities.minOf { it.degrees }
    }
    //implement comparing here
    if(fCities.size > 1){
        println("neither")
    }else{
        println(fCities[0].name)
    }
}