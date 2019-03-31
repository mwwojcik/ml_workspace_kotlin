package model.encje

import model.nlp.Sekwencja
import javax.persistence.*

@Entity
@Table(name = "reguly")
data class RegulaEncja(
        val kod: String,
        val tresc: String
) : Encja(), IWalidowalny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Version
    @Column(name = "WERSJA")
    var wersja: Long? = null

    @OneToMany(mappedBy = "regula", fetch = FetchType.EAGER, cascade = arrayOf(CascadeType.ALL))
    var parametry: MutableList<ParametrRegulyEncja>? = null

    @Transient
    var sekwencja: Sekwencja? = null

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
}