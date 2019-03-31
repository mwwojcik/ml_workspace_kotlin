package model.encje

import javax.persistence.*

@Entity
@Table(name="parametry_reguly")
data class ParametrRegulyEncja(
        val nazwa: String,
        var typ:String?=null,
        val wartoscDomyslna:String?=null
) :Encja() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long?=null

    @Version
    @Column(name="WERSJA")
    var wersja:Long?=null

    @ManyToOne
    lateinit var regula: RegulaEncja

    constructor(aNazwa: String, regula: RegulaEncja) : this(nazwa=aNazwa) {
        this.regula=regula
    }
}