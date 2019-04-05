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
            //, KategoriaPrzypadekTestowy("jest większa lub równa", ">=")
            , KategoriaPrzypadekTestowy("jest mniejsza lub równa", "<=")
            , KategoriaPrzypadekTestowy("jest mniejszy", "<")
            , KategoriaPrzypadekTestowy("jest mniejsza", "<")
            , KategoriaPrzypadekTestowy("jest mniejsze", "<")
            , KategoriaPrzypadekTestowy("mniejszy", "<")
            , KategoriaPrzypadekTestowy("mniejsza", "<")
            , KategoriaPrzypadekTestowy("mniejsze", "<")
            , KategoriaPrzypadekTestowy("mniejszy niż", "<")
            , KategoriaPrzypadekTestowy("mniejsza niż", "<")
            , KategoriaPrzypadekTestowy("mniejsze niż", "<")
            , KategoriaPrzypadekTestowy("jest większy", ">")
            , KategoriaPrzypadekTestowy("jest większa", ">")
            , KategoriaPrzypadekTestowy("jest większe", ">")

            , KategoriaPrzypadekTestowy("jest mniejsza lub równa", "<=")
            , KategoriaPrzypadekTestowy("jest większy niż", ">")
            , KategoriaPrzypadekTestowy("jest większy od", ">")
            , KategoriaPrzypadekTestowy("jest mniejszy niż", "<")
            , KategoriaPrzypadekTestowy("jest mniejszy od", "<")
            , KategoriaPrzypadekTestowy("jest różny niż", "!=")
            , KategoriaPrzypadekTestowy("jest różny od", "!=")
            , KategoriaPrzypadekTestowy("jest większa niż", ">")
            , KategoriaPrzypadekTestowy("jest większa od", ">")
            , KategoriaPrzypadekTestowy("jest mniejsza niż", "<")
            , KategoriaPrzypadekTestowy("jest mniejsza od", "<")
            , KategoriaPrzypadekTestowy("jest różna niż", "!=")
            , KategoriaPrzypadekTestowy("jest różna od", "!=")
            , KategoriaPrzypadekTestowy("jest większe niż", ">")
            , KategoriaPrzypadekTestowy("jest większe od", ">")
            , KategoriaPrzypadekTestowy("jest mniejsze niż", "<")
            , KategoriaPrzypadekTestowy("jest mniejsze od", "<")
            , KategoriaPrzypadekTestowy("jest różne niż", "!=")
            , KategoriaPrzypadekTestowy("jest różne od", "!=")

            , KategoriaPrzypadekTestowy("jest mniejsza lub równa", "<=")

            , KategoriaPrzypadekTestowy("nie jest większy niż", "<=")
            , KategoriaPrzypadekTestowy("nie jest większy od", "<=")

            , KategoriaPrzypadekTestowy("nie jest mniejszy od", ">=")
            , KategoriaPrzypadekTestowy("nie jest różny niż", "==")
            , KategoriaPrzypadekTestowy("nie jest różny od", "==")

            , KategoriaPrzypadekTestowy("nie jest mniejsza od", ">=")
            , KategoriaPrzypadekTestowy("nie jest różna niż", "==")

            , KategoriaPrzypadekTestowy("nie jest różna od", "==")
            , KategoriaPrzypadekTestowy("nie jest większe niż", "<=")
            , KategoriaPrzypadekTestowy("nie jest większe od", "<=")
            , KategoriaPrzypadekTestowy("nie jest mniejsze niż", ">=")

            , KategoriaPrzypadekTestowy("nie jest mniejsze od", ">=")
            , KategoriaPrzypadekTestowy("nie jest różne niż", "==")
            , KategoriaPrzypadekTestowy("nie jest różne od", "==")
            //, KategoriaPrzypadekTestowy("nie jest równy", "!=")
            //, KategoriaPrzypadekTestowy("nie jest większy lub równy", "<")
            //, KategoriaPrzypadekTestowy("nie jest mniejszy lub równa", ">")
            //, KategoriaPrzypadekTestowy("nie jest równa", "!=")
            //, KategoriaPrzypadekTestowy("nie jest większa lub równa", "<")

            //, KategoriaPrzypadekTestowy("nie jest mniejsza lub równa", ">")
            //, KategoriaPrzypadekTestowy("nie jest równe", "!=")
            //, KategoriaPrzypadekTestowy("nie jest większe lub równe", "<")
            //, KategoriaPrzypadekTestowy("nie jest mniejsze lub równe", ">")
            //, KategoriaPrzypadekTestowy("jest równy", "==")
            //, KategoriaPrzypadekTestowy("jest większy lub równy", ">=")
            //, KategoriaPrzypadekTestowy("jest mniejszy lub równa", "<=")
            //, KategoriaPrzypadekTestowy("jest równa", "==")
            //, KategoriaPrzypadekTestowy("jest większa lub równa", ">=")
            //, KategoriaPrzypadekTestowy("jest równe", "==")
            //, KategoriaPrzypadekTestowy("jest większe lub równe", ">=")
            // , KategoriaPrzypadekTestowy("jest mniejsze lub równe", "<=")
            //, KategoriaPrzypadekTestowy("nie jest mniejszy niż", ">=")
            //, KategoriaPrzypadekTestowy("nie jest większa niż", "<=")
            //, KategoriaPrzypadekTestowy("nie jest większa od", "<=")
            //, KategoriaPrzypadekTestowy("nie jest mniejsza niż", ">=")
            //, KategoriaPrzypadekTestowy("jest większa lub równa", ">=")

    )


    @Test
    fun testuj() {

        inicjalizuj()

        for ((index, test) in przypadki.withIndex()) {


            var s = egzaminator.wybierzNajlepszaKategorie(test.tekst)

            println("\n**** Test " + index + " ****")

            println("tekst=>" + test.tekst + " => przypisano operator (" + s + ")")
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