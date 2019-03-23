import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.resolve.calls.model.ResolvedCallArgument.DefaultArgument.arguments
import kotlin.collections.mutableListOf as mutablelist

plugins{
    kotlin("jvm") version  "1.3.10"

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

  
}

val compileKotlin by tasks.getting(KotlinCompile::class){
    kotlinOptions.jvmTarget = "1.8"
}











