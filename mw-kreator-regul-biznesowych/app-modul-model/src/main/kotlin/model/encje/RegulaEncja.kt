package model.encje

import model.nlp.Sekwencja
import javax.persistence.*

@Entity
@Table(name = "reguly")
open class RegulaEncja(
        val kod: String,
        var tresc: String
) : Encja() {

 /*   @Transient
    var parametry: MutableList<ParametrRegulyEncja>? = null

    @Transient
    var sekwencja: Sekwencja? = null*/

    //@OneToMany(mappedBy = "regula", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))

}

/*

@Transient
    var parametry: MutableList<ParametrRegulyEncja>? = null



    @Transient
    override fun waliduj(): List<String> {
        val bledy: MutableList<String> = mutableListOf<String>()

        if (parametry != null) {
            parametry!!.forEach {
                val wynik=it.waliduj()
                if(!wynik.isEmpty()) {
                    bledy.addAll(wynik)
                }
            }
        }

        return bledy
    }
*
* */
