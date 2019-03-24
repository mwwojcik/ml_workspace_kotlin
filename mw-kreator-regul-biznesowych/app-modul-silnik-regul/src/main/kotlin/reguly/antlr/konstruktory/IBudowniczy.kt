package reguly.antlr.konstruktory

interface IBudowniczy<T> {
    fun buduj():T

    fun inicjuj()
}