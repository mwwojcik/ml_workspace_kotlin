package reguly

import model.nlp.Sekwencja
import org.junit.Assert.assertEquals
import org.junit.Test
import reguly.nlp.EgzaminatorModeluKategoryzacjiNLP
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Paths
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
            ,KategoriaPrzypadekTestowy(10,"jest niepuste","!=null")
            ,KategoriaPrzypadekTestowy(11,"ma wartość","!=null")
            ,KategoriaPrzypadekTestowy(12,"jest określone","!=null")
            ,KategoriaPrzypadekTestowy(13,"jest doprecyzowane","!=null")
            ,KategoriaPrzypadekTestowy(14,"zostało wprowadzone","!=null")
            ,KategoriaPrzypadekTestowy(15,"zostało podane","!=null")
            ,KategoriaPrzypadekTestowy(16,"i","&&")
            ,KategoriaPrzypadekTestowy(17,"oraz","&&")
            ,KategoriaPrzypadekTestowy(18,"jest mniejszy","<")
            ,KategoriaPrzypadekTestowy(19,"jest mniejsza","<")
            ,KategoriaPrzypadekTestowy(20,"jest mniejsze","<")
            ,KategoriaPrzypadekTestowy(21,"mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(22,"mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(23,"mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(24,"jest mniejszy niż","<")
            ,KategoriaPrzypadekTestowy(25,"jest mniejszy od","<")
            ,KategoriaPrzypadekTestowy(26,"jest mniejsza niż","<")
            ,KategoriaPrzypadekTestowy(27,"jest mniejsza od","<")
            ,KategoriaPrzypadekTestowy(28,"jest mniejsze niż","<")
            ,KategoriaPrzypadekTestowy(29,"jest mniejsze od","<")
            ,KategoriaPrzypadekTestowy(30,"nie jest większy","<=")
            ,KategoriaPrzypadekTestowy(31,"nie jest większa","<=")
            ,KategoriaPrzypadekTestowy(32,"nie jest większe","<=")
            ,KategoriaPrzypadekTestowy(33,"jest niewiększy","<=")
            ,KategoriaPrzypadekTestowy(34,"jest niewiększa","<=")
            ,KategoriaPrzypadekTestowy(35,"jest niewiększe","<=")
            ,KategoriaPrzypadekTestowy(36,"jest nie większy","<=")
            ,KategoriaPrzypadekTestowy(37,"jest nie większa","<=")
            ,KategoriaPrzypadekTestowy(38,"jest nie większe","<=")
            ,KategoriaPrzypadekTestowy(39,"jest równy","==")
            ,KategoriaPrzypadekTestowy(40,"jest równa","==")
            ,KategoriaPrzypadekTestowy(41,"jest równe","==")
            ,KategoriaPrzypadekTestowy(42,"jest puste","==null")
            ,KategoriaPrzypadekTestowy(43,"nie ma wartości","==null")
            ,KategoriaPrzypadekTestowy(44,"nie jest określone","==null")
            ,KategoriaPrzypadekTestowy(45,"nie jest doprecyzowane","==null")
            ,KategoriaPrzypadekTestowy(46,"nie zostało wprowadzone","==null")
            ,KategoriaPrzypadekTestowy(47,"nie zostało podane","==null")
            ,KategoriaPrzypadekTestowy(48,"jest większy",">")
            ,KategoriaPrzypadekTestowy(49,"jest większa",">")
            ,KategoriaPrzypadekTestowy(50,"jest większe",">")
            ,KategoriaPrzypadekTestowy(51,"jest większy niż",">")
            ,KategoriaPrzypadekTestowy(52,"jest większy od",">")
            ,KategoriaPrzypadekTestowy(53,"jest większa niż",">")
            ,KategoriaPrzypadekTestowy(54,"jest większa od",">")
            ,KategoriaPrzypadekTestowy(55,"jest większe niż",">")
            ,KategoriaPrzypadekTestowy(56,"jest większe od",">")
            ,KategoriaPrzypadekTestowy(57,"nie jest mniejsza",">=")
            ,KategoriaPrzypadekTestowy(58,"nie jest mniejszy",">=")
            ,KategoriaPrzypadekTestowy(59,"nie jest mniejsze",">=")
            ,KategoriaPrzypadekTestowy(60,"jest niemniejsza",">=")
            ,KategoriaPrzypadekTestowy(61,"jest niemniejszy",">=")
            ,KategoriaPrzypadekTestowy(62,"jest niemniejsze",">=")
            ,KategoriaPrzypadekTestowy(63,"jest nie mniejsza",">=")
            ,KategoriaPrzypadekTestowy(64,"jest nie mniejszy",">=")
            ,KategoriaPrzypadekTestowy(65,"jest nie mniejsze",">=")
            ,KategoriaPrzypadekTestowy(66,"sprawdź regułę","SPRAWDZ_REGULE")
            ,KategoriaPrzypadekTestowy(67,"sprawdzaj regułę","SPRAWDZ_REGULE")
            ,KategoriaPrzypadekTestowy(68,"wyświetl komunikat","WYSWIETL_KOMUNIKAT")
            ,KategoriaPrzypadekTestowy(69,"pokaż komunikat","WYSWIETL_KOMUNIKAT")
            ,KategoriaPrzypadekTestowy(70,"zgłoś błąd","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(71,"zgłoś błąd walidacji","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(72,"raportuj błąd","ZGLOS_BLAD")
            ,KategoriaPrzypadekTestowy(73,"lub","||")
            ,KategoriaPrzypadekTestowy(74,"albo","||")



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