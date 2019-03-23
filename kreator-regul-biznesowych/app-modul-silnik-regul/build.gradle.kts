import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments
import kotlin.collections.mutableListOf as mutablelist

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
    compile(project(":app-modul-model"))
 
    compile(kotlin("stdlib-jdk8"))
    testCompile ("junit:junit:4.12")
    testCompile ("org.jetbrains.kotlin:kotlin-test")
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit")
    antlr("org.antlr:antlr4:4.7.2")

}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}



val generateGrammarSource by tasks.getting(AntlrTask::class) {
    outputDirectory=File("src/main/java/reguly/antlr")
    arguments=mutablelist("-visitor")
}







