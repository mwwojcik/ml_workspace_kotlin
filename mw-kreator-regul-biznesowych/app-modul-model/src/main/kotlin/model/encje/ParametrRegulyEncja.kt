package model.encje

import javax.persistence.*

@Entity
@Table(name="parametry_reguly")
data class ParametrRegulyEncja(
        val nazwa: String,
        var typ:String?=null,
        val wartoscDomyslna:String?=null
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var  id=0

    @ManyToOne
    lateinit var regula: RegulaEncja

    constructor(aNazwa: String, regula: RegulaEncja) : this(nazwa=aNazwa) {
        this.regula=regula
    }
}