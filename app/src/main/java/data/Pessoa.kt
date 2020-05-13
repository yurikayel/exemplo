package data

//POKO
//Não confundir com BOJO

data class Pessoa(
    val id: Int = 0,
    val nome: String,
    val sobrenome: String,
    val idade: Int
) {
    constructor(nome: String, sobrenome: String, idade: Int)
            : this(0, nome, sobrenome, idade)
}
