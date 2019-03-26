package db.encje

import javax.persistence.*

@Entity
@Table(name = "")
data class RegulaEncja(
        @Id @GeneratedValue
        val id: Int = 0,
        val nazwa: String
){
    @OneToMany(mappedBy = "regula")
    val tasks: MutableSet<ParametrRegulyEncja> = HashSet()
}