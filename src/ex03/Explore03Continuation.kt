package ex03

fun main(args: Array<String>) {
    val seq = sequence {
        println("One")
        yield(1)

        println("Two")
        yield(2)

        println("Three")
        yield(3)

        println("done")
    }

    for(value in seq) {
        println("The value $value")
    }
}