package generator

import model.ast.RegulaAST
import model.dto.Regula
import org.springframework.stereotype.Component

@Component
class GeneratorStrukturyAST {

    fun konwertujDoAST(aRegula:Regula):RegulaAST{

        BudowniczyRegulyAST.inicjuj(aRegula.sekwencja.rozpoznaneTokeny)
        BudowniczyRegulyAST.sekwencja=aRegula.sekwencja

        return BudowniczyRegulyAST.buduj()
    }

}