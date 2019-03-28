package app.jfx

import javafx.fxml.FXML
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean


@Controller
class MainController {

    @Autowired
    lateinit var reguly: RegulyUslugaBean

    @FXML
    lateinit var panelRegul: VBox

    @FXML
    private fun initialize() {

        panelRegul.spacing = 50.0

        for (reg in reguly.podajReguly()) {

            //kontenerek na regule
            var pKontener: VBox = VBox()
            pKontener.spacing=5.0

            panelRegul.children.add(pKontener)
            pKontener.prefWidth=800.0

            val wartoscNazwaParametry= mutableListOf<WrapperParametruNazwaWartosc>(WrapperParametruNazwaWartosc("Kod",reg.nazwa), WrapperParametruNazwaWartosc("Treść",reg.tresc))
            wartoscNazwaParametry.add(WrapperParametruNazwaWartosc("",""))
            for(sek in reg.sekwencja!!.rozpoznaneTokeny){
                wartoscNazwaParametry.add(WrapperParametruNazwaWartosc(sek.wartosc,sek.typ.toString()))
            }

            pKontener.children.add(zbudujTabelkeProstychWlasnosciKluczWartosc(wartoscNazwaParametry,szerokoscKolumnyN = 80.0,szerokoscKolumnyW = 520.0,wysokoscTabeli = 200.0))



          /*  val pKodReguly=Label(reg.nazwa)
            pKodReguly.style="-fx-font-weight: bold;-fx-font-size:14px;"
            pKontener.children.add(pKodReguly)

            val ta=TextArea(reg.tresc)
            ta.appendText("\n")
            ta.appendText(reg.sekwencja?.drukujDoStr())
            //ta.prefWidth=600.0
            ta.prefHeight=150.0
            ta.prefWidth=pKontener.prefWidth

            pKontener.children.add(ta)*/
            var pKontenerPionowy:HBox=HBox()
            pKontenerPionowy.prefWidth(800.0)
            pKontenerPionowy.children.add(zbudujTabelkeParametrowWejsciowych(reg.parametry,wysokoscTabeli = 150.0))
            pKontenerPionowy.children.add(zbudujTabelkeParametrowWejsciowych(reg.parametry,wysokoscTabeli = 150.0))
            pKontener.children.add(pKontenerPionowy)

        }
    }




    @FXML
    fun onWczytajRegulyKLIK() {
        println("onWczytajRegulyKLIK")

    }

    @FXML
    fun onWalidujRegulyKLIK() {
        println("onWalidujRegulyKLIK")

    }

    @FXML
    fun onZapiszRegulyKLIK() {
        println("onZapiszRegulyKLIK")

    }

    @FXML
    fun onGenerujKodKLIK() {
        println("onGenerujKodKLIK")

    }
}

