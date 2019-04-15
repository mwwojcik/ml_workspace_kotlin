package generator

import model.ast.RegulaAST
import model.dto.Regula
import org.springframework.stereotype.Component

@Component
open class GeneratorKoduBean {

    private fun konwertujDoAST(aRegula: Regula): RegulaAST {

        BudowniczyRegulyAST.inicjuj(aRegula.sekwencja.rozpoznaneTokeny)
        BudowniczyRegulyAST.sekwencja = aRegula.sekwencja

        return BudowniczyRegulyAST.buduj()
    }

    fun generujKodDlaRegul(aReguly: List<Regula>): String {

        val listaRegul: MutableList<Pair<RegulaAST, Regula>> = mutableListOf<Pair<RegulaAST, Regula>>()

        for (reg in aReguly) {
            println(reg.kod+"=>")
            val ast = konwertujDoAST(reg)
            listaRegul.add(Pair(ast, reg))
        }

        return KonstruktorWalidatoraRegul.buduj(listaRegul)

    }
}