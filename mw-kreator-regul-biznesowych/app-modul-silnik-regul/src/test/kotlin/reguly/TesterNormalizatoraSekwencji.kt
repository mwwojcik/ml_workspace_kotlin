package reguly


import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import reguly.nlp.NormalizatorSekwencjiNLP
import javax.annotation.PostConstruct



@SpringBootTest(classes = arrayOf(NormalizatorSekwencjiNLP::class))
@RunWith(SpringRunner::class)
open class TesterNormalizatoraSekwencjiTest {
    @PostConstruct
    fun init() {
        println("")
    }

    @Autowired
    lateinit var normalizator: NormalizatorSekwencjiNLP

    @Test
    fun uruchomTest() {

        val postac = normalizator.zwrocPostacZnormalizowana("Jeśli data jest większa od '01-01-2019' to wyświetl komunikat \"data jest większa\" w przeciwnym wypadku wyświetl komunikat \"data wcale nie jest większa tylko mniejsza\"")

        assertTrue ( postac.komunikaty != null && postac.komunikaty!!.keys.size == 2 )
        println(postac.postacKanoniczna)

        val regulaBezDopasowan = "Jeśli rok jest większy niż 2000 to sprawdź regułę RS-200"
        val postacBezDopasowan = normalizator.zwrocPostacZnormalizowana(regulaBezDopasowan)

        assertTrue ( postacBezDopasowan.komunikaty != null && postacBezDopasowan.komunikaty!!.keys.size == 0 )

    }
}