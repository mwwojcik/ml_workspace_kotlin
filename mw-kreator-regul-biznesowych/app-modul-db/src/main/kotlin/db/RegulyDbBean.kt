package db

import db.repo.IRegulaRepozytorium
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service



@Service
class RegulyDbBean {

    @Autowired
    lateinit var regulaRepozytorium: IRegulaRepozytorium

    fun znajdzWszystkieReguly(){
        println("+++++++++")
      /* for (elem in regulaRepozytorium.findAll()){
           println(elem.parametry)
           var test= readLine()
           println(test)
       }*/
    }
}