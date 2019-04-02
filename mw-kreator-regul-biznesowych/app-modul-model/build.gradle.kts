import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments
import kotlin.collections.mutableListOf as mutablelist

buildscript{
    plugins{
        id ("org.jetbrains.kotlin.plugin.spring")version "1.3.21" //nastepca all-open
        id ("org.jetbrains.kotlin.plugin.noarg" )version "1.3.21"
    }
}

plugins{
    kotlin("jvm") version  "1.3.10"
    id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.21"
    id ("org.jetbrains.kotlin.plugin.jpa") version "1.3.21"
    java
}


java{
    sourceCompatibility =JavaVersion.VERSION_1_8
}

dependencies {
    compile("com.massisframework:j-text-utils:0.3.4")
    compile(kotlin("stdlib-jdk8"))
    testCompile ("junit:junit:4.12")
    testCompile ("org.jetbrains.kotlin:kotlin-test")
    testCompile ("org.jetbrains.kotlin:kotlin-test-junit")
    implementation(group="org.springframework.boot",name="spring-boot-starter",version="2.1.3.RELEASE")
    implementation(group="org.springframework.boot",name="spring-boot-starter-data-jpa",version="2.1.3.RELEASE")
  
}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}











