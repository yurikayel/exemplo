package data

interface CRUD<Type> {

    fun create(objekt: Type)
    fun read() : List<Type>
    fun read(id : Int) : Pessoa?
    fun update(id: Int, objekt: Type): Type
    fun destroy(id: Int)

}
