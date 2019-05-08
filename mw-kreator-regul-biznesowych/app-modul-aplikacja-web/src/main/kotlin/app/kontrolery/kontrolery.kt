package app.kontrolery

import generator.GeneratorKoduBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import uslugi.RegulyUslugaBean
import java.util.concurrent.atomic.AtomicLong

data class Greeting(val id: Long, val content: String)

@RestController
class GreetingController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    @Autowired
    lateinit var generatorKodu: GeneratorKoduBean


    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @GetMapping("/reguly")
    fun podajReguly()=regulyUsluga.podajReguly()
}