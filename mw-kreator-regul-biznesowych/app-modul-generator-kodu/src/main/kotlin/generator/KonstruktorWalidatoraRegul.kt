package generator

import com.squareup.kotlinpoet.*
import model.ast.AkcjaAST
import model.ast.RegulaAST
import model.ast.WyrazenieLogiczneAST
import model.ast.WyrazenieWarunkoweAST
import model.dto.Parametr
import model.dto.Regula
import model.dto.WywolanieReguly
import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.reflect.KClass

object KonstruktorWalidatoraRegul {
    private lateinit var ast: RegulaAST
    private lateinit var regula: Regula
    private val fileBuilder = FileSpec.builder("", "walidator_regul_gen")


    private fun budujTypyZwracane() {
        val typBazowyBuilder = TypeSpec.classBuilder("WynikDzialaniaReguly")
        val zwrocKomunikat = TypeSpec.classBuilder("Komunikat").superclass(ClassName("generator", "WynikDzialaniaReguly"))
        val bladWalidacji = TypeSpec.classBuilder("BladWalidacji").superclass(ClassName("generator", "WynikDzialaniaReguly"))

        fileBuilder.addType(typBazowyBuilder.build())
        fileBuilder.addType(zwrocKomunikat.build())
        fileBuilder.addType(bladWalidacji.build())
    }

    fun dajAkcje(akcja: AkcjaAST,aWywolaniaRegul: MutableList<WywolanieReguly>): String =
            when (akcja.akcja) {
                "SPRAWDZ_REGULE" -> "return " + dajAkcjeWywolaniaReguly(akcja,aWywolaniaRegul)
                "ZGLOS_BLAD" -> "return BladWalidacji(" + akcja.parametr + ")"
                "WYSWIETL_KOMUNIKAT" -> "return Komunikat(" + akcja.parametr + ")"
                else -> throw IllegalArgumentException("Nieznana akcja")
            }


    fun dajBuilderaParametruMetody(aParam: Parametr): ParameterSpec.Builder {
        val pParamBuilder = ParameterSpec.builder(aParam.nazwa.trim(), podajTypClass(aParam.typ!!))

        if (!aParam.wartoscDomyslna.isNullOrEmpty()) {
            aParam?.wartoscDomyslna?.let {

                if (aParam.typ == "Data") {
                    pParamBuilder.defaultValue(CodeBlock.of("LocalDate.parse(" + it!!.replace("'", "\"") + ")"))
                } else {
                    pParamBuilder.defaultValue(it!!)
                }
            }
        }
        return pParamBuilder
    }

    fun dajBuilderaParametruMetodyDlaKomunikatu(aNazwa: String, aWartosc: String): ParameterSpec.Builder {
        val pParamBuilder = ParameterSpec.builder(aNazwa.trim(), String::class.java)
        pParamBuilder.defaultValue("\"" + aWartosc + "\"")
        return pParamBuilder
    }

    fun dajWarunki(aWarunekGlowny: WyrazenieWarunkoweAST, aWyrazeniaLogiczne: List<WyrazenieLogiczneAST>?, aParametry: List<Parametr>): String {
        if (aWyrazeniaLogiczne == null) {
            return warunekNaStr(aWarunekGlowny, aParametry)
        } else {
            return warunekNaStr(aWarunekGlowny, aParametry) + warunkiLogiczneNaStr(aWyrazeniaLogiczne, aParametry)
        }
    }


    fun budujInstrukcjeWarunkowa(aRegulaAST: RegulaAST, aRegula: Regula): CodeBlock.Builder {
        val ifElseSpec = CodeBlock.builder()
                .beginControlFlow("if(" + dajWarunki(aRegulaAST.warunek, aRegulaAST.warunkiLogiczne, aRegula.parametry.toList()) + ")")
                .addStatement(dajAkcje(aRegulaAST.akcjaTAK,aRegula.wywolaniaRegul))
                .endControlFlow()

        aRegulaAST.akcjaNie?.let {
            ifElseSpec.beginControlFlow("else")
                    .addStatement(dajAkcje(aRegulaAST.akcjaNie!!,aRegula.wywolaniaRegul)).endControlFlow()
        }

        return ifElseSpec
    }


    fun dajBuilderaMetody(aRegulaAST: RegulaAST, aRegula: Regula): FunSpec.Builder {

        val funBuilder = FunSpec.builder(aRegula.kod.toLowerCase().replace("-", "_")).returns(ClassName("generator", "WynikDzialaniaReguly"))

        funBuilder.addKdoc(CodeBlock.builder().add(aRegula.tresc).build())

        for (p in aRegula.parametry) {
            funBuilder.addParameter(dajBuilderaParametruMetody(p).build())
        }

        for ((k, v) in aRegula.sekwencja.komunikaty.orEmpty()) {
            funBuilder.addParameter(dajBuilderaParametruMetodyDlaKomunikatu(k, v).build())
        }

        funBuilder.addCode(budujInstrukcjeWarunkowa(aRegulaAST, aRegula).build())

        return funBuilder
    }

    fun buduj(aReguly: MutableList<Pair<RegulaAST, Regula>>): String {

        budujTypyZwracane()

        for (pReg in aReguly) {
            fileBuilder.addFunction(dajBuilderaMetody(pReg.first, pReg.second).build())
        }

        zapiszDoPliku()
        return fileBuilder.build().toString()
    }

    private fun zapiszDoPliku() {
        fileBuilder.build().writeTo(Paths.get("out"))
    }
}

fun podajTypClass(aTyp: String): KClass<*> {

    when (aTyp) {
        "Napis" -> return String::class
        "Liczba" -> return Int::class
        "Data" -> return LocalDate::class
        else -> throw IllegalArgumentException("Nierozpoznany typ!")
    }

    return String::class
}


fun warunkiLogiczneNaStr(aWyrazenia: List<WyrazenieLogiczneAST>, aParametry: List<Parametr>): String {
    return aWyrazenia.map { " " + it.operatorLogiczny + " " + warunekNaStr(it.operandPrawy, aParametry) }.joinToString(separator = "")
}

fun warunekNaStr(aWarunek: WyrazenieWarunkoweAST, aParametry: List<Parametr>): String {
    return aWarunek.operandLewy + aWarunek.operatorWarunku + mapujWartoscDomyslnaNaNazweParametru(aWarunek.operandPrawy, aParametry)
}

fun mapujWartoscDomyslnaNaNazweParametru(aWartosc: String, aParametry: List<Parametr>): String {
    val pMapa: Map<String, String> = aParametry.filter { it.wartoscDomyslna != null }.map { it.wartoscDomyslna!! to it.nazwa!! }.toMap()
    return if (pMapa.containsKey(aWartosc)) pMapa[aWartosc]!! else aWartosc
}

fun dajAkcjeWywolaniaReguly(akcja: AkcjaAST,aWywolaniaRegul: MutableList<WywolanieReguly>):String{

    val pKlucz= normalizujNazweReguly(akcja.parametr)

    val pMapa: Map<String, WywolanieReguly> = aWywolaniaRegul
            .map { normalizujNazweReguly(it.kodRegulyWolanej) to it}.toMap()

    val parametry=pMapa[pKlucz]!!.parametry.map{it.nazwaParametruRegulyWolanej+"="+it.nazwaParametruRegulyWolajacej}.joinToString()

    return akcja.akcja+"("+parametry+")"
}

fun normalizujNazweReguly(aStr:String)=aStr.replace("-","_").toLowerCase().trim()