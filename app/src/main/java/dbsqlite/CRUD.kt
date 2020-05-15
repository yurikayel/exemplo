package dbsqlite

interface CRUD<Type> {

    fun create(objekt: Type)
    fun read(value: Any? = null, col: String = "id"): List<Type>
    fun update(id: Int, objekt: Type)
    fun destroy(id: Int)

}
