package model.encje

import org.springframework.data.util.ProxyUtils
import javax.persistence.*

@MappedSuperclass
open class Encja{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Version
    @Column(name = "WERSJA",columnDefinition = "integer DEFAULT 1", nullable = false)
    var wersja: Long=1


    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as Encja

        return if (null == this.id) false else this.id == other.id
    }

    override fun hashCode(): Int {
        return 31
    }

    override fun toString() = "Entity of type ${this.javaClass.name} with id: $id"
}