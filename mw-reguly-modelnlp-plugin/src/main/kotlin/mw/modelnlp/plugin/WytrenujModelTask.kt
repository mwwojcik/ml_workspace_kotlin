package mw.modelnlp.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class WytrenujModelTask(): DefaultTask() {

    var komunikat:String=""

    var plikRegul:

    @TaskAction
    fun wyswietl(){
        println(komunikat)
    }

}