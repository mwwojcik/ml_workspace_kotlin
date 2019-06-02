package db.repo

import model.encje.NumeracjaKodowEncja
import org.springframework.data.repository.CrudRepository

interface INumeracjaKodowRepozytorium : CrudRepository<NumeracjaKodowEncja, Long> {
}