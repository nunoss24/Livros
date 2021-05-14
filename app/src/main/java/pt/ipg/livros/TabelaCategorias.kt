package pt.ipg.livros

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaCategorias(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE " + NOME_TABELA + "(" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CAMPO_NOME + " TEXT NOT NULL" +
                ")")
    }

    companion object {
        const val NOME_TABELA = "categorias"
        const val CAMPO_NOME = "nome"
    }
}
