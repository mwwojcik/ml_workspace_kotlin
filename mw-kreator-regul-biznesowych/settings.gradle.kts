rootProject.name = "kreator-regul-biznesowych"


include ("app-modul-aplikacja","app-modul-aplikacja")
include ("app-modul-silnik-regul","app-modul-silnik-regul")
include ("app-modul-generator-kodu","app-modul-generator-kodu")
include ("app-modul-model","app-modul-model")
include ("app-modul-db","app-modul-db")

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}