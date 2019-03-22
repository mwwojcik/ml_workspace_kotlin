import mw.modelnlp.plugin.WytrenujModelTask

buildscript {


    dependencies {
        classpath("mw.modelnlp.plugin:modelnlp-plugin:1.0")
    }


}

repositories {
    mavenLocal()
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.3.10"
    id("mw.modelnlp.plugin") version "1.0"
}


tasks.getByName<DefaultTask>("wytrenujModel") {
   
}
