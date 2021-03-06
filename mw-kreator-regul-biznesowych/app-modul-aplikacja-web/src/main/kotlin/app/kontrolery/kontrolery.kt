package app.kontrolery

import generator.GeneratorKoduBean
import model.dto.NowyParametrOW
import model.dto.Regula
import model.dto.RegulaWejscie
import model.dto.WrapperTekstu
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import uslugi.RegulyUslugaBean
import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping



@RestController
class GreetingController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    @CrossOrigin
    @GetMapping("/reguly")
    fun podajReguly()=regulyUsluga.podajReguly()

    @CrossOrigin
    @PostMapping("/regula")
    fun dodajRegule(@RequestBody aRegula:RegulaWejscie):List<Regula>{
        println(aRegula)
        regulyUsluga.zapiszRegule(aRegula.tresc!!)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @DeleteMapping("/regula/{id}")
    fun usunRegule(@PathVariable("id") id:Long):List<Regula>{
        regulyUsluga.usunRegule(id)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @PutMapping("/regulawejscie")
    fun modyfikujRegule(@RequestBody aRegula:RegulaWejscie):List<Regula>{
        println(aRegula.tresc)
        regulyUsluga.zapiszRegule(aRegula.id!!,aRegula.kod!!,aRegula.tresc!!)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @PutMapping("/regula")
    fun modyfikujRegule(@RequestBody aRegula:Regula):List<Regula>{
        println(aRegula.tresc)
        regulyUsluga.zapiszRegule(aRegula)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @PutMapping("/parametr")
    fun dodajParametr(@RequestBody aNowyParametr: NowyParametrOW):List<Regula>{
        regulyUsluga.dodajParametr(aNowyParametr.regula,aNowyParametr.nazwaParametru)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @PutMapping("/usuwanyParametr")
    fun usunParametr(@RequestBody aRegula:Regula):List<Regula>{
        regulyUsluga.usunParametr(aRegula)
        return regulyUsluga.podajReguly()
    }

    @CrossOrigin
    @GetMapping("/kod")
    fun generujKod()=WrapperTekstu(regulyUsluga.generujKod())
}



