package reguly

import model.nlp.Sekwencja
import org.junit.Test
import reguly.nlp.EgzaminatorModeluKategoryzacjiNLP
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class KategoriaPrzypadekTestowy(val tekst: String, val spodziewanaKategoria: String)


class TesterModeluKategoryzacjiNLP {

    val egzaminator: EgzaminatorModeluKategoryzacjiNLP = EgzaminatorModeluKategoryzacjiNLP()

    /* companion object {



         @BeforeClass

     }*/


    fun inicjalizuj() {
        egzaminator.plikModelu = "modelnlp/kategoryzacja_reguly_model.bin"
        egzaminator.inicjujModel()
    }


    val przypadki = arrayListOf<KategoriaPrzypadekTestowy>(
            //operatory podstawowe 'jest równy','jest większy lub równy', 'jest mniejszy lub równy'
            KategoriaPrzypadekTestowy("jest mniejszy niż", "<")
            , KategoriaPrzypadekTestowy("jest mniejsza", "<")
            , KategoriaPrzypadekTestowy("jest mniejsze", "<")
            , KategoriaPrzypadekTestowy("jest większa", ">")
            , KategoriaPrzypadekTestowy("jest większa lub równa", ">=")
            , KategoriaPrzypadekTestowy("jest mniejsza lub równa", "<=")
    )


    @Test
    fun testuj() {

        inicjalizuj()

        for ((index, test) in przypadki.withIndex()) {


            var s = egzaminator.wybierzNajlepszaKategorie(test.tekst)

            println("\n**** Test " + index + " ****")

            println("tekst=>"+test.tekst+" => przypisano operator ("+s+")")
            assertEquals(test.spodziewanaKategoria, s)
        }


    }

    //@Test
    fun czytajPlik() {
        /*  val p:Path= Paths.get(javaClass.classLoader.getResource("reguly/test.txt").path.replaceFirst(":",""))
          val s:String=String(Files.readAllBytes(p))
          println(s)*/

        println(String(Files.readAllBytes(Paths.get(javaClass.classLoader.getResource("reguly/test.txt").toURI()))));
    }
}