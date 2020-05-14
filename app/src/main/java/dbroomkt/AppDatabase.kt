package dbroomkt

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioAccess(): UsuarioDao
}

object DatabaseBuilder{
    private var INSTANCE: AppDatabase? = null

    fun getAppDatabase(context: Context) = INSTANCE ?: build(context)

    private fun build(context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, "database"
        )
            .allowMainThreadQueries()
            .build().apply {
                INSTANCE = this
            }

    fun destroyInstance() {
        INSTANCE = null
    }
}
