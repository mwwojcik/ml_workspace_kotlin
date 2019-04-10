package db

import db.repo.IParametrRegulyRepozytorium
import db.repo.IParametrWywolaniaRegulyRepozytorium
import db.repo.IRegulaRepozytorium
import db.repo.IWywolanieRegulyRepozytorium
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

    @Autowired
    private lateinit var wywolaniaRegulyRepozytorium: IWywolanieRegulyRepozytorium

    @Autowired
    private lateinit var parametrWywolaniaRegulyRepozytorium: IParametrWywolaniaRegulyRepozytorium


    @Transactional
    fun pobierzParametrRegulyPoNazwie(aRegulaEncja: RegulaEncja, aNazwa: String): ParametrRegulyEncja? =
            parametrRegulyRepozytorium.findByRegulaAndNazwa(aRegulaEncja, aNazwa)


    @Transactional
    fun pobierzRegulyJesliKoduNieMaNaLiscie(aKody:List<String>)=regulaRepozytorium.findByKodNotIn(aKody)

    @Transactional
    fun pobierzRegulePoKodzie(aKod: String): RegulaEncja? = regulaRepozytorium.findByKod(aKod)

    @Transactional
    fun pobierzRegulePoId(aId:Long):RegulaEncja?=regulaRepozytorium.findById(aId).get()

    @Transactional
    fun usunRegule(aRegula:RegulaEncja)=regulaRepozytorium.delete(aRegula)

    @Transactional
    fun pobierzWszystkieReguly()=regulaRepozytorium.findAll().sortedBy {it.kod}


    @Transactional
    fun usunWszystkieWywolaniaDoReguly(aRegula:RegulaEncja){
        wywolaniaRegulyRepozytorium.findByRegulaWolana(aRegula)?.forEach{
            parametrWywolaniaRegulyRepozytorium.deleteByWywolanie(it)
            usunObiektZarzadzalny(it)
        }

        wywolaniaRegulyRepozytorium.findByRegulaWolajaca(aRegula)?.forEach{
            parametrWywolaniaRegulyRepozytorium.deleteByWywolanie(it)
            usunObiektZarzadzalny(it)
        }
    }

    @Transactional
    fun usunWszystkieOdwolaniaDoParametru(aParametr:ParametrRegulyEncja){
        parametrWywolaniaRegulyRepozytorium.findByParametrRegulyWolajacej(aParametr)?.forEach{
            it.parametrRegulyWolajacej=null
        }

        parametrWywolaniaRegulyRepozytorium.findByParametrRegulyWolanej(aParametr)?.forEach{
            it.parametrRegulyWolanej=null
        }
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

    fun usunObiektZarzadzalny(aObiekt:Encja){
        entityManager.remove(aObiekt)
    }

    internal fun <T> utworzEncje(aKlasaObiektu: Class<T>): T {

        try {
            return aKlasaObiektu.newInstance() as T
        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }
    }
}