package reguly.nlp

import model.nlp.Sekwencja

interface IFasadaNarzedziaNLP {

    fun rozpoznajSekwencje(aSekwencja:String): Sekwencja
}