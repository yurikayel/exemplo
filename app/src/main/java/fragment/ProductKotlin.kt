package fragment

class ProductKotlin(val cerealCode: Int = 0) {

    companion object {
        @JvmStatic val lot = 666
        @JvmStatic val date = 333
        @JvmStatic val expDate = 0
    }
}



fun main() {
    println("\n\n\n\nSTART:\n\n\n\n")

    println(ProductKotlin.date)
    println(ProductKotlin.date)
    println(ProductKotlin.expDate)

    println("\n\n\n\nTHE END")
}