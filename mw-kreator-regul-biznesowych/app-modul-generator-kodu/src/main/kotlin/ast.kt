import model.ast.AkcjaAST
import model.ast.RegulaAST
import model.ast.WyrazenieLogiczneAST
import model.ast.WyrazenieWarunkoweAST
import model.nlp.RozpoznanyToken
import model.nlp.Sekwencja

interface IBudowniczyAST<T> {
    fun buduj(): T

    fun inicjuj(aSekwencja:Sekwencja)
}

object BudowniczyRegulyAST : IBudowniczyAST<RegulaAST> {

    lateinit var sekwencja:Sekwencja

    override fun buduj(): RegulaAST {
        val reg=RegulaAST()

        return reg
    }

    override fun inicjuj(aSekwencja:Sekwencja) {
        sekwencja=aSekwencja
    }
}


/*
object BudowniczyWyrazeniaWarunkowegoAST : IBudowniczyAST<WyrazenieWarunkoweAST> {
    override fun buduj(): WyrazenieWarunkoweAST {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inicjuj(tokeny: List<RozpoznanyToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


object BudowniczyWyrazeniaLogicznegoAST : IBudowniczyAST<WyrazenieLogiczneAST> {
    override fun buduj(): WyrazenieLogiczneAST {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inicjuj(tokeny: List<RozpoznanyToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

object BudowniczyAkcjiAST : IBudowniczyAST<AkcjaAST> {
    override fun buduj(): AkcjaAST {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inicjuj(tokeny: List<RozpoznanyToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}*/
