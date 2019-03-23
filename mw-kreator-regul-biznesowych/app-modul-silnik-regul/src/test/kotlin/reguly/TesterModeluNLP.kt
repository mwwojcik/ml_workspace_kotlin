package reguly

import com.google.common.io.ByteProcessor

import model.nlp.Sekwencja
import org.junit.Test
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PrzypadekTestowy(val sentencja: String, val spodziewanyOperatorWarunku: String)


class TesterModeluNLP {

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
    )


    //@Test
    fun testuj() {

        /*for ((index, test) in przypadki.withIndex()) {


            var s: Sekwencja = EgzaminatorModeluNLP.rozpoznajSekwencje(test.sentencja)

            println("\n**** Test " + index + " ****")

            s.drukuj()

            assertEquals(test.spodziewanyOperatorWarunku, s.dajPierwszyOperatorWarunku())
        }*/


    }

    //@Test
    fun czytajPlik(){
      /*  val p:Path= Paths.get(javaClass.classLoader.getResource("reguly/test.txt").path.replaceFirst(":",""))
        val s:String=String(Files.readAllBytes(p))
        println(s)*/

       println(String(Files.readAllBytes(Paths.get(javaClass.classLoader.getResource("reguly/test.txt").toURI()))));
    }
}