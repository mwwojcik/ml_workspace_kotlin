package app.jfx

import app.KontekstAplikacji
import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.control.TableView
import javafx.scene.control.TitledPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import model.encje.RegulaEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean


@Controller
class MainController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    lateinit var listaRegul:List<RegulaEncja>




    @FXML
    lateinit var panelRegul: VBox

    //val listaTabelParametrow:MutableList<TitledPane> = mutableListOf<TitledPane>()
    val mapaKonenerowBledowWalidacji:MutableMap<String,KontenerBledow> = mutableMapOf<String,KontenerBledow>()
    val mapaKonenerowParametrowWe:MutableMap<String,TitledPane> = mutableMapOf<String,TitledPane>()
    val mapaKonenerowParametrowWy:MutableMap<String,TitledPane> = mutableMapOf<String,TitledPane>()


    @FXML
    private fun initialize() {

        panelRegul.spacing = 50.0

        listaRegul=regulyUsluga.podajReguly()

        for (reg in listaRegul) {

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

            mapaKonenerowParametrowWe.put(reg.kod,pKontenerParametrowWe)
            mapaKonenerowParametrowWy.put(reg.kod,pKontenerParametrowWy)

            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWe)
            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWy)

            //DRUGI WIERSZ
            pKontenerNaTabelki.children.add(pKontenerPionowyNaTabelkiParametrow)

            //Trzeci wiersz - panel błędów
            val pPanelBledow= zbudujKontenerBledow(700.0)
            pKontenerNaTabelki.children.add(pPanelBledow)
            mapaKonenerowBledowWalidacji.put(reg.kod,pPanelBledow)
        }
    }


    fun wyczyscKonteneryBledow(){
        mapaKonenerowBledowWalidacji.forEach{
            String,kontener -> kontener.wyczyscBledy()
        }

        mapaKonenerowParametrowWe.forEach{
            String,kontener ->
                kontener.isExpanded = false
                kontener.style = "-fx-border:none;"

        }
    }



    @FXML
    fun onWczytajRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onWczytajRegulyKLIK")

    }

    @FXML
    fun onWalidujRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onWalidujRegulyKLIK")

        listaRegul.forEach{

            val bledy=it.waliduj()

            if(!bledy.isEmpty()) {
                mapaKonenerowBledowWalidacji[it.kod]!!.dodajBledy(bledy)
                mapaKonenerowParametrowWe[it.kod]!!.isExpanded = true
                mapaKonenerowParametrowWe[it.kod]!!.style = "-fx-border-color: red;"

                /*mapaKonenerowParametrowWy[it.kod]!!.isExpanded = true
                mapaKonenerowParametrowWy[it.kod]!!.style = "-fx-border-color: red;"*/
            }
        }

    }

    @FXML
    fun onZapiszRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onZapiszRegulyKLIK")
        regulyUsluga.zapiszReguly(listaRegul)

    }

    @FXML
    fun onGenerujKodKLIK() {
        wyczyscKonteneryBledow()
        println("onGenerujKodKLIK")

    }

    @FXML
    fun onZamknijKLIK(){
        wyczyscKonteneryBledow()
        println("onZamknijKLIK")

        KontekstAplikacji.mainStage!!.close()

    }
}

