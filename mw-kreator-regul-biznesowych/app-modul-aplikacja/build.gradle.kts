import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.10"
    //application
    //poniewaz chcemy tworzyc aplikacje w tym module
    //to otrzymany od parenta dostep do plugina io.spring.dependency-management
    //jest za malo. Dodaje plugin odpowiedzialny za tworzenie aplikacji, opakowanie jej w jara
    //dodaje nowe taski np. bootJar
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    //id("io.spring.dependency-management")
}

/*
application{
    mainClassName = "demo.MainKt"
}
*/

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:2.1.3.RELEASE")
    compile(kotlin("stdlib-jdk8"))
    compile(project(":app-modul-model"))
    compile(project(":app-modul-silnik-regul"))
    compile(project(":app-modul-generator-kodu"))
    testCompile("junit:junit:4.12")
    testCompile("org.jetbrains.kotlin:kotlin-test")
    testCompile("org.jetbrains.kotlin:kotlin-test-junit")
}

val compileKotlin by tasks.getting(KotlinCompile::class) {
    kotlinOptions.jvmTarget = "1.8"
}