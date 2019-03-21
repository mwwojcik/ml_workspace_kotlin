import mw.modelnlp.plugin.GreetingToFileTask

buildscript{



    dependencies{
        classpath ("mw.modelnlp.plugin:modelnlp-plugin:1.0")
    }


}

repositories{
    mavenLocal()
    mavenCentral()
}

plugins{
    kotlin("jvm") version  "1.3.10"
    id("mw.modelnlp.plugin") version "1.0"

}

/*



tasks.register<GreetingToFileTask>("greet") {
    destination = { project.extra["greetingFile"]!! }
}

tasks.register("sayGreeting") {
    dependsOn("greet")
    doLast {
        println(file(project.extra["greetingFile"]!!).readText())
    }
}

extra["greetingFile"] = "$buildDir/hello.txt"*/
