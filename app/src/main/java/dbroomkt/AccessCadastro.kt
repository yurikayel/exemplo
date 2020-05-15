package dbroomkt

import android.arch.persistence.room.*

@Dao
interface AccessCadastro {

    @Query("SELECT * FROM usuario")
    fun puxaTodaLista(): MutableList<Usuario>

    @Query("SELECT * FROM usuario where id LIKE  :id")
    fun encontrarPorId(id: Int): Usuario

    @Query("SELECT COUNT(*) from usuario")
    fun contarTodos(): Int

    @Insert
    fun inserir(vararg usuarios: Usuario)

    @Delete
    fun deletar(usuario: Usuario)

    @Update
    fun atualizar(usuario: Usuario)
}