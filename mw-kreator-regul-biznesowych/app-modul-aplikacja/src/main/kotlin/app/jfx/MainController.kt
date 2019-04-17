package app.jfx

import app.KontekstAplikacji
import generator.GeneratorKoduBean
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage
import model.dto.Regula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean
import java.io.IOException
import java.net.URL
import java.util.ResourceBundle




@Controller
class MainController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    @Autowired
    lateinit var generatorKodu: GeneratorKoduBean

    //lateinit var listaRegul: List<Regula>

    lateinit var mapaRegul: MutableMap<String, Regula>

    var mapaRegulWidok:MutableMap<String,RegulaWidok> = mutableMapOf()


    @FXML
    lateinit var panelRegul: VBox

    @FXML
    lateinit var zamknijPrzycisk:Button

    //val listaTabelParametrow:MutableList<TitledPane> = mutableListOf<TitledPane>()
    /*val mapaKonenerowBledowWalidacji: MutableMap<String, KontenerBledow> = mutableMapOf<String, KontenerBledow>()
    val mapaKonenerowParametrowWe: MutableMap<String, TitledPane> = mutableMapOf<String, TitledPane>()
    val mapaKonenerowParametrowWy: MutableMap<String, TitledPane> = mutableMapOf<String, TitledPane>()*/




    @FXML
    private fun initialize() {

        panelRegul.spacing = 50.0

        mapaRegul = regulyUsluga.podajReguly()?.map { it.kod to it }?.toMap()?.toMutableMap()?: emptyMap<String,Regula>().toMutableMap()

        for (reg in mapaRegul.values) {

            var regulaWidok=RegulaWidok()
            regulaWidok.aktualizujDane(reg)
            mapaRegulWidok.put(reg.kod,regulaWidok)

            //val wartoscNazwaParametry= mutableListOf<WrapperParametruNazwaWartosc>(WrapperParametruNazwaWartosc("Treść",reg.tresc))
            val pTytul = Label(reg.tresc + "\n\n" + "-- Postać znormalizowana --" + "\n\n" + reg.sekwencja.postacKanoniczna)
            pTytul.prefWidth = 700.0
            pTytul.tooltip = Tooltip(reg.tresc)
            pTytul.isWrapText = true
            pTytul.padding = Insets(10.0)
            pTytul.setStyle("-fx-font-weight: bold")


            //kontenerek na regule
            var pKontenerNaTabelki: VBox = VBox()
            var pKontenerTytylowy = TitledPane(reg.kod, pKontenerNaTabelki)
            panelRegul.children.add(pKontenerTytylowy)


            pKontenerNaTabelki.spacing = 5.0
            pKontenerNaTabelki.prefWidth = 800.0

            pKontenerNaTabelki.children.add(pTytul)
            //wiersz zerowy - komunikaty


                pKontenerNaTabelki.children.add(zbudujTabelkeRozpoznanychKomunikatow(regulaWidok
                        , szerokoscKolumnyN = 80.0
                        , szerokoscKolumnyW = 600.0
                        , szerokoscTabeli = 700.0))


            //PIERWSZY WIERSZ
            pKontenerNaTabelki.children.add(zbudujTabelkeRozpoznanychTokenow(regulaWidok
                    , szerokoscKolumnyN = 80.0
                    , szerokoscKolumnyW = 400.0
                    , szerokoscKolumnyK = 160.0
                    , szerokoscTabeli = 700.0))


            val nazwyParametrow = reg.parametry.map {
                it.nazwa
            }.toList()

            //BUDUJE DRUGI WIERSZ - PODZIAL NA DWA OBSZARY PIONOWE
            var pKontenerPionowyNaTabelkiParametrow = HBox()
            pKontenerPionowyNaTabelkiParametrow.prefWidth = 800.0
            pKontenerPionowyNaTabelkiParametrow.spacing = 15.0

            val pParametryTab = zbudujTabelkeParametrowWejsciowych(regulaWidok
                    , szerokoscTabeli = 308.0
                    , szerokoscKolumnyN = 100.0
                    , szerokoscKolumnyT = 100.0
                    , szerokoscKolumnyW = 90.0)

            var pKontenerParametrowWe = TitledPane("Parametry WE", pParametryTab)
            var pKontenerParametrowWy = TitledPane("Parametry WY", zbudujTabelkeParametrowWyjsciowych(regulaWidok
                    , nazwyParametrow
                    , szerokoscTabeli = 308.0
                    , szerokoscKolumnyN = 100.0
                    , szerokoscKolumnyT = 100.0
                    , szerokoscKolumnyW = 90.0))

            pKontenerParametrowWe.isExpanded = true
            pKontenerParametrowWy.isExpanded = true

           /* mapaKonenerowParametrowWe.put(reg.kod, pKontenerParametrowWe)
            mapaKonenerowParametrowWy.put(reg.kod, pKontenerParametrowWy)*/

            val pKontenerPoziomyNaPrzyciski=VBox()
            pKontenerPoziomyNaPrzyciski.spacing=5.0

            val przyciskNowyParam = Button("Nowy")
            przyciskNowyParam.setOnMouseClicked {
                val pdial = TextInputDialog()
                pdial.contentText = "Nazwa"
                pdial.headerText = "Wpisz nazwę parametru"
                val nazwaOpt = pdial.showAndWait()

                if (nazwaOpt.isPresent) {
                    regulyUsluga.dodajParametr(mapaRegul[reg.kod]!!, nazwaOpt.get())
                   // mapaRegulWidok[reg.kod]!!.aktualizujDane(mapaRegul[reg.kod]!!)
                    aktualizujReguly()
                }
            }

            val przyciskUsunParam = Button("Usuń")
            przyciskUsunParam.setOnMouseClicked {
                regulyUsluga.usunParametr(mapaRegul[reg.kod]!!)
                //mapaRegulWidok[reg.kod]!!.aktualizujDane(mapaRegul[reg.kod]!!)
                aktualizujReguly()
            }
            przyciskNowyParam.prefWidth=50.0
            przyciskUsunParam.prefWidth=50.0

            pKontenerPoziomyNaPrzyciski.children.add(przyciskNowyParam)

            pKontenerPoziomyNaPrzyciski.children.add(przyciskUsunParam)
            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWe)
            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerPoziomyNaPrzyciski)
            pKontenerPionowyNaTabelkiParametrow.children.add(pKontenerParametrowWy)


            //DRUGI WIERSZ
            pKontenerNaTabelki.children.add(pKontenerPionowyNaTabelkiParametrow)


            //Trzeci wiersz - panel błędów
            val pPanelBledow = zbudujKontenerBledow(700.0)
            regulaWidok.kontenerBledow=pPanelBledow
            pKontenerNaTabelki.children.add(pPanelBledow)

        }
    }

 /*   fun aktualizujParametryWe() {
        for (reg in listaRegul) {
            (mapaKonenerowParametrowWe[reg.kod]!!.content as TableView<*>).items.clear()
            if (reg.parametry != null) {
                (mapaKonenerowParametrowWe[reg.kod]!!.content as TableView<WierszTabeliParametrowWe>).items =
                        FXCollections.observableArrayList(
                                reg.parametry!!.map {
                                    WierszTabeliParametrowWe(it.nazwa, it.typ ?: "", it.wartoscDomyslna ?: "", it)
                                }.toList())
            }
        }
    }
*/

   /* fun wyczyscKonteneryBledow() {
        mapaKonenerowBledowWalidacji.forEach { String, kontener ->
            kontener.wyczyscBledy()
        }

        mapaKonenerowParametrowWe.forEach { String, kontener ->
            kontener.style = "-fx-border:none;"

        }
    }
*/

    @FXML
    fun onWczytajRegulyKLIK() {
        println("onWczytajRegulyKLIK")
        regulyUsluga.wczytajReguly()
        aktualizujReguly()

        var i =30
        for (reg in mapaRegul.values){
           println(",PrzypadekTestowy("+i+","+"\""+reg.sekwencja.postacKanoniczna+"\""+","+"\""+reg.sekwencja.dajPierwszyOperatorWarunku()+"\")")
            i+=1
        }

    }

    fun aktualizujReguly(){
        mapaRegul = regulyUsluga.podajReguly().map { it.kod to it }.toMap().toMutableMap()

        mapaRegul.forEach{
            mapaRegulWidok[it.key]!!.aktualizujDane(it.value)
        }
    }

    @FXML
    fun onWalidujRegulyKLIK() {
        println("onWalidujRegulyKLIK")

        wyczyscKonteneryBledow()

       czyModelWymagaPoprawy()

    }

    fun czyModelWymagaPoprawy():Boolean{
        var flaga = false

        mapaRegul.values.forEach {

            val bledy = it.waliduj()

            if (!bledy.isEmpty()) {
                mapaRegulWidok[it.kod]!!.kontenerBledow?.dodajBledy(bledy)
                flaga = true
            }
        }

        if (flaga) {
            Alert(Alert.AlertType.INFORMATION, "Wykryte zostały błędy walidacji!").show()
        }
        return flaga
    }

    private fun wyczyscKonteneryBledow(){
        mapaRegulWidok.forEach{
            it.value.kontenerBledow?.wyczyscBledy()
        }
    }
    @FXML
    fun onZapiszRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onZapiszRegulyKLIK")
        regulyUsluga.zapiszReguly(mapaRegul.values.toList())
        aktualizujReguly()
    }

    @FXML
    fun onGenerujKodKLIK() {
        wyczyscKonteneryBledow()
        println("onGenerujKodKLIK")

        if(czyModelWymagaPoprawy()){
            return
        }


        val stage = Stage();
        val root: FXMLLoader = loadFXML(this::class.java.classLoader.getResource("fxml/okno-wygenerowany-kod.fxml"),null);
        stage.setScene(Scene(root.getRoot()));
        stage.getScene().getStylesheets().add(this::class.java.classLoader.getResource("css/main.css").toExternalForm())
        stage.getScene().getStylesheets().add(this::class.java.classLoader.getResource("css/java.css").toExternalForm())
        stage.setTitle("My modal window");
        stage.initOwner(zamknijPrzycisk.getScene().getWindow() )
        stage.initModality(Modality.WINDOW_MODAL);
        stage.show();

        val kontrolerOknaKodu=root.getController<KontrolerOknaWygenerowanegoKodu>()
        kontrolerOknaKodu.ustawKod(generatorKodu.generujKodDlaRegul(mapaRegul.values.toList()))

    }

    @FXML
    fun onZamknijKLIK() {
        wyczyscKonteneryBledow()
        println("onZamknijKLIK")

        KontekstAplikacji.mainStage!!.close()

    }

    fun loadFXML(url: URL, resources: ResourceBundle?): FXMLLoader {
        val fxmlLoader = FXMLLoader()
        fxmlLoader.location = url
        fxmlLoader.resources = resources
        try {
            fxmlLoader.load<Any>()
            return fxmlLoader
        } catch (e: IOException) {
            e.printStackTrace(System.err)
            throw IllegalStateException(e)
        }

    }
}

/*

private void clickShow(ActionEvent event) {

}

* */


