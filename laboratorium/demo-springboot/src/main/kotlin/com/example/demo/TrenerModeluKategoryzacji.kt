package com.example.demo

import opennlp.tools.doccat.DoccatFactory
import opennlp.tools.doccat.DoccatModel
import opennlp.tools.doccat.DocumentCategorizerME
import opennlp.tools.doccat.DocumentSampleStream
import opennlp.tools.namefind.*
import opennlp.tools.util.*
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.IllegalArgumentException
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import opennlp.tools.util.PlainTextByLineStream
import opennlp.tools.util.ObjectStream
import java.nio.file.Paths


class TrenerModeluKategoryzacji {

    public fun generujModel(aPlikRegulUczacychIn: Path, aPlikModeluOut: Path){
        zapiszModel(trenujModel(aPlikRegulUczacychIn),aPlikModeluOut)
    }


    private fun trenujModel(aZbiorRegul: Path): DoccatModel {
        // reading training data
        var inputFactory: InputStreamFactory?
        try {
            inputFactory = MarkableFileInputStreamFactory(aZbiorRegul.toFile())
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException(e)
        }


        var sampleStream: ObjectStream<*>?

        sampleStream = DocumentSampleStream(
                PlainTextByLineStream(inputFactory, StandardCharsets.UTF_8))

        // setting the parameters for training
        val params = TrainingParameters()
        params.put(TrainingParameters.ITERATIONS_PARAM, 100)
        params.put(TrainingParameters.CUTOFF_PARAM, 1)

        // training the model using TokenNameFinderModel class
        var documentCategorizerModel: DoccatModel?
        try {

            documentCategorizerModel = DocumentCategorizerME.train("en",  sampleStream,
                    params,DoccatFactory() )

            return documentCategorizerModel

        } catch (e: IOException) {
            throw IllegalArgumentException(e)
        }


    }


    private fun zapiszModel(modelDoZapisu: DoccatModel, aPlikModeluOut: Path){
        // saving the model to "ner-custom-model.bin" file
        try {
            val output = aPlikModeluOut.toFile()
            val outputStream = FileOutputStream(output)

            modelDoZapisu.serialize(outputStream)
            println("Trained model saved to file in location=>"+ aPlikModeluOut.toString())

        } catch (e: Exception) {
            throw IllegalArgumentException(e)
        }

    }
}

fun main(args: Array<String>) {
    val trener:TrenerModeluKategoryzacji= TrenerModeluKategoryzacji()

    trener.generujModel(Paths.get("probka_uczaca_kategorie.reg"),Paths.get("model_kategoryzacja.bin"))
}