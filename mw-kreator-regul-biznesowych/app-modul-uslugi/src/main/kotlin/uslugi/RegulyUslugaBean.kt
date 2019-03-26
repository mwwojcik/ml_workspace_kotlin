package uslugi

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class RegulyUslugaBean{
    @Autowired
    lateinit var regulyDbBean: RegulyDbBean

    fun wyswietlReguly(){
        println("Pobieram wszystkie reguly!!!!")
        regulyDbBean.znajdzWszystkieReguly()
    }
}