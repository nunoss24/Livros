package pt.ipg.livros

import android.database.sqlite.SQLiteDatabase

class TabelaLivros(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE livros(_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT NOT NULL, autor TEXT NOT NULL, id_categoria INTEGER NOT NULL, FOREIGN KEY(id_categoria) REFERENCES categorias)")
    }
}
