package mw.modelnlp.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.Copy


open class ModelNLPPlugin : Plugin<Project> {


    override fun apply(project: Project) {
        project.tasks.create("wytrenujModel", WytrenujModelTask::class.java)
    }
}