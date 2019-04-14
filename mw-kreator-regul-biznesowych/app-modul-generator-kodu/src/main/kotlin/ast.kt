import model.ast.AkcjaAST
import model.ast.RegulaAST
import model.ast.WyrazenieLogiczneAST
import model.ast.WyrazenieWarukoweAST
import model.nlp.RozpoznanyToken

interface IBudowniczyAST<T> {
    fun buduj(): T

    fun inicjuj(tokeny: List<RozpoznanyToken>)
}

object BudowniczyRegulyAST : IBudowniczyAST<RegulaAST> {

    override fun buduj(): RegulaAST {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun inicjuj(tokeny: List<RozpoznanyToken>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


object BudowniczyWyrazeniaWarunkowegoAST : IBudowniczyAST<WyrazenieWarukoweAST> {
    override fun buduj(): WyrazenieWarukoweAST {
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
}