package pt.ipg.livros

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TestesBaseDados {
    private fun getAppContext() = InstrumentationRegistry.getInstrumentation().targetContext
    private fun getBdLivrosOpenHelper() = BdLivrosOpenHelper(getAppContext())

    @Before
    fun apagaBaseDados() {
        getAppContext().deleteDatabase(BdLivrosOpenHelper.NOME_BASE_DADOS)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val db = getBdLivrosOpenHelper().readableDatabase
        assert(db.isOpen)
        db.close()
    }

    @Test
    fun consegueInserirCategorias() {
        val db = getBdLivrosOpenHelper().writableDatabase
        val tabelaCategorias = TabelaCategorias(db)

        val id = tabelaCategorias.insert(Categoria(nome = "Drama").toContentValues())

        assertNotEquals(-1, id)

        db.close()
    }
}