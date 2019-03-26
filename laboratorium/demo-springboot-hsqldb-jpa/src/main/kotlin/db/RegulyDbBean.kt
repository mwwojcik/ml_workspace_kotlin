package db

import db.repo.IRegulaRepozytorium
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class RegulyDbBean {

   @Autowired
    lateinit var regulaRepozytorium: IRegulaRepozytorium

    fun znajdzWszystkieReguly(){
        var reg=regulaRepozytorium.findAll()
        println(reg)
    }
}