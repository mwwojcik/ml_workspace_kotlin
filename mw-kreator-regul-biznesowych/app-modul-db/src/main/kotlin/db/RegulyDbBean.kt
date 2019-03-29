package db

import db.repo.IRegulaRepozytorium
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class RegulyDbBean {

    @Autowired
    lateinit var regulaRepozytorium: IRegulaRepozytorium

    fun pobierzRegulePoKodzie(aKod:String):RegulaEncja?{
        return regulaRepozytorium.findByKod(aKod)
    }

    fun zapiszRegule(aEncja:RegulaEncja){
        regulaRepozytorium.save(aEncja)
    }
}