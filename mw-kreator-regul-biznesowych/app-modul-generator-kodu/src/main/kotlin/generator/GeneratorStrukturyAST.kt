package generator

import model.ast.RegulaAST
import model.dto.Regula
import org.springframework.stereotype.Component

@Component
class GeneratorStrukturyAST {

    fun konwertujDoAST(aRegula:Regula):RegulaAST{

        println(aRegula.kod+"=>"+aRegula.sekwencja.podajTokenyCzesciWarunkowejReguly())
        println("TAK=>"+aRegula.sekwencja.podajTokenyAkcjiTak())
        println("NIE=>"+aRegula.sekwencja.podajTokenyAkcjiNie())


        return RegulaAST()
    }

}