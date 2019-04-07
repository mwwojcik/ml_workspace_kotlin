import mw.modelnlp.plugin.WytrenujModelTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments
import kotlin.collections.mutableListOf as mutablelist

buildscript{
    plugins{
        id ("org.jetbrains.kotlin.plugin.spring")version "1.3.21" //nastepca all-open
    }
}

repositories{
    mavenLocal()
}

plugins{
    kotlin("jvm") version  "1.3.10"
    antlr
    id("mw.modelnlp.plugin") version "1.0"
}


java{
    sourceCompatibility =JavaVersion.VERSION_1_8
}

dependencies {
    implementation(group="org.springframework.boot",name="spring-boot-starter",version="2.1.3.RELEASE")
    testCompile(group="org.springframework.boot",name="spring-boot-starter-test", version="2.1.3.RELEASE")
    compile("org.apache.opennlp:opennlp-tools:1.9.1")
    compile(project(":app-modul-model"))
 
    compile(kotlin("stdlib-jdk8"))
    testCompile ("junit:junit:4.9.0")
    testCompile ("org.jetbrains.kotlin:kotlin-test")
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit")
    antlr("org.antlr:antlr4:4.7.2")

}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}



val generateGrammarSource by tasks.getting(AntlrTask::class) {
    outputDirectory=File("src/main/java/reguly/antlr/gen")
    arguments=mutablelist("-visitor")
}


val wytrenujModel by tasks.getting(WytrenujModelTask::class){
    katalogModeluOUT= File("src/main/resources/modelnlp").toPath()
}




