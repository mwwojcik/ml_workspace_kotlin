package db

import db.repo.IParametrRegulyRepozytorium
import db.repo.IRegulaRepozytorium
import model.encje.Encja
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
open class RegulyDbBean {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    @Autowired
    lateinit var regulaRepozytorium: IRegulaRepozytorium

    @Autowired
    lateinit var parametrRegulyRepozytorium: IParametrRegulyRepozytorium


    @Transactional
    fun pobierzRegulePoKodzie(aKod: String): RegulaEncja {
        var pEncja: RegulaEncja? = regulaRepozytorium.findByKod(aKod)

        if (pEncja == null) {
            pEncja = utworzEncje(RegulaEncja::class.java)
            entityManager.persist(pEncja)
        } else {
            return pEncja
        }
        return pEncja
    }

    @Transactional
    fun zapiszRegule(aEncja: RegulaEncja) {
        regulaRepozytorium.save(aEncja)
    }

    @Transactional
    fun zapiszObiektParametru(aEncja: ParametrRegulyEncja) {
        //parametrRegulyRepozytorium.findById(aEncja.id).get().typ=aEncja.typ
        parametrRegulyRepozytorium.save(aEncja)
    }

    @Transactional
    fun pobierzParametryDlaReguly(aRegulaEncja: RegulaEncja): List<ParametrRegulyEncja>? {
        return parametrRegulyRepozytorium.findByRegula(aRegulaEncja)
    }

    @Transactional
    fun pobierzParametrPoNazwie(aRegulaEncja: RegulaEncja, aNazwa: String): ParametrRegulyEncja? {
        //zapiszRegule(aRegulaEncja)
        return parametrRegulyRepozytorium.findByRegulaAndNazwa(aRegulaEncja, aNazwa)
    }

    @Transactional
    fun <T : Encja> podajObiektZarzadzalny(aId: Long?=null, aKlasaObiektu: Class<T>): T {
        if (aId != null) {
            return entityManager.find(aKlasaObiektu, aId)
        } else {
            val pEncja: T = utworzEncje(aKlasaObiektu)
            entityManager.persist(pEncja)
            return pEncja
        }
    }

    internal fun <T> utworzEncje(aKlasaObiektu: Class<T>): T {

        try {
            return aKlasaObiektu.newInstance() as T
        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }
    }
}