package model.nlp

open class PostacKanonicznaZdania(val postacPierwotna:String){
    var postacKanoniczna:String

    var komunikaty: MutableMap <String,String>? = mutableMapOf()

    init{
        postacKanoniczna=postacPierwotna
    }


}
