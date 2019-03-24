package reguly.antlr

import reguly.antlr.analizator.PreprocesorKoduRegulBean
import reguly.antlr.analizator.WizytorDlaGrupyRegulBiznesowych
import model.RegulaBiznesowa
import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import reguly.antlr.*
import reguly.antlr.gen.RegulyBiznesoweLexer
import reguly.antlr.gen.RegulyBiznesoweParser
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths

@Component
open  class KompilatorRegulBean{

    @Autowired
    lateinit var preprocesor: PreprocesorKoduRegulBean

    fun kompilujRegulyBiznesowe():List<RegulaBiznesowa>{
        print("** Kompilacja reguł biznesowych")

        /*val inputFile = FileInputStream(File("wejscie/reguly.txt"));
        val  reader: InputStreamReader = InputStreamReader(inputFile);
        val input = ANTLRInputStream(reader)*/
        val regulyStr= String(Files.readAllBytes(Paths.get("wejscie/reguly.txt")), Charset.forName("UTF-8"))
        val lexer = RegulyBiznesoweLexer(CharStreams.fromString(preprocesor.przetwarzajKodRegul(regulyStr)))
        val tokens = CommonTokenStream(lexer)
        val parser = RegulyBiznesoweParser(tokens)

        val visitor= WizytorDlaGrupyRegulBiznesowych()
        visitor.visit(parser.grupa_regul())
        println(visitor.reguly)

        println ("... ok **")
        return visitor.reguly
        /*val visitor=WizytorDlaGrupyRegulBiznesowychJava()
        visitor.visit(parser.grupa_regul())*/

    }

}