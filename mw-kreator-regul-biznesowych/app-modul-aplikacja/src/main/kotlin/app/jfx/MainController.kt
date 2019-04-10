package app.jfx

import app.KontekstAplikacji
import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import model.dto.Regula
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean


@Controller
class MainController {

    @Autowired
    lateinit var regulyUsluga: RegulyUslugaBean

    lateinit var listaRegul: List<Regula>

    lateinit var mapaRegul: Map<String, Regula>


    @FXML
    lateinit var panelRegul: VBox

    //val listaTabelParametrow:MutableList<TitledPane> = mutableListOf<TitledPane>()
    val mapaKonenerowBledowWalidacji: MutableMap<String, KontenerBledow> = mutableMapOf<String, KontenerBledow>()
    val mapaKonenerowParametrowWe: MutableMap<String, TitledPane> = mutableMapOf<String, TitledPane>()
    val mapaKonenerowParametrowWy: MutableMap<String, TitledPane> = mutableMapOf<String, TitledPane>()


    @FXML
    private fun initialize() {

        panelRegul.spacing = 50.0

        listaRegul = regulyUsluga.podajReguly()

        for (reg in listaRegul) {

            //val wartoscNazwaParametry= mutableListOf<WrapperParametruNazwaWartosc>(WrapperParametruNazwaWartosc("Treść",reg.tresc))
            val pTytul = Label(reg.tresc + "\n\n" + "-- Postać znormalizowana --" + "\n\n" + reg.sekwencja.postacKanoniczna)
            pTytul.prefWidth = 700.0
            pTytul.tooltip = Tooltip(reg.tresc)
            pTytul.isWrapText = true
            pTytul.padding = Insets(10.0)
            pTytul.setStyle("-fx-font-weight: bold")

            val wartoscKomunikaty = mutableListOf<WrapperParametruNazwaWartosc>()

            if (!reg.sekwencja.komunikaty.isNullOrEmpty()) {

                for (klucz in reg.sekwencja.komunikaty!!.keys) {
                    wartoscKomunikaty.add(WrapperParametruNazwaWartosc(klucz, reg.sekwencja.komunikaty!![klucz]!!))
                }
            }

            val wartoscNazwaParametry = mutableListOf<WierszTabeliTrzyWartosci>()
            wartoscNazwaParametry.add(WierszTabeliTrzyWartosci("", "", ""))
            for (sek in reg.sekwencja!!.rozpoznaneTokeny) {
                wartoscNazwaParametry.add(WierszTabeliTrzyWartosci(sek.wartosc, sek.typ.toString(), sek.kategoria
                        ?: ""))
            }


            //kontenerek na regule
            var pKontenerNaTabelki: VBox = VBox()
            var pKontenerTytylowy = TitledPane(reg.kod, pKontenerNaTabelki)
            panelRegul.children.add(pKontenerTytylowy)


            pKontenerNaTabelki.spacing = 5.0
            pKontenerNaTabelki.prefWidth = 800.0

            pKontenerNaTabelki.children.add(pTytul)
            //wiersz zerowy - komunikaty

            if (!wartoscKomunikaty.isNullOrEmpty()) {
                pKontenerNaTabelki.children.add(zbudujTabelkeRozpoznanychKomunikatow(wartoscKomunikaty
                        , szerokoscKolumnyN = 80.0
                        , szerokoscKolumnyW = 600.0
                        , szerokoscTabeli = 700.0))
            }

            //PIERWSZY WIERSZ
            pKontenerNaTabelki.children.add(zbudujTabelkeRozpoznanychTokenow(wartoscNazwaParametry
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

            val pParametryTab = zbudujTabelkeParametrowWejsciowych(reg.parametry!!
                    , szerokoscTabeli = 308.0
                    , szerokoscKolumnyN = 100.0
                    , szerokoscKolumnyT = 100.0
                    , szerokoscKolumnyW = 90.0)

            var pKontenerParametrowWe = TitledPane("Parametry WE", pParametryTab)
            var pKontenerParametrowWy = TitledPane("Parametry WY", zbudujTabelkeParametrowWyjsciowych(reg.wywolaniaRegul
                    , nazwyParametrow
                    , szerokoscTabeli = 308.0
                    , szerokoscKolumnyN = 100.0
                    , szerokoscKolumnyT = 100.0
                    , szerokoscKolumnyW = 90.0))

            pKontenerParametrowWe.isExpanded = true
            pKontenerParametrowWy.isExpanded = true

            mapaKonenerowParametrowWe.put(reg.kod, pKontenerParametrowWe)
            mapaKonenerowParametrowWy.put(reg.kod, pKontenerParametrowWy)

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
                    aktualizujParametryWe()
                }
            }

            val przyciskUsunParam = Button("Usuń")
            przyciskUsunParam.setOnMouseClicked {
                regulyUsluga.usunParametr(mapaRegul[reg.kod]!!)
                aktualizujParametryWe()
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
            pKontenerNaTabelki.children.add(pPanelBledow)
            mapaKonenerowBledowWalidacji.put(reg.kod, pPanelBledow)

            mapaRegul = listaRegul.map { it.kod to it }.toMap()
        }
    }

    fun aktualizujParametryWe() {
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


    fun wyczyscKonteneryBledow() {
        mapaKonenerowBledowWalidacji.forEach { String, kontener ->
            kontener.wyczyscBledy()
        }

        mapaKonenerowParametrowWe.forEach { String, kontener ->
            kontener.style = "-fx-border:none;"

        }
    }


    @FXML
    fun onWczytajRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onWczytajRegulyKLIK")
        listaRegul = regulyUsluga.podajReguly()

    }

    @FXML
    fun onWalidujRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onWalidujRegulyKLIK")

        var flaga = false

        listaRegul.forEach {

            val bledy = it.waliduj()

            if (!bledy.isEmpty()) {
                mapaKonenerowBledowWalidacji[it.kod]!!.dodajBledy(bledy)
                mapaKonenerowParametrowWe[it.kod]!!.isExpanded = true
                mapaKonenerowParametrowWe[it.kod]!!.style = "-fx-border-color: red;"

                flaga = true
                /*  mapaKonenerowParametrowWy[it.kod]!!.isExpanded = true
                  mapaKonenerowParametrowWy[it.kod]!!.style = "-fx-border-color: red;"*/
            }


        }

        if (flaga) {
            Alert(Alert.AlertType.INFORMATION, "Wykryte zostały błędy walidacji!").show()
        }

    }

    @FXML
    fun onZapiszRegulyKLIK() {
        wyczyscKonteneryBledow()
        println("onZapiszRegulyKLIK")
        regulyUsluga.zapiszReguly(listaRegul)
        aktualizujParametryWe()
    }

    @FXML
    fun onGenerujKodKLIK() {
        wyczyscKonteneryBledow()
        println("onGenerujKodKLIK")

    }

    @FXML
    fun onZamknijKLIK() {
        wyczyscKonteneryBledow()
        println("onZamknijKLIK")

        KontekstAplikacji.mainStage!!.close()

    }
}

