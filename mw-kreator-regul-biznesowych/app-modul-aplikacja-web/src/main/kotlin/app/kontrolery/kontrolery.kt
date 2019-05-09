package app.kontrolery

import generator.GeneratorKoduBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import uslugi.RegulyUslugaBean
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    @GetMapping("/reguly")
    fun podajReguly()=regulyUsluga.podajReguly()
}