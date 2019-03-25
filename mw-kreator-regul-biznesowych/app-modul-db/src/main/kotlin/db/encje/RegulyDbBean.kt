package db.encje

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class RegulyDbBean {

    @Autowired
    lateinit var regulaDAO:IRegulaDao

    fun znajdzWszystkieReguly(){
        var reg=regulaDAO.findAll()
        println(reg)
    }
}