package app

import db.encje.RegulyDbBean
import generator.GeneratorKoduBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import reguly.antlr.KompilatorRegulBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.runApplication
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component


//@SpringBootApplication(scanBasePackages = arrayOf("reguly","generator"))
@Configuration
@ComponentScan(basePackages = arrayOf("app","reguly","generator","reguly","db","db.encje"))
@SpringBootApplication
open class KompilatorRegulMainApp{

}


fun main(args: Array<String>) {


    /*val ctx = AnnotationConfigApplicationContext()
            ctx.register(KompilatorRegulMainApp::class.java)
    ctx.refresh()
    val kompilatorBean = ctx.getBean(KompilatorRegulBean::class.java)

    val generatorKoduBean=ctx.getBean(GeneratorKoduBean::class.java)

    val testowy = ctx.getBean(Testowy::class.java)
    //generatorKoduBean.generujKod(kompilatorBean.kompilujRegulyBiznesowe())

    println(testowy.hello)
*/
    val ctx=runApplication<KompilatorRegulMainApp>(*args)

    val bean=ctx.getBean(KompilatorRegulMainApp::class.java)

    val kompilatorBean = ctx.getBean(KompilatorRegulBean::class.java)
    val generatorKoduBean=ctx.getBean(GeneratorKoduBean::class.java)

    val regDAO:RegulyDbBean=ctx.getBean(RegulyDbBean::class.java)
    regDAO.znajdzWszystkieReguly()
}
