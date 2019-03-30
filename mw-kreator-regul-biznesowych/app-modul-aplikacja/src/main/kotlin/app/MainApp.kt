package app

import javafx.application.Application
import javafx.stage.Stage
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.boot.SpringApplication
import javafx.scene.Scene
import org.springframework.transaction.annotation.EnableTransactionManagement


@SpringBootApplication
@ComponentScan(basePackages = arrayOf("app","reguly","generator","reguly","db","uslugi"))
@EnableJpaRepositories(basePackages = arrayOf("db"))
@EntityScan( basePackages = arrayOf("model","encje","model.encje"))
@EnableTransactionManagement
open class MyApp: Application() {

    lateinit var springContext: ConfigurableApplicationContext
    lateinit var rootNode: Parent
    lateinit var fxmlLoader: FXMLLoader

    override fun start(primaryStage: Stage?) {
        fxmlLoader.location = javaClass.getResource("/fxml/main.fxml")
        rootNode = fxmlLoader.load()

        primaryStage!!.title="Hello World"
        val scene = Scene(rootNode, 750.0, 800.0)
        scene.stylesheets.add(javaClass.getResource("/css/main.css").toExternalForm())
        primaryStage.isAlwaysOnTop=false
        primaryStage.isResizable=false
        primaryStage.setScene(scene)

        KontekstAplikacji.mainStage=primaryStage

        primaryStage.show()
    }

    override fun stop() {
        super.stop()
        springContext.stop()
    }

    override fun init() {
        super.init()
        springContext = SpringApplication.run(MyApp::class.java)
        fxmlLoader = FXMLLoader()
        //fxmlLoader.setControllerFactory(springContext::getBean)
        fxmlLoader.setControllerFactory {springContext.getBean(it)}
    }

    /*
      companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Test::class.java)
        }
    }
    * */
}

fun main(args: Array<String>) {
    Application.launch(MyApp::class.java, *args)
}

/*
https://better-coding.com/javafx-spring-boot-gradle-trzech-bohaterow-na-jednej-scenie/
* */