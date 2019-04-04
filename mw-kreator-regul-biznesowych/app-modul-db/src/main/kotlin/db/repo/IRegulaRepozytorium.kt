package db.repo


import model.encje.RegulaEncja
import org.springframework.data.repository.CrudRepository


public interface IRegulaRepozytorium:CrudRepository<RegulaEncja,Long>{
    fun findByKod(aKod:String):RegulaEncja?
    fun findByKodNotIn(aWykluczoneKody:List<String>):List<RegulaEncja>

}
