package custom

interface ISingleton<T> {
    val instance : T
    val name : String
}

object Dantop : ISingleton<Dantop> {

    override val instance: Dantop = Dantop
    override val name: String = "Teta de Nega"

    override fun toString() = name
}

fun main() {
    println("\n\n\n\n\n\n")
    println(Dantop)
    println("\n\n\n\n\n\n")
}
