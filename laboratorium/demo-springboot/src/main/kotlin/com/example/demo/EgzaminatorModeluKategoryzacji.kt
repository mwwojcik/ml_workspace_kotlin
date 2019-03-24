package com.example.demo

import opennlp.tools.doccat.DoccatModel
import opennlp.tools.doccat.DocumentCategorizerME
import java.io.FileInputStream

class EgzaminatorModeluKategoryzacji {

    val plikModelu="model_kategoryzacja.bin"

    lateinit var model:DoccatModel

    public fun inicjujModel(){
        model=odczytajModel()
    }

    private fun odczytajModel(): DoccatModel {
        lateinit var modelNLP: DoccatModel
        try {

            //this.javaClass.classLoader.getResourceAsStream(plikModelu)
            FileInputStream(plikModelu).use { modelIn ->
                modelNLP = DoccatModel(modelIn)
                //println("Trained model read from location=>"+ plikModelu.toAbsolutePath().toString())
                return modelNLP
            }
        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }
    }

    fun wybierzNajlepszaKategorie(text: String): String {
        val documentCategorizerME=DocumentCategorizerME(model);
        val outcomes = documentCategorizerME.categorize(text.split(" ").toTypedArray())
        return documentCategorizerME.getBestCategory(outcomes)
    }
}


fun main(args: Array<String>) {
    val egzaminator= EgzaminatorModeluKategoryzacji()

    egzaminator.inicjujModel()
    println(egzaminator.wybierzNajlepszaKategorie("mniejsza lub równa"))

}