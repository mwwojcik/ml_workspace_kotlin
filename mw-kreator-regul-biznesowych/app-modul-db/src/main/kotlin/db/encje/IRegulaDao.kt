package db.encje

import org.aspectj.apache.bcel.Repository
import org.springframework.data.repository.CrudRepository

interface IRegulaDao: CrudRepository<RegulaEncja, Int> {
}