import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript{
    plugins{
        id ("org.jetbrains.kotlin.plugin.spring")version "1.3.21" //nastepca all-open
    }
}

plugins {
    kotlin("jvm") version "1.3.10"
    //application
    //poniewaz chcemy tworzyc aplikacje w tym module
    //to otrzymany od parenta dostep do plugina io.spring.dependency-management
    //jest za malo. Dodaje plugin odpowiedzialny za tworzenie aplikacji, opakowanie jej w jara
    //dodaje nowe taski np. bootJar
    id("org.springframework.boot") version "2.1.3.RELEASE"
    //id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    //id("io.spring.dependency-management")
}


dependencies {
    compile ("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")
    implementation(group="org.springframework.boot",name="spring-boot-starter-web",version="2.1.3.RELEASE")
    compile(kotlin("stdlib-jdk8"))
    compile(project(":app-modul-uslugi"))
    testCompile("junit:junit:4.12")
    testCompile("org.jetbrains.kotlin:kotlin-test")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
    runtimeOnly("org.hsqldb:hsqldb:2.4.0")
    implementation(group="org.springframework.boot",name="spring-boot-starter-data-jpa",version="2.1.3.RELEASE")
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions.jvmTarget = "1.8"
}