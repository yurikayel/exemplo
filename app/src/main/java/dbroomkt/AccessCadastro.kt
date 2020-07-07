package dbroomkt

import androidx.room.*

@Dao
interface AccessCadastro {

    @Query("SELECT * FROM usuario")
    fun puxaTodaLista(): MutableList<EntityUsuario>

    @Query("SELECT * FROM usuario where id LIKE  :id")
    fun encontrarPorId(id: Int): EntityUsuario

    @Query("SELECT COUNT(*) from usuario")
    fun contarTodos(): Int

    @Insert
    fun inserir(vararg entityUsuarios: EntityUsuario)

    @Delete
    fun deletar(entityUsuario: EntityUsuario)

    @Update
    fun atualizar(entityUsuario: EntityUsuario)
}