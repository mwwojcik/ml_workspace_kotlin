package db.repo

import model.encje.RegulaEncja
import model.encje.WywolanieRegulyEncja
import org.springframework.data.repository.CrudRepository

interface IWywolanieRegulyRepozytorium: CrudRepository<WywolanieRegulyEncja, Long> {
    fun findByRegulaWolana(aRegulaWolana:RegulaEncja):List<WywolanieRegulyEncja>
    fun findByRegulaWolajaca(aRegulaWolana:RegulaEncja):List<WywolanieRegulyEncja>
}

/*

@Transactional
    @Modifying
    @Query("delete from Employe e where e.idEmploye=:x")
    public Employe deleteEmploye(@Param("x") int idEmploye);

 */