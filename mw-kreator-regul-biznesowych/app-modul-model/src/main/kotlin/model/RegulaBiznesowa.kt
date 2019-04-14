package model

import model.antlr.wyrazenia.WyrazenieWarunkowe

 class RegulaBiznesowa {
    val parametry = mutableListOf<Parametr>()
    lateinit var nazwa: String
    lateinit var instrukcjaWarunkowa: WyrazenieWarunkowe
    lateinit var regulaSurowa: String
}