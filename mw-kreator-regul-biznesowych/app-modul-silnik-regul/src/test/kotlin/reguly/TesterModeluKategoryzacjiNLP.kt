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
            ,KategoriaPrzypadekTestowy(10,"i","&&")
            ,KategoriaPrzypadekTestowy(11,"oraz","&&")
            ,KategoriaPrzypadekTestowy(12,"jest mniejszy","<")
            ,KategoriaPrzypadekTestowy(13,"jest mniejsza","<")
            ,KategoriaPrzypadekTestowy(14,"jest mniejsze","<")
            ,KategoriaPrzypadekTestowy(15,"mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(16,"mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(17,"mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(18,"jest mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(19,"jest mniejszy od","<")
            ,KategoriaPrzypadekTestowy(20,"jest mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(21,"jest mniejsza od","<")
            ,KategoriaPrzypadekTestowy(22,"jest mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(23,"jest mniejsze od","<")
            ,KategoriaPrzypadekTestowy(24,"nie jest większy","<=")
            ,KategoriaPrzypadekTestowy(25,"nie jest większa","<=")
            ,KategoriaPrzypadekTestowy(26,"nie jest większe","<=")
            ,KategoriaPrzypadekTestowy(27,"jest niewiększy","<=")
            ,KategoriaPrzypadekTestowy(28,"jest niewiększa","<=")
            ,KategoriaPrzypadekTestowy(29,"jest niewiększe","<=")
            ,KategoriaPrzypadekTestowy(30,"jest nie większy","<=")
            ,KategoriaPrzypadekTestowy(31,"jest nie większa","<=")
            ,KategoriaPrzypadekTestowy(32,"jest nie większe","<=")
            ,KategoriaPrzypadekTestowy(33,"jest równy","==")
            ,KategoriaPrzypadekTestowy(34,"jest równa","==")
            ,KategoriaPrzypadekTestowy(35,"jest równe","==")
            ,KategoriaPrzypadekTestowy(36,"jest większy",">")
            ,KategoriaPrzypadekTestowy(37,"jest większa",">")
            ,KategoriaPrzypadekTestowy(38,"jest większe",">")
            ,KategoriaPrzypadekTestowy(39,"jest większy niż",">")
            ,KategoriaPrzypadekTestowy(40,"jest większy od",">")
            ,KategoriaPrzypadekTestowy(41,"jest większa niż",">")
            ,KategoriaPrzypadekTestowy(42,"jest większa od",">")
            ,KategoriaPrzypadekTestowy(43,"jest większe niż",">")
            ,KategoriaPrzypadekTestowy(44,"jest większe od",">")
            ,KategoriaPrzypadekTestowy(45,"nie jest mniejsza",">=")
            ,KategoriaPrzypadekTestowy(46,"nie jest mniejszy",">=")
            ,KategoriaPrzypadekTestowy(47,"nie jest mniejsze",">=")
            ,KategoriaPrzypadekTestowy(48,"jest niemniejsza",">=")
            ,KategoriaPrzypadekTestowy(49,"jest niemniejszy",">=")
            ,KategoriaPrzypadekTestowy(50,"jest niemniejsze",">=")
            ,KategoriaPrzypadekTestowy(51,"jest nie mniejsza",">=")
            ,KategoriaPrzypadekTestowy(52,"jest nie mniejszy",">=")
            ,KategoriaPrzypadekTestowy(53,"jest nie mniejsze",">=")
            ,KategoriaPrzypadekTestowy(54,"sprawdź regułę","SPRAWDZ_REGULE")
            ,KategoriaPrzypadekTestowy(55,"sprawdzaj regułę","SPRAWDZ_REGULE")
            ,KategoriaPrzypadekTestowy(56,"wyświetl komunikat","WYSWIETL_KOMUNIKAT")
            ,KategoriaPrzypadekTestowy(57,"pokaż komunikat","WYSWIETL_KOMUNIKAT")
            ,KategoriaPrzypadekTestowy(58,"zgłoś błąd","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(59,"zgłoś błąd walidacji","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(60,"raportuj błąd","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(61,"lub","||")
            ,KategoriaPrzypadekTestowy(62,"albo","||")



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