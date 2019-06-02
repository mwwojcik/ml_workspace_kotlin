package db

import db.repo.*
import model.encje.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
@Transactional
open class RegulyDbBean {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    @Autowired
    private lateinit var numerKolejnyKoduRepozytorium: INumeracjaKodowRepozytorium

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
    fun pobierzNumerKolejnyKodu(): Long{
        val pEncja=numerKolejnyKoduRepozytorium.findById(1L).get()
        pEncja.numerKolejny+=1
        return pEncja.numerKolejny
    }


    @Transactional
    fun pobierzRegulyJesliKoduNieMaNaLiscie(aKody:List<String>)=regulaRepozytorium.findByKodNotIn(aKody)

    @Transactional
    fun pobierzRegulePoKodzie(aKod: String): RegulaEncja? = regulaRepozytorium.findByKod(aKod)

    @Transactional
    fun pobierzRegulePoId(aId:Long):RegulaEncja?=regulaRepozytorium.findById(aId).get()

    @Transactional
    fun usunRegule(aRegula:RegulaEncja)=regulaRepozytorium.delete(aRegula)

    @Transactional
    fun usunRegule(aId:Long){
        val pEncja=podajObiektZarzadzalny(aId,RegulaEncja::class.java)
        usunRegule(pEncja)
    }

    @Transactional
    fun pobierzWszystkieReguly()=regulaRepozytorium.findAll().sortedBy {it.kod}


   /* @Transactional
    fun usunWszystkieWywolaniaDoReguly(aRegula:RegulaEncja){
        wywolaniaRegulyRepozytorium.findByRegulaWolana(aRegula)?.forEach{
            parametrWywolaniaRegulyRepozytorium.deleteByWywolanie(it)
            it.regulaWolana.wywolaniaRegul.remove(it)
            it.regulaWolana=null
        }*/

       /* wywolaniaRegulyRepozytorium.findByRegulaWolajaca(aRegula)?.forEach{
            parametrWywolaniaRegulyRepozytorium.deleteByWywolanie(it)
            it.regulaWolajaca.wywolaniaRegul=null
        }

        wywolaniaRegulyRepozytorium.deleteByRegulaWolajaca(aRegula)*/
        //wywolaniaRegulyRepozytorium.deleteByRegulaWolana(aRegula)


    //}

    @Transactional
    fun pobierzWszystkieWywolaniaDoReguly(aRegulaWolana:RegulaEncja):List<WywolanieRegulyEncja> =
        wywolaniaRegulyRepozytorium.findByRegulaWolana(aRegulaWolana)



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