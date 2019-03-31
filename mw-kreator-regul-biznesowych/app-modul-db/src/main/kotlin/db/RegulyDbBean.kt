package db

import db.repo.IParametrRegulyRepozytorium
import db.repo.IRegulaRepozytorium
import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
open class RegulyDbBean {

    @Autowired
    lateinit var regulaRepozytorium: IRegulaRepozytorium

    @Autowired
    lateinit var parametrRegulyRepozytorium:IParametrRegulyRepozytorium


    @Transactional
    fun pobierzRegulePoKodzie(aKod:String):RegulaEncja?{
        return regulaRepozytorium.findByKod(aKod)
    }

    @Transactional
    fun zapiszRegule(aEncja:RegulaEncja){
        regulaRepozytorium.save(aEncja)

        if(aEncja.parametry!=null) {
            for (param in aEncja.parametry!!) {
                parametrRegulyRepozytorium.save(param)
            }
        }
    }

    @Transactional
    fun zapiszObiektParametru(aEncja:ParametrRegulyEncja){
        //parametrRegulyRepozytorium.findById(aEncja.id).get().typ=aEncja.typ
        parametrRegulyRepozytorium.save(aEncja)
    }

    @Transactional
    fun pobierzParametryDlaReguly(aRegulaEncja:RegulaEncja):List<ParametrRegulyEncja>?{
        return parametrRegulyRepozytorium.findByRegula(aRegulaEncja)
    }

    @Transactional
    fun pobierzParametrPoNazwie(aRegulaEncja: RegulaEncja,aNazwa:String):ParametrRegulyEncja?{
        //zapiszRegule(aRegulaEncja)
        return parametrRegulyRepozytorium.findByRegulaAndNazwa(aRegulaEncja,aNazwa)
    }
}