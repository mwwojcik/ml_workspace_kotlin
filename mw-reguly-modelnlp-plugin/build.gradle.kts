/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm").version("1.3.21")
    id("maven-publish")
    `java-gradle-plugin`


}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
    mavenLocal()
}

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    compile("mw.reguly.modelnlp:modelnlp:1.0")

}


gradlePlugin {
    plugins {
        create("model") {
            id = "mw.modelnlp.plugin"
            implementationClass = "mw.modelnlp.plugin.ModelNLPPlugin"
            version = "1.0"
        }
    }
}

publishing {
    publications {
       create<MavenPublication>("pluginMaven") {
            groupId = "mw.modelnlp.plugin"
            artifactId = "modelnlp-plugin"
            version = "1.0"
        }

    }
}

