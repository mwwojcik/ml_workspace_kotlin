import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments
import kotlin.collections.mutableListOf as mutablelist

buildscript{
    plugins{
        id ("org.jetbrains.kotlin.plugin.spring")version "1.3.21" //nastepca all-open
    }
}


plugins{
    kotlin("jvm") version  "1.3.10"
}


java{
    sourceCompatibility =JavaVersion.VERSION_1_8
}

dependencies {
    implementation(group="org.springframework.boot",name="spring-boot-starter",version="2.1.3.RELEASE")
    implementation(group="org.springframework.boot",name="spring-boot-starter-data-jpa",version="2.1.3.RELEASE")
    compile(project(":app-modul-model"))
    compile(project(":app-modul-db"))
    compile(project(":app-modul-silnik-regul"))
    compile(project(":app-modul-generator-kodu"))
    compile(kotlin("stdlib-jdk8"))
    compile("com.squareup:kotlinpoet:1.0.1")
    testCompile ("junit:junit:4.12")
    testCompile ("org.jetbrains.kotlin:kotlin-test")
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit")
   //antlr("org.antlr:antlr4:4.7.2")

}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}










