package db.encje

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class RegulaEncja(
        @Id @GeneratedValue
        val id: Int = 0,
        val nazwa: String
){
    @OneToMany(mappedBy = "regula")
    val tasks: MutableSet<ParametrRegulyEncja> = HashSet()
}