package db.repo

import model.encje.ParametrRegulyEncja
import model.encje.RegulaEncja
import org.springframework.data.repository.CrudRepository

interface IParametrRegulyRepozytorium : CrudRepository<ParametrRegulyEncja, Long> {
    fun findByRegula(aRegula: RegulaEncja): List<ParametrRegulyEncja>?
    fun findByRegulaAndNazwa(aRegula: RegulaEncja,aNazwa:String):ParametrRegulyEncja?
}