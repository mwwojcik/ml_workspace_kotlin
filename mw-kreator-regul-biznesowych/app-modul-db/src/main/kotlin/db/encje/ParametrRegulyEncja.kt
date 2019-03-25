package db.encje

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class ParametrRegulyEncja(
        @Id @GeneratedValue
        val id: Int = 0,
        val nazwa: String,
        val typ:String?=null,
        val wartoscDomyslna:String?=null
) {
    @ManyToOne
    lateinit var regula: RegulaEncja

    constructor(aNazwa: String, regula:RegulaEncja) : this(nazwa=aNazwa) {
        this.regula=regula
    }
}