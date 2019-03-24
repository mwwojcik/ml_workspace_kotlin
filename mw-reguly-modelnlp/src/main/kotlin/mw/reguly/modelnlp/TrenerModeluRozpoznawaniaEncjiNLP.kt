package mw.reguly.modelnlp

import opennlp.tools.namefind.*
import opennlp.tools.postag.POSModel
import opennlp.tools.util.*
import java.io.*
import java.lang.IllegalArgumentException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

object TrenerModeluRozpoznawaniaEncjiNLP {

    public fun generujModel(aPlikRegulUczacychIn:Path,aPlikModeluOut:Path){
        zapiszModel(trenujModel(aPlikRegulUczacychIn),aPlikModeluOut)
    }


    private fun trenujModel(aZbiorRegul:Path): TokenNameFinderModel {
        // reading training data
        var inputFactory: InputStreamFactory?
        try {
            inputFactory = MarkableFileInputStreamFactory(aZbiorRegul.toFile())
        } catch (e: FileNotFoundException) {
            throw IllegalArgumentException(e)
        }

        var sampleStream: ObjectStream<*>?

        sampleStream = NameSampleDataStream(
                PlainTextByLineStream(inputFactory, StandardCharsets.UTF_8))

        // setting the parameters for training
        val params = TrainingParameters()
        params.put(TrainingParameters.ITERATIONS_PARAM, 70)
        params.put(TrainingParameters.CUTOFF_PARAM, 1)

        // training the model using TokenNameFinderModel class
        var nameFinderModel: TokenNameFinderModel?
        try {
            nameFinderModel = NameFinderME.train("en", null, sampleStream,
                    params, TokenNameFinderFactory.create(null, null, mutableMapOf<String, Any>(), BioCodec()))

            return nameFinderModel

        } catch (e: IOException) {
            throw IllegalArgumentException(e)
        }


    }


    private fun zapiszModel(modelDoZapisu: TokenNameFinderModel,aPlikModeluOut:Path){
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

