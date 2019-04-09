package db.repo

import model.encje.ParametrWywolaniaRegulyEncja
import model.encje.WywolanieRegulyEncja
import org.springframework.data.repository.CrudRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional


interface IParametrWywolaniaRegulyRepozytorium : CrudRepository<ParametrWywolaniaRegulyEncja, Long>{
    fun findByWywolanie(aWywolanie:WywolanieRegulyEncja):List<ParametrWywolaniaRegulyEncja>

    @Transactional
    @Modifying
    @Query("delete from ParametrWywolaniaRegulyEncja p where p.wywolanie=:x")
    fun deleteByWywolanie(@Param("x") wywolanie:WywolanieRegulyEncja)
}