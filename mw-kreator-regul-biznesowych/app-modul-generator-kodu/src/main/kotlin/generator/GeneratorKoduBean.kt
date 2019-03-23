package generator

import com.squareup.kotlinpoet.*
import model.RegulaBiznesowa
import model.wyrazenia.WyrazenieWarunkowe
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.nio.file.Paths

@Component
open class GeneratorKoduBean {

    fun budujMetodeWyswietlKomunikat(): FunSpec {
        return FunSpec.builder("wyswietlKomunikat")
                .addStatement("println(%P)", "\$komunikat")
                .addParameter("komunikat", String::class)
                .build()
    }

    fun budujInstrukcjeWarunkowa(aInstrukcjaWarunkowa:WyrazenieWarunkowe):CodeBlock{
         val ifElseSpec=CodeBlock.builder()
                .beginControlFlow("if("+aInstrukcjaWarunkowa.warunek+")")
                .addStatement(aInstrukcjaWarunkowa.akcjaTak.podajAkcje())
                .endControlFlow()

        if(aInstrukcjaWarunkowa.akcjaNie!=null){
            ifElseSpec.beginControlFlow("else")
                    .addStatement(aInstrukcjaWarunkowa?.akcjaNie?.podajAkcje()?:"")
                    .endControlFlow()
        }


        return ifElseSpec.build()

    }

    fun budujMetodeDlaReguly(aRegula:RegulaBiznesowa):FunSpec{
        val funBuilder=FunSpec.builder(aRegula.nazwa)


        funBuilder.addKdoc(CodeBlock.builder().add(aRegula.regulaSurowa).build())

        for (p in aRegula.parametry){
            funBuilder.addParameter(p.nazwa,p.podajTypClass())

        }
        funBuilder.addCode(budujInstrukcjeWarunkowa(aRegula.instrukcjaWarunkowa))
        return funBuilder.build();
    }


    fun generujKod(aReguly: List<RegulaBiznesowa>) {
        println("** Generowanie kodu")
        val fileBuilder = FileSpec.builder("", "WalidatorRegulBiznesowych")

        fileBuilder.addFunction(
            budujMetodeWyswietlKomunikat()
        )

        for (r in aReguly) {
            fileBuilder.addFunction(budujMetodeDlaReguly(r))
        }

        fileBuilder.build().writeTo(Paths.get("H:\\mw-git\\kreator-regul-biznesowych\\aplikacja-modul\\src\\main\\kotlin\\app"))


        println("... ok **")
    }
}


/*val greeterClass = ClassName("", "Greeter")
       val file = FileSpec.builder("", "HelloWorld")
               .addType(TypeSpec.classBuilder("Greeter")
                       .primaryConstructor(FunSpec.constructorBuilder()
                               .addParameter("name", String::class)
                               .build())
                       .addProperty(PropertySpec.builder("name", String::class)
                               .initializer("name")
                               .build())
                       .addFunction(FunSpec.builder("greet")
                               .addStatement("println(%P)", "Hello, \$name")
                               .build())
                       .build())
               .addFunction(FunSpec.builder("main")
                       .addParameter("args", String::class, KModifier.VARARG)
                       .addStatement("%T(args[0]).greet()", greeterClass)
                       .build())
               .build()

       file.writeTo(System.out)


       val myFile=FileSpec.builder("","RegulyBiznesowe").addFunction(
               FunSpec.builder("sprawdzDaty").build()
       ).build()

       myFile.writeTo(System.out)*/