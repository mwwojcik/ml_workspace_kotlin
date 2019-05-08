package webapp


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.boot.SpringApplication
import org.springframework.transaction.annotation.EnableTransactionManagement


@SpringBootApplication
@ComponentScan(basePackages = arrayOf("app","reguly","generator","reguly","db","uslugi"))
@EnableJpaRepositories(basePackages = arrayOf("db"))
@EntityScan( basePackages = arrayOf("model","encje","model.encje"))
@EnableTransactionManagement
open class MyWebApp

fun main(args: Array<String>) {
    SpringApplication.run(MyWebApp::class.java, *args)
}
