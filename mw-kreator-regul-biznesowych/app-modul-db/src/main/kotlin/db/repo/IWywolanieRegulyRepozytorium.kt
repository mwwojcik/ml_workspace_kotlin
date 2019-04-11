package db.repo

import model.encje.RegulaEncja
import model.encje.WywolanieRegulyEncja
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

interface IWywolanieRegulyRepozytorium: CrudRepository<WywolanieRegulyEncja, Long> {
    fun findByRegulaWolana(aRegulaWolana:RegulaEncja):List<WywolanieRegulyEncja>
    fun findByRegulaWolajaca(aRegulaWolana:RegulaEncja):List<WywolanieRegulyEncja>

    @Transactional
    @Modifying
    @Query("delete from WywolanieRegulyEncja w where w.regulaWolana=:x")
    fun deleteByRegulaWolana(@Param("x") aEncja:RegulaEncja)

    @Transactional
    @Modifying
    @Query("delete from WywolanieRegulyEncja w where w.regulaWolajaca=:x")
    fun deleteByRegulaWolajaca(@Param("x") aEncja:RegulaEncja)

}

/*

@Transactional
    @Modifying
    @Query("delete from Employe e where e.idEmploye=:x")
    public Employe deleteEmploye(@Param("x") int idEmploye);

 */