package app.jfx

import db.RegulyDbBean
import javafx.fxml.FXML
import javafx.scene.web.WebView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean

@Controller
class SampleController {

    @Autowired
    lateinit var reguly: RegulyUslugaBean

    @Value("\${my.url}")
    private val myUrl: String? = null

    @FXML
    private fun initialize() {

    }

    @FXML
    fun onWyswietlRegulyAkcjaKLIK(){
        println(myUrl)
        reguly.wyswietlReguly()
    }

}