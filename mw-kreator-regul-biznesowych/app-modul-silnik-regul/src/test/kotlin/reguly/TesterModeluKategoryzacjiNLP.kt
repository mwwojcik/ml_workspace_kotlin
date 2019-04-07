package reguly

import model.nlp.Sekwencja
import org.junit.Test
import reguly.nlp.EgzaminatorModeluKategoryzacjiNLP
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class KategoriaPrzypadekTestowy(val lp:Int,val tekst: String, val spodziewanaKategoria: String)


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
            KategoriaPrzypadekTestowy(1,"jest różny niż","!=")
            ,KategoriaPrzypadekTestowy(2,"jest różny od","!=")
            ,KategoriaPrzypadekTestowy(3,"jest różna niż","!=")
            ,KategoriaPrzypadekTestowy(4,"jest różna od","!=")
            ,KategoriaPrzypadekTestowy(5,"jest różne niż","!=")
            ,KategoriaPrzypadekTestowy(6,"jest różne od","!=")
            ,KategoriaPrzypadekTestowy(7,"nie jest równy","!=")
            ,KategoriaPrzypadekTestowy(8,"nie jest równa","!=")
            ,KategoriaPrzypadekTestowy(9,"nie jest równe","!=")
            ,KategoriaPrzypadekTestowy(10,"jest mniejszy","<")
            ,KategoriaPrzypadekTestowy(11,"jest mniejsza","<")
            ,KategoriaPrzypadekTestowy(12,"jest mniejsze","<")
            ,KategoriaPrzypadekTestowy(13,"mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(14,"mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(15,"mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(16,"jest mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(17,"jest mniejszy od","<")
            ,KategoriaPrzypadekTestowy(18,"jest mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(19,"jest mniejsza od","<")
            ,KategoriaPrzypadekTestowy(20,"jest mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(21,"jest mniejsze od","<")
            ,KategoriaPrzypadekTestowy(22,"nie jest większy","<=")
            ,KategoriaPrzypadekTestowy(23,"nie jest większa","<=")
            ,KategoriaPrzypadekTestowy(24,"nie jest większe","<=")
            ,KategoriaPrzypadekTestowy(25,"jest równy","==")
            ,KategoriaPrzypadekTestowy(26,"jest równa","==")
            ,KategoriaPrzypadekTestowy(27,"jest równe","==")
            ,KategoriaPrzypadekTestowy(28,"jest większy",">")
            ,KategoriaPrzypadekTestowy(29,"jest większa",">")
            ,KategoriaPrzypadekTestowy(30,"jest większe",">")
            ,KategoriaPrzypadekTestowy(31,"jest większy niż",">")
            ,KategoriaPrzypadekTestowy(32,"jest większy od",">")
            ,KategoriaPrzypadekTestowy(33,"jest większa niż",">")
            ,KategoriaPrzypadekTestowy(34,"jest większa od",">")
            ,KategoriaPrzypadekTestowy(35,"jest większe niż",">")
            ,KategoriaPrzypadekTestowy(36,"jest większe od",">")
            ,KategoriaPrzypadekTestowy(37,"nie jest mniejsza",">=")
            ,KategoriaPrzypadekTestowy(38,"nie jest mniejszy",">=")
            ,KategoriaPrzypadekTestowy(39,"nie jest mniejsze",">=")



    )


    @Test
    fun testuj() {

        inicjalizuj()

        for ((index, test) in przypadki.withIndex()) {


            var s = egzaminator.wybierzNajlepszaKategorie(test.tekst)

            println("\n**** Test " + test.lp + " ****")

            println("tekst=>" + test.tekst + "=> przypisano operator (" + s + ")")
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