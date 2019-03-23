package mw.modelnlp.plugin

import mw.reguly.modelnlp.TrenerModeluNLP
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import java.io.File
import java.nio.file.Files
import java.nio.file.Path

open class WytrenujModelTask: DefaultTask() {

    @InputDirectory
    @Optional
    var katalogRegul: Path = project.file("src/main/modelnlp/reguly").toPath()

    @InputFile
    @Optional
    var plikRegul: Path = project.file(katalogRegul.resolve("reguly_probka_uczaca.reg")).toPath()


    @OutputDirectory
    @Optional
    var katalogModelu:Path = project.file("src/main/modelnlp/bin").toPath()
    //project.file("${project.buildDir}/generated-src")

    @OutputFile
    @Optional
    var plikModelu:Path = project.file(katalogModelu.resolve("model.bin")).toPath()

    @TaskAction
    fun wytrenujModel(){
        //println(String(Files.readAllBytes(plikRegul)))
        TrenerModeluNLP.generujModel(plikRegul,plikModelu)
    }

}