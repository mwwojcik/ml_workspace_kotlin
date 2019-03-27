package model.encje

import model.nlp.Sekwencja
import javax.persistence.*

@Entity
@Table(name = "reguly")
data class RegulaEncja(
        @Id @GeneratedValue
        val id: Int = 0,
        val nazwa: String,
        @Transient
        val tresc:String
){
    @OneToMany(mappedBy = "regula",fetch = FetchType.EAGER)
    var parametry: MutableList<ParametrRegulyEncja> = mutableListOf()

    @Transient
    var sekwencja: Sekwencja?=null


    @Transient
    var kod:String?=null
}