enum class DangerLevel(val level: Int) {
    HIGH(3),
    MEDIUM(2),
    LOW(1);


}

fun DangerLevel.getLevel(): Int {
    return this.level
}
