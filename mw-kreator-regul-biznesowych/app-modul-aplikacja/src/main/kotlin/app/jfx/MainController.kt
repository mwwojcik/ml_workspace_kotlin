package app.jfx

import javafx.fxml.FXML
import javafx.scene.control.TableView
import javafx.scene.control.TitledPane
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

    val listaTabelParametrow:MutableList<TitledPane> = mutableListOf<TitledPane>()

    @FXML
    private fun initialize() {

        panelRegul.spacing = 50.0

        for (reg in reguly.podajReguly()) {

            val wartoscNazwaParametry= mutableListOf<WrapperParametruNazwaWartosc>(WrapperParametruNazwaWartosc("Treść",reg.tresc))
            wartoscNazwaParametry.add(WrapperParametruNazwaWartosc("",""))
            for(sek in reg.sekwencja!!.rozpoznaneTokeny){
                wartoscNazwaParametry.add(WrapperParametruNazwaWartosc(sek.wartosc,sek.typ.toString()))
            }


            //kontenerek na regule
            var pKontenerNaTabelki: VBox = VBox()
            var pKontenerTytylowy=TitledPane(reg.kod,pKontenerNaTabelki)
            panelRegul.children.add(pKontenerTytylowy)


            pKontenerNaTabelki.spacing=5.0
            pKontenerNaTabelki.prefWidth=800.0

            //PIERWSZY WIERSZ
            pKontenerNaTabelki.children.add(zbudujTabelkeProstychWlasnosciKluczWartosc(wartoscNazwaParametry
                    ,szerokoscKolumnyN = 80.0
                    ,szerokoscKolumnyW = 520.0
                    ,szerokoscTabeli = 700.0))

            //BUDUJE DRUGI WIERSZ - PODZIAL NA DWA OBSZARY PIONOWE
            var pKontenerPionowyNaTabelkiParametrow=HBox()
            pKontenerPionowyNaTabelkiParametrow.prefWidth=800.0
            pKontenerPionowyNaTabelkiParametrow.spacing=15.0

            val pParametryTab=zbudujTabelkeParametrowWejsciowych(reg.parametry!!
                    ,szerokoscTabeli = 340.0
                    ,szerokoscKolumnyN = 100.0
                    ,szerokoscKolumnyT = 100.0
                    ,szerokoscKolumnyW = 120.0)

            var pKontenerParametrowWe=TitledPane("Parametry WE", pParametryTab)
            var pKontenerParametrowWy=TitledPane("Parametry WY", zbudujTabelkeParametrowWejsciowych(reg.parametry!!
                    ,szerokoscTabeli = 340.0
                    ,szerokoscKolumnyN = 100.0
                    ,szerokoscKolumnyT = 100.0
                    ,szerokoscKolumnyW = 120.0))

            pKontenerParametrowWe.isExpanded=false
            pKontenerParametrowWy.isExpanded=false

            listaTabelParametrow.add(pKontenerParametrowWe)

            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWe)
            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWy)

            //DRUGI WIERSZ
            pKontenerNaTabelki.children.add(pKontenerPionowyNaTabelkiParametrow)


        }
    }




    @FXML
    fun onWczytajRegulyKLIK() {
        println("onWczytajRegulyKLIK")

    }

    @FXML
    fun onWalidujRegulyKLIK() {
        println("onWalidujRegulyKLIK")

        //listaTabelParametrow.get(0).columns.get(0).style="-fx-border-color: red;"

        listaTabelParametrow.get(0).style="-fx-border-color: red;"
        listaTabelParametrow.get(0).isExpanded=true

    }

    @FXML
    fun onZapiszRegulyKLIK() {
        println("onZapiszRegulyKLIK")

    }

    @FXML
    fun onGenerujKodKLIK() {
        println("onGenerujKodKLIK")

    }

    @FXML
    fun onZamknijKLIK(){

        println("onZamknijKLIK")
    }
}

