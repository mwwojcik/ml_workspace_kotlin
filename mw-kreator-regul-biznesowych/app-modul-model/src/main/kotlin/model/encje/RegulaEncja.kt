package model.encje

import model.nlp.Sekwencja
import javax.persistence.*

@Entity
@Table(name = "reguly")
data class RegulaEncja(
        val kod: String,
        val tresc:String
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int =0

    @OneToMany(mappedBy = "regula",fetch = FetchType.EAGER)
    var parametry: MutableList<ParametrRegulyEncja> = mutableListOf()

    @Transient
    var sekwencja: Sekwencja?=null

}