import org.gradle.api.internal.initialization.ClassLoaderIds.buildScript
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
    id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.21"

}


java{
    sourceCompatibility =JavaVersion.VERSION_1_8
}

dependencies {
    implementation(group="org.springframework.boot",name="spring-boot-starter",version="2.1.3.RELEASE")
    implementation(group="org.springframework.boot",name="spring-boot-starter-data-jpa",version="2.1.3.RELEASE")
    compile(project(":app-modul-model"))
    compile(kotlin("stdlib-jdk8"))
    testCompile ("junit:junit:4.12")
    testCompile ("org.jetbrains.kotlin:kotlin-test")
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit")
    runtimeOnly("org.hsqldb:hsqldb:2.4.0")
   //antlr("org.antlr:antlr4:4.7.2")
}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}










