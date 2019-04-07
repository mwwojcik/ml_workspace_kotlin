package reguly

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.EnableTransactionManagement
import reguly.nlp.NormalizatorSekwencjiNLP
import kotlin.test.assertTrue


@SpringBootTest
@ComponentScan(basePackages = arrayOf("app","reguly","generator","reguly","db","uslugi"))
@EnableJpaRepositories(basePackages = arrayOf("db"))
@EntityScan( basePackages = arrayOf("model","encje","model.encje"))
@EnableTransactionManagement
open class TesterNormalizatoraSekwencji {

    @Autowired
    lateinit var normalizator:NormalizatorSekwencjiNLP

    @Test
    fun uruchomTest(){
        val normalizator=NormalizatorSekwencjiNLP()

        val postac=normalizator.zwrocPostacZnormalizowana("Jeśli data jest większa od '01-01-2019' to wyświetl komunikat \"data jest większa\" w przeciwnym wypadku wyświetl komunikat \"data wcale nie jest większa tylko mniejsza\"")

        assertTrue { postac.komunikaty!=null && postac.komunikaty!!.keys.size==2 }
        println(postac.postacKanoniczna)

        val regulaBezDopasowan="Jeśli rok jest większy niż 2000 to sprawdź regułę RS-200"
        val postacBezDopasowan=normalizator.zwrocPostacZnormalizowana(regulaBezDopasowan)

        assertTrue { postacBezDopasowan.komunikaty!=null && postacBezDopasowan.komunikaty!!.keys.size==0 }

    }
}