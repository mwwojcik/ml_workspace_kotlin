package reguly.nlp

import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class FasadaNarzedziaNLP:IFasadaNarzedziaNLP {
    @Autowired
    lateinit var tokenizerSentencji:TokenizerSentencji
    @Autowired
    lateinit var egzaminatorModeluReguly:EgzaminatorModeluRozpoznawaniaEncjiNLP
    @Autowired
    lateinit var egzaminatorModeluKategorii:EgzaminatorModeluKategoryzacjiNLP




    override fun rozpoznajSekwencje(aSekwencja: String): Sekwencja {
            val sekwencja=
                    egzaminatorModeluReguly.rozpoznajSekwencje(tokenizerSentencji.przygotujZdanieDoAnalizy(aSekwencja))

            sekwencja.rozpoznaneTokeny.filter { it.typ==RodzajTokenaEnum.OPETATOR_POROWNANIA }.forEach{
                it.kategoria=egzaminatorModeluKategorii.wybierzNajlepszaKategorie(it.wartosc)
            }
        return sekwencja
    }

}