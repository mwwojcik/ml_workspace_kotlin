package generator

import com.squareup.kotlinpoet.*
import model.ast.RegulaAST
import model.dto.Parametr
import model.dto.Regula
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
        val zwrocKomunikat = TypeSpec.classBuilder("Komunikat").superclass(ClassName("generator","WynikDzialaniaReguly"))
        val bladWalidacji = TypeSpec.classBuilder("BladWalidacji").superclass(ClassName("generator","WynikDzialaniaReguly"))

        fileBuilder.addType(typBazowyBuilder.build())
        fileBuilder.addType(zwrocKomunikat.build())
        fileBuilder.addType(bladWalidacji.build())
    }

    fun dajBuilderaParametruMetody(aParam:Parametr):ParameterSpec.Builder{
        val pParamBuilder=ParameterSpec.builder(aParam.nazwa.trim(), podajTypClass(aParam.typ!!))

        if(!aParam.wartoscDomyslna.isNullOrEmpty()) {
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

    fun dajBuilderaParametruMetodyDlaKomunikatu(aNazwa:String,aWartosc:String):ParameterSpec.Builder{
        val pParamBuilder=ParameterSpec.builder(aNazwa.trim(), String::class.java)
        pParamBuilder.defaultValue("\""+aWartosc+"\"")
        return pParamBuilder
    }

    fun dajBuilderaMetody(aRegula:Regula):FunSpec.Builder{
      val funBuilder=FunSpec.builder(aRegula.kod.toLowerCase().replace("-","_")).returns(ClassName("generator","WynikDzialaniaReguly"))


        funBuilder.addKdoc(CodeBlock.builder().add(aRegula.tresc).build())

        for (p in aRegula.parametry){
            funBuilder.addParameter(dajBuilderaParametruMetody(p).build())

        }

        if(aRegula.sekwencja.komunikaty!=null) {
            for ((k, v) in aRegula.sekwencja.komunikaty!!){
                funBuilder.addParameter(dajBuilderaParametruMetodyDlaKomunikatu(k,v).build())
            }
        }

        return funBuilder
    }

    fun buduj(aReguly: MutableList<Pair<RegulaAST, Regula>>): String {
        budujTypyZwracane()

        for(pReg in aReguly){
            fileBuilder.addFunction(dajBuilderaMetody(pReg.second).build())
        }

        zapiszDoPliku()
        return fileBuilder.build().toString()
    }

    private fun zapiszDoPliku() {
        fileBuilder.build().writeTo(Paths.get("out"))
    }


}


fun podajTypClass(aTyp:String): KClass<*> {

    when(aTyp){
        "Napis"->return String::class
        "Liczba"->return Int::class
        "Data"->return LocalDate::class
        else->throw IllegalArgumentException("Nierozpoznany typ!")
    }

    return String::class
}