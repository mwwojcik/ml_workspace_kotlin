package reguly

import model.nlp.Sekwencja
import org.junit.Assert.assertEquals
import org.junit.Test
import reguly.nlp.EgzaminatorModeluRozpoznawaniaEncjiNLP
import reguly.nlp.NormalizatorSekwencjiNLP
import java.nio.file.Files
import java.nio.file.Paths


class PrzypadekTestowy(val lp:Int,val sentencja: String, val spodziewanyOperatorWarunku: String,var licznosciTokenow : List<Int> = emptyList())


class TesterModeluNLP {

    val egzaminator: EgzaminatorModeluRozpoznawaniaEncjiNLP = EgzaminatorModeluRozpoznawaniaEncjiNLP()

    val normalizator= NormalizatorSekwencjiNLP()
   /* companion object {



        @BeforeClass

    }*/


    fun inicjalizuj(){
        egzaminator.plikModelu="modelnlp/encje_reguly_model.bin"
        egzaminator.inicjujModel()

    }


    val przypadki = arrayListOf<PrzypadekTestowy>(
            //operatory podstawowe 'jest równy','jest większy lub równy', 'jest mniejszy lub równy'
            PrzypadekTestowy(1,"Jeśli data jest       równa '01-01-2000',      wtedy         wyświetl komunikat <KOMUNIKAT1>.",
                    "jest równa")
            , PrzypadekTestowy(2,"Jeśli data jest większa lub równa '01-01-2000' wtedy wyświetl komunikat <KOMUNIKAT1> .", "jest większa lub równa")
            , PrzypadekTestowy(3,"Jeśli nachylenie jest mniejsze lub równe 30 wtedy wyświetl komunikat <KOMUNIKAT1> .", "jest mniejsze lub równe")
            //operatory podstawowe zaprzeczone 'nie jest równy','nie jest większy lub równy', 'nie jest mniejszy lub równy'

            , PrzypadekTestowy(4,"Jeśli data nie jest równa '01-01-2000' wtedy wyświetl komunikat <KOMUNIKAT1> .", "nie jest równa")
            , PrzypadekTestowy(5,"Jeśli data nie jest większa '01-01-2000' wtedy wyświetl komunikat <KOMUNIKAT1> .", "nie jest większa")
            , PrzypadekTestowy(6,"Jeśli nachylenie nie jest mniejsze  30 wtedy wyświetl komunikat <KOMUNIKAT1> .", "nie jest mniejsze")

            //Operatory stopniowane (['jest większy niż', 'jest mniejszy od', 'jest różny od'])
            , PrzypadekTestowy(7,"Jeśli dochód jest większy niż 100 wtedy wyświetl komunikat <KOMUNIKAT1> .", "jest większy niż")
            , PrzypadekTestowy(8,"Jeżeli suma jest mniejsza od 50 to wyświetl komunikat <KOMUNIKAT1> .", "jest mniejsza od")
            , PrzypadekTestowy(9,"Jeżeli suma jest różna od 50 to wyświetl komunikat <KOMUNIKAT1> .", "jest różna od")

            //Operatory stopniowane zaprzeczone(['nie jest większy niż', 'nie jest mniejszy od', 'nie jest różny od'])
            , PrzypadekTestowy(10,"Jeśli dochód jest nie większy niż 100 wtedy wyświetl komunikat <KOMUNIKAT1> .", "jest nie większy niż")
            , PrzypadekTestowy(11,"Jeżeli suma nie jest mniejsza od 50 to wyświetl komunikat <KOMUNIKAT1> .", "nie jest mniejsza od")
            , PrzypadekTestowy(12,"Jeżeli suma nie jest różna od 50 to wyświetl komunikat <KOMUNIKAT1> .", "nie jest różna od")
            //, PrzypadekTestowy("Jeśli rok jest równy 2000 to wyświetl komunikat <KOMUNIKAT1> .","jest równy")
            , PrzypadekTestowy(13,"Jeśli rok nie jest mniejszy niż 2000 wtedy wyświetl komunikat <KOMUNIKAT1> .","nie jest mniejszy niż")
            , PrzypadekTestowy(14,"Jeśli miesiąc jest nie mniejszy niż styczeń to wyświetl komunikat <KOMUNIKAT1> .","jest nie mniejszy niż")
            , PrzypadekTestowy(15,"Jeśli data jest nie większa niż '01-01-2019' to zgłoś błąd <KOMUNIKAT1> .","jest nie większa niż")
            , PrzypadekTestowy(16,"Jeśli dzień jest równy data_wczoraj to zgłoś błąd <KOMUNIKAT1> .","jest równy")
            , PrzypadekTestowy(17,"Jeśli miesiąc jest nie mniejszy niż 6 to sprawdzaj regułę <KOMUNIKAT1> .","jest nie mniejszy niż")
            , PrzypadekTestowy(18,"Jeśli data jest różna od poczatek_roku oraz rok jest większy niż 2000 lub dzień jest różny od 12 to wyświetl komunikat <KOMUNIKAT_1> .","jest różna od", arrayListOf(11,2,0))
            , PrzypadekTestowy(19,"Gdy suma jest większa od 100 i różnica jest mniejsza od 0 lub różnica jest równa 1 wtedy wyświetl komunikat <KOMUNIKAT_2> .","jest większa od")
            , PrzypadekTestowy(20,"Jeśli data jest większa od '01-01-2010' oraz data_utworzenia nie jest mniejsza niż data_kwalifikacji i data_kwalifikacji jest różna od data_weryfikacji to zgłoś błąd walidacji <KOMUNIKAT_WALIDACJI_1> .","jest większa od")
            , PrzypadekTestowy(21,"Jeśli data jest większa od '01-01-2010' oraz data_utworzenia nie jest mniejsza niż data_kwalifikacji i data_kwalifikacji jest różna od data_weryfikacji to zgłoś błąd walidacji <KOMUNIKAT_WALIDACJI_1> .","jest większa od")
            , PrzypadekTestowy(22,"Jeśli nachylenie nie jest mniejsze lub równe 30 wtedy wyświetl komunikat <KOMUNIKAT_0> .", "nie jest mniejsze lub równe")
            , PrzypadekTestowy(23,"Jeśli nachylenie nie jest mniejsze lub równe 30 wtedy wyświetl komunikat <KOMUNIKAT_0> w przeciwnym wypadku wyświetl komunikat <KOMUNIKAT2> .", "nie jest mniejsze lub równe")
            , PrzypadekTestowy(24,"Jeżeli suma jest różna od 50 to wyświetl komunikat <KOMUNIKAT1> w przeciwnym wypadku sprawdź regułę RS-1 .", "jest różna od")
            , PrzypadekTestowy(25,"Jeśli utworzenia jest większa od '01-01-2010' oraz data_utworzenia nie jest mniejsza niż data_kwalifikacji i data_kwalifikacji jest różna od data_weryfikacji to zgłoś błąd walidacji <KOMUNIKAT_WALIDACJI_1> w przeciwnym razie wyświetl komunikat <KOMUNIKAT2> .","jest większa od")
            , PrzypadekTestowy(26,"Jeśli urodzenia jest większa niż poczatek wtedy wyświetl komunikat Kom w przeciwnym wypadku zgłaszaj błąd walidac W1","jest większa niż")
            , PrzypadekTestowy(27,"Jeśli pole jest większe niż dzien wtedy wyświetl komunikat <KOMUNIKAT> w przeciwnym wypadku zgłaszaj błąd walidac W1 .","jest większe niż")
            , PrzypadekTestowy(28,"Jeśli wiek jest mniejszy niż 18 wtedy zgłoś błąd KOMUNIKAT1 w przeciwnym wypadku wyświetl komunikat KOMUNIKAT2 .","jest mniejszy niż")
            , PrzypadekTestowy(29,"Jeśli wiek jest mniejszy niż 18 i rok_urodzenia jest większy niż 1980 i miesiac_urodzenia jest mniejszy niż 3 wtedy zgłoś błąd KOMUNIKAT1 w przeciwnym wypadku wyświetl komunikat KOMUNIKAT2 .","jest mniejszy niż",arrayListOf(11,2,2))


    )


    @Test
    fun testuj() {

        inicjalizuj()

        for ((index, test) in przypadki.withIndex()) {


            var s: Sekwencja = egzaminator.rozpoznajSekwencje(normalizator.zwrocPostacZnormalizowana(test.sentencja).postacKanoniczna)

            println("\n**** Test " + test.lp + " ****")

            s.drukuj()

            assertEquals(test.spodziewanyOperatorWarunku, s.dajPierwszyOperatorWarunku())

            if(!test.licznosciTokenow.isEmpty()&&test.licznosciTokenow.size==3){
                val warunekIloscTokenow=test.licznosciTokenow[0]
                val takIloscTokenow=test.licznosciTokenow[1]
                val nieIloscTokenow=test.licznosciTokenow[2]

                assertEquals(warunekIloscTokenow,s.podajTokenyCzesciWarunkowejReguly().size)
                assertEquals(takIloscTokenow,s.podajTokenyAkcjiTak().size)
                assertEquals(nieIloscTokenow,s.podajTokenyAkcjiNie().size)
            }
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