package reguly

import model.nlp.Sekwencja
import org.junit.Test
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class PrzypadekTestowy(val sentencja: String, val spodziewanyOperatorWarunku: String)


class TesterModeluNLP {

    val egzaminator: EgzaminatorModeluRozpoznawaniaEncjiNLP = EgzaminatorModeluRozpoznawaniaEncjiNLP()

   /* companion object {



        @BeforeClass

    }*/


    fun inicjalizuj(){
        egzaminator.plikModelu="modelnlp/encje_reguly_model.bin"
        egzaminator.inicjujModel()
    }


    val przypadki = arrayListOf<PrzypadekTestowy>(
            //operatory podstawowe 'jest równy','jest większy lub równy', 'jest mniejszy lub równy'
            PrzypadekTestowy("Jeśli data jest równa '01-01-2000' wtedy wyświetl komunikat .", "jest równa")
            , PrzypadekTestowy("Jeśli data jest większa lub równa '01-01-2000' wtedy wyświetl komunikat .", "jest większa lub równa")
            , PrzypadekTestowy("Jeśli nachylenie jest mniejsze lub równe 30 wtedy wyświetl komunikat .", "jest mniejsze lub równe")
            //operatory podstawowe zaprzeczone 'nie jest równy','nie jest większy lub równy', 'nie jest mniejszy lub równy'

            , PrzypadekTestowy("Jeśli data nie jest równa '01-01-2000' wtedy wyświetl komunikat .", "nie jest równa")
            , PrzypadekTestowy("Jeśli data nie jest większa lub równa '01-01-2000' wtedy wyświetl komunikat .", "nie jest większa lub równa")
            , PrzypadekTestowy("Jeśli nachylenie nie jest mniejsze lub równe 30 wtedy wyświetl komunikat .", "nie jest mniejsze lub równe")

            //Operatory stopniowane (['jest większy niż', 'jest mniejszy od', 'jest różny od'])
            , PrzypadekTestowy("Jeśli dochód jest większy niż 100 wtedy wyświetl komunikat .", "jest większy niż")
            , PrzypadekTestowy("Jeżeli suma jest mniejsza od 50 to wyświetl komunikat .", "jest mniejsza od")
            , PrzypadekTestowy("Jeżeli suma jest różna od 50 to wyświetl komunikat .", "jest różna od")

            //Operatory stopniowane zaprzeczone(['nie jest większy niż', 'nie jest mniejszy od', 'nie jest różny od'])
            , PrzypadekTestowy("Jeśli dochód jest nie większy niż 100 wtedy wyświetl komunikat .", "jest nie większy niż")
            , PrzypadekTestowy("Jeżeli suma nie jest mniejsza od 50 to wyświetl komunikat .", "nie jest mniejsza od")
            , PrzypadekTestowy("Jeżeli suma nie jest różna od 50 to wyświetl komunikat .", "nie jest różna od")
            , PrzypadekTestowy("Jeśli rok jest równy 2000 to wyświetl komunikat","jest równy")
            , PrzypadekTestowy("Jeśli rok nie jest mniejszy niż 2000 wtedy wyświetl komunikat","nie jest mniejszy niż")
            , PrzypadekTestowy("Jeśli miesiąc jest nie mniejszy niż styczeń to wyświetl komunikat","jest nie mniejszy niż")
            , PrzypadekTestowy("Jeśli data jest nie większa niż '01-01-2019' to zgłoś błąd","jest nie większa niż")
            , PrzypadekTestowy("Jeśli dzień jest równy wczoraj to zgłoś błąd","jest równy")
            , PrzypadekTestowy("Jeśli miesiąc jest nie mniejszy niż 6 to sprawdzaj regułę","jest nie mniejszy niż")
            , PrzypadekTestowy("Jeśli data jest różna od '01-01-200' oraz rok jest większy niż 2000 lub dzień jest różny od 12 to wyświetl komunikat <KOMUNIKAT_1> .","jest różna od")
            , PrzypadekTestowy("Gdy suma jest większa od 100 i różnica jest mniejsza od 0 lub różnica jest równa 1 wtedy wyświetl komunikat <KOMUNIKAT_2> .","jest większa od")
            , PrzypadekTestowy("Jeśli data_utworzenia jest większa od '01-01-2010' oraz data_utworzenia nie jest mniejsza niż data_kwalifikacji i data_kwalifikacji jest różna od data_weryfikacji to zgłoś błąd walidacji <KOMUNIKAT_WALIDACJI_1> .","jest większa od")
    )


    @Test
    fun testuj() {

        inicjalizuj()

        for ((index, test) in przypadki.withIndex()) {


            var s: Sekwencja = egzaminator.rozpoznajSekwencje(test.sentencja)

            println("\n**** Test " + index + " ****")

            s.drukuj()

            assertEquals(test.spodziewanyOperatorWarunku, s.dajPierwszyOperatorWarunku())
        }


    }

    //@Test
    fun czytajPlik(){
      /*  val p:Path= Paths.get(javaClass.classLoader.getResource("reguly/test.txt").path.replaceFirst(":",""))
        val s:String=String(Files.readAllBytes(p))
        println(s)*/

       println(String(Files.readAllBytes(Paths.get(javaClass.classLoader.getResource("reguly/test.txt").toURI()))));
    }
}