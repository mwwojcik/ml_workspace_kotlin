package app.kontrolery

import generator.GeneratorKoduBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import uslugi.RegulyUslugaBean
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    @CrossOrigin
    @GetMapping("/reguly")
    fun podajReguly()=regulyUsluga.podajReguly()

    @CrossOrigin
    @GetMapping("/hero")
    fun podajBohaterow()= arrayListOf<Hero>(Hero(1,"Batman"),Hero(2,"Superman"),Hero(3,"Spiderman"),Hero(11,"SuperBird"))
}



data class Hero(val id:Int,val name:String)