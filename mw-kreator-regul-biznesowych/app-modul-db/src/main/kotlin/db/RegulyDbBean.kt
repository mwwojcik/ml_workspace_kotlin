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
    private lateinit var entityManager: EntityManager

    @Autowired
    private lateinit var regulaRepozytorium: IRegulaRepozytorium

    @Autowired
    private lateinit var parametrRegulyRepozytorium: IParametrRegulyRepozytorium




    @Transactional
    fun pobierzParametrPoNazwie(aRegulaEncja: RegulaEncja, aNazwa: String): ParametrRegulyEncja? =
            parametrRegulyRepozytorium.findByRegulaAndNazwa(aRegulaEncja, aNazwa)


    @Transactional
    fun pobierzRegulyJesliKoduNieMaNaLiscie(aKody:List<String>)=regulaRepozytorium.findByKodNotIn(aKody)

    @Transactional
    fun pobierzRegulePoKodzie(aKod: String): RegulaEncja? = regulaRepozytorium.findByKod(aKod)

    @Transactional
    fun usunRegule(aRegula:RegulaEncja)=regulaRepozytorium.delete(aRegula)

    @Transactional
    fun pobierzWszystkieReguly()=regulaRepozytorium.findAll().sortedBy {it.kod}


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