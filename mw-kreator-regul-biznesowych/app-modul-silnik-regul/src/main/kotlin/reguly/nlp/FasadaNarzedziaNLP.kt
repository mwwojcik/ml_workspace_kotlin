package reguly.nlp

import model.nlp.RodzajTokenaEnum
import model.nlp.Sekwencja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
open class FasadaNarzedziaNLP : IFasadaNarzedziaNLP {
    @Autowired
    lateinit var normalizatorSekwencji: NormalizatorSekwencjiNLP
    @Autowired
    lateinit var egzaminatorModeluReguly: EgzaminatorModeluRozpoznawaniaEncjiNLP
    @Autowired
    lateinit var egzaminatorModeluKategorii: EgzaminatorModeluKategoryzacjiNLP


    override fun rozpoznajSekwencje(aSekwencja: String): Sekwencja {
        val postacZnormalizowana=normalizatorSekwencji.zwrocPostacZnormalizowana(aSekwencja)

        //analizie poddajemy postac kanoniczna
        val sekwencja =
                egzaminatorModeluReguly.rozpoznajSekwencje(postacZnormalizowana.postacKanoniczna)

        sekwencja.rozpoznaneTokeny.filter {
            it.typ == RodzajTokenaEnum.OPETATOR_POROWNANIA || it.typ == RodzajTokenaEnum.AKCJA
            ||it.typ==RodzajTokenaEnum.OPERATOR_LOGICZNY
        }.forEach {
            it.kategoria = egzaminatorModeluKategorii.wybierzNajlepszaKategorie(it.wartosc)
        }

        sekwencja.postacKanoniczna=postacZnormalizowana.postacKanoniczna
        sekwencja.komunikaty=if(!postacZnormalizowana.komunikaty.isNullOrEmpty())
            postacZnormalizowana.komunikaty
        else
            null

        return sekwencja
    }

}