package dbsqlite

interface CRUD<Type> {

    fun create(objekt: Type)
    fun read() : List<Type>
    fun read(id: Int): Type?
    fun update(id: Int, objekt: Type)
    fun destroy(id: Int)

}
