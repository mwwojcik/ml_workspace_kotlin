package model.encje

import javax.persistence.*

@Entity
@Table(name="parametry_reguly")
data class ParametrRegulyEncja(
        val nazwa: String,
        var typ:String?=null,
        val wartoscDomyslna:String?=null
) :Encja(),IWalidowalny {

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

    @Transient
    override fun waliduj(): List<String> {
        val bledy:MutableList<String> = mutableListOf<String>()
        if(typ==null){
            bledy.add(zglosBladBrakuOkreslonegoTypu(nazwa))
        }
        return bledy
    }
}