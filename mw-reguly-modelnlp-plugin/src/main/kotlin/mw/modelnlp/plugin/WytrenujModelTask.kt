package mw.modelnlp.plugin

import mw.reguly.modelnlp.TrenerModeluKategoryzacjiNLP
import mw.reguly.modelnlp.TrenerModeluRozpoznawaniaEncjiNLP
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import java.io.File
import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

open class WytrenujModelTask: DefaultTask() {

    @InputDirectory
    @Optional
    var katalogRegul: Path = project.file("src/main/modelnlp/reguly").toPath()

   /* @InputFile
    @Optional
    var plikRegul: Path = project.file(katalogRegul.resolve("reguly_probka_uczaca.reg")).toPath()*/


    @OutputDirectory
    @Optional
    var katalogModeluOUT:Path = project.file("src/main/modelnlp/bin").toPath()
    //project.file("${project.buildDir}/generated-src")

    /**
     * Skanujemy katalog $katalogRegul w poszukiwaniu wszystkich plików reguł *.reg
     * Iterujemy przez znalezione zbiory
     *  Dla każdego elementu dokonujemy split("_")
     *  tab[0]->mówi nam o rodzaju modelu {encje,kategoryzacja}
     *  encje_reguly_probka_uczaca.reg ->encje_model.bin
     *  kategoryzacja_reguly_probka_uczaca-.reg>kategoryzacja_model.bin
     */
    @TaskAction
    fun wytrenujModel(){

        val pPlikiRegul=Files.list(katalogRegul).filter { path -> path.toString().endsWith(".reg") }

        for(p:Path in pPlikiRegul){

            println("====="+p.fileName.toString())

            when(p.fileName.toString().split("_").get(0)){
                "encje"->TrenerModeluRozpoznawaniaEncjiNLP.generujModel(p,podajPlikWyjsciowyModelu(p.fileName.toString()))
                "kategoryzacja"->TrenerModeluKategoryzacjiNLP.generujModel(p,podajPlikWyjsciowyModelu(p.fileName.toString()))
                else -> IllegalArgumentException("Nierozpoznany typ pliku regul [encje,kategoryzacja]")
            }
        }
    }

    private fun podajPlikWyjsciowyModelu(aNazwaPlikuRegul:String):Path{
        return katalogModeluOUT.resolve(aNazwaPlikuRegul.replace(".reg",".bin").replace("probka_uczaca","model"))
    }

}