package model

import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.util.*
import kotlin.reflect.KClass

data class Parametr(val nazwa:String,val typ:String){

    fun podajTypClass(): KClass<*> {

        when(typ){
            "String"->return String::class
            "Int"->return Int::class
            "LocalDate"->return LocalDate::class
            else->throw IllegalArgumentException("Nierozpoznany typ!")
        }

        return String::class
    }
}