package app.jfx

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import model.dto.Parametr
import model.dto.ParametrWywolaniaReguly
import model.dto.Regula


val SZEROKOSC_TABELI = 0.0
val SZEROKOSC_KOLUMNA_POJEDYNCZA = SZEROKOSC_TABELI
val SZEROKOSC_DWIE_KOLUMNY = SZEROKOSC_TABELI / 2
val SZEROKOSC_TRZY_KOLUMNY = SZEROKOSC_TABELI / 3
val WYSOKOSC_TABELI = 0.0


fun zbudujTabelkeRozpoznanychKomunikatow(regulaWidok: RegulaWidok
                                         , szerokoscKolumnyN: Double = SZEROKOSC_DWIE_KOLUMNY
                                         , szerokoscKolumnyW: Double = SZEROKOSC_DWIE_KOLUMNY
                                         , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                         , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<WierszTabeliDwieWartosci> {
    var kolumnaNazwa: TableColumn<WierszTabeliDwieWartosci, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<WierszTabeliDwieWartosci, String> = TableColumn("wartosc")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = regulaWidok.rozpoznaneKomunikatyWidok.map { it.wartosc.length }.max()
            ?: 20

    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN


    var tableView: TableView<WierszTabeliDwieWartosci> = TableView()
    tableView.items = regulaWidok.rozpoznaneKomunikatyWidok

    kolumnaNazwa.cellValueFactory = PropertyValueFactory<WierszTabeliDwieWartosci, String>("nazwa")
    kolumnaWartosc.cellValueFactory = PropertyValueFactory<WierszTabeliDwieWartosci, String>("wartosc")

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaWartosc)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli
    tableView.prefHeight = 2 * wyliczWysokoscTabeli(tableView.items.count(), 12, 12, 10)
    tableView.getStyleClass().add("noheader");
    return tableView
}

fun zbudujTabelkeRozpoznanychTokenow(regulaWidok: RegulaWidok
                                     , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                     , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY,
                                     szerokoscKolumnyK: Double = SZEROKOSC_TRZY_KOLUMNY
                                     , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                     , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<WierszTabeliTrzyWartosci> {
    var kolumnaNazwa: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("wartosc")
    var kolumnaKategoria: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("kategoria")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = regulaWidok.rozpoznaneTokenyWidok.map { it.wartosc.length }.max()!!
    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaKategoria.prefWidth = szerokoscKolumnyK

    var tableView: TableView<WierszTabeliTrzyWartosci> = TableView()
    tableView.items = regulaWidok.rozpoznaneTokenyWidok

    kolumnaNazwa.cellValueFactory = PropertyValueFactory<WierszTabeliTrzyWartosci, String>("nazwa")
    kolumnaWartosc.cellValueFactory = PropertyValueFactory<WierszTabeliTrzyWartosci, String>("wartosc")
    kolumnaKategoria.cellValueFactory = PropertyValueFactory<WierszTabeliTrzyWartosci, String>("kategoria")

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaWartosc)
    tableView.columns.add(kolumnaKategoria)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli
    tableView.prefHeight = 2 * wyliczWysokoscTabeli(tableView.items.count(), 12, 12, 10)
    tableView.getStyleClass().add("noheader");
    return tableView
}


fun zbudujTabelkeParametrowWejsciowych(regulaWidok: RegulaWidok
                                       , szerokoscKolumnyT: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscTabeli: Double = SZEROKOSC_TABELI
): TableView<WierszTabeliParametrowWe> {

    //WierszTabeliParametrowWe- typ w całym wierszu, String-typ danej kolumny
    var kolumnaTyp: TableColumn<WierszTabeliParametrowWe, String> = TableColumn("Typ")
    var kolumnaNazwa: TableColumn<WierszTabeliParametrowWe, String> = TableColumn("Nazwa")
    var kolumnaWartoscDomyslna: TableColumn<WierszTabeliParametrowWe, String> = TableColumn("Wartość domyślna")



    kolumnaTyp.prefWidth = szerokoscKolumnyT
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaWartoscDomyslna.prefWidth = szerokoscKolumnyW

    var tableView: TableView<WierszTabeliParametrowWe> = TableView(regulaWidok.rozpoznaneParametryWejsciowe)


    kolumnaNazwa.setCellValueFactory({ cellData -> cellData.value.nazwaProperty })
    kolumnaNazwa.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaNazwa.isEditable = false

    kolumnaTyp.setCellValueFactory({ cellData -> cellData.value.typProperty })
    kolumnaTyp.cellFactory = ComboBoxTableCell.forTableColumn(regulaWidok.nazwyDopuszczalnychWartosciTypowCBWidok)
    kolumnaTyp.setOnEditCommit({ t ->
        t.getTableView().getItems().get(t.getTablePosition().getRow()).parametr.typ = t.newValue
    })


    kolumnaWartoscDomyslna.setCellValueFactory({ cellData -> cellData.value.wartoscDomyslnaProperty })
    kolumnaWartoscDomyslna.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaWartoscDomyslna.isEditable = false

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaTyp)
    tableView.columns.add(kolumnaWartoscDomyslna)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli

    //tableView.prefHeight = wysokoscTabeli
    tableView.prefHeight = 2 * wyliczWysokoscTabeli(tableView.items.count(), 12, 12, 10)
    //tableView.getStyleClass().add("noheader");

    tableView.isEditable = true
    return tableView
}


fun zbudujTabelkeParametrowWyjsciowych(regulaWidok: RegulaWidok
                                       , nazwyParametrowRegulyWejsciowej: List<String>
                                       , szerokoscKolumnyT: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscTabeli: Double = SZEROKOSC_TABELI
): TableView<WierszTabeliParametrowWy> {

    //WierszTabeliParametrowWe- typ w całym wierszu, String-typ danej kolumny
    var kolumnaTyp: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Parametr lokalny")
    var kolumnaNazwa: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Parametr wołany")
    var kolumnaWartoscDomyslna: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Domyślna")

    kolumnaTyp.prefWidth = szerokoscKolumnyT
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaWartoscDomyslna.prefWidth = szerokoscKolumnyW


    var tableView: TableView<WierszTabeliParametrowWy> = TableView(regulaWidok.rozpoznaneParametryWyjscioweWidok)


    kolumnaNazwa.setCellValueFactory({ cellData -> cellData.value.nazwaParametruRegulyWolanejProp })
    kolumnaNazwa.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaNazwa.isEditable = false

    kolumnaTyp.setCellValueFactory({ cellData -> cellData.value.nazwaParametruRegulyWolajacejProp })
    kolumnaTyp.cellFactory = ComboBoxTableCell.forTableColumn(regulaWidok.nazwyParametrowWejsciowychCBWidok)
    kolumnaTyp.setOnEditCommit({ t ->
        t.getTableView().getItems().get(t.getTablePosition().getRow()).parametr.nazwaParametruRegulyWolajacej = t.newValue
    })


    kolumnaWartoscDomyslna.setCellValueFactory({ cellData -> cellData.value.wartoscDomyslnaProperty })
    kolumnaWartoscDomyslna.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaWartoscDomyslna.isEditable = false

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaTyp)
    tableView.columns.add(kolumnaWartoscDomyslna)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli

    val iloscElementow = if (tableView.items.count() > 0) tableView.items.count() else 2

    tableView.prefHeight = 2 * wyliczWysokoscTabeli(iloscElementow, 12, 12, 10)
    //tableView.getStyleClass().add("noheader");
    tableView.minHeight = tableView.prefHeight


    tableView.isEditable = true
    return tableView
}

fun zbudujKontenerBledow(szerokoscKontenera: Double): PrzewijanyKontenerBledow {

    val pPanelBledow = PrzewijanyKontenerBledow()
    pPanelBledow.padding = Insets(10.0)
    pPanelBledow.style = "-fx-border-color: red;"
    pPanelBledow.prefWidth = szerokoscKontenera
    pPanelBledow.minWidth = szerokoscKontenera
    pPanelBledow.maxWidth = szerokoscKontenera
    pPanelBledow.prefHeight = 0.0

    return pPanelBledow
}

/**
 * Helper to set table height based on content
 *
 * @param table        - the table in context
 * @param rowHeight    - the height of a single row, alternatively could use table.fixedCellSizeProperty()
 * @param headerHeight - the height of the table header
 * @param margin       - a value for the margins
 */
fun wyliczWysokoscTabeli(tableItemsCount: Int, rowHeight: Int, headerHeight: Int, margin: Int): Double {
    return (tableItemsCount * rowHeight + headerHeight + margin).toDouble()

}


open class WierszTabeliParametrowWe(aNazwa: String, aTyp: String, aWartosc: String, aParametr: Parametr) {
    val nazwaProperty: SimpleStringProperty
    val typProperty: SimpleStringProperty
    val wartoscDomyslnaProperty: SimpleStringProperty

    val parametr: Parametr

    init {
        nazwaProperty = SimpleStringProperty(aNazwa)
        typProperty = SimpleStringProperty(aTyp)
        wartoscDomyslnaProperty = SimpleStringProperty(aWartosc)
        parametr = aParametr
    }


}

open class WierszTabeliParametrowWy(aNazwaParametruRegulyWolanej: String, aNazwaParametruRegulyWolajacej: String, aWartosc: String, aParametr: ParametrWywolaniaReguly) {
    val nazwaParametruRegulyWolanejProp: SimpleStringProperty
    val nazwaParametruRegulyWolajacejProp: SimpleStringProperty
    val wartoscDomyslnaProperty: SimpleStringProperty

    val parametr: ParametrWywolaniaReguly

    init {
        nazwaParametruRegulyWolanejProp = SimpleStringProperty(aNazwaParametruRegulyWolanej)
        nazwaParametruRegulyWolajacejProp = SimpleStringProperty(aNazwaParametruRegulyWolajacej)
        wartoscDomyslnaProperty = SimpleStringProperty(aWartosc)
        parametr = aParametr
    }


}

open class WierszTabeliDwieWartosci(val nazwa: String, val wartosc: String)

open class WrapperParametruNazwaWartosc(val nazwa: String, val wartosc: String)

open class WierszTabeliTrzyWartosci(val nazwa: String, val wartosc: String, val kategoria: String)


open class PrzewijanyKontenerBledow : ListView<String> {

    constructor() : super() {
        isVisible=false
    }

    fun dodajBledy(aBledy: List<String>) {
        if (aBledy.isEmpty()) {
            return
        }

        isVisible=true
        items.addAll(aBledy)
        this.prefHeight = 100.0
    }

    fun wyczyscBledy() {
        isVisible=false
        this.prefHeight = 0.0
        items.clear()
    }
}


open class RegulaWidok {
    var rozpoznaneKomunikatyWidok: ObservableList<WierszTabeliDwieWartosci> = FXCollections.observableArrayList()
    var rozpoznaneTokenyWidok: ObservableList<WierszTabeliTrzyWartosci> = FXCollections.observableArrayList()
    var rozpoznaneParametryWyjscioweWidok: ObservableList<WierszTabeliParametrowWy> = FXCollections.observableArrayList()
    var rozpoznaneParametryWejsciowe: ObservableList<WierszTabeliParametrowWe> = FXCollections.observableArrayList()
    var nazwyParametrowWejsciowychCBWidok = FXCollections.observableArrayList<String>()
    var nazwyDopuszczalnychWartosciTypowCBWidok = FXCollections.observableArrayList<String>()
    var kontenerBledow: PrzewijanyKontenerBledow? = null


    fun aktualizujDane(regula: Regula) {
        rozpoznaneKomunikatyWidok.clear()
        rozpoznaneTokenyWidok.clear()
        nazwyDopuszczalnychWartosciTypowCBWidok.clear()
        rozpoznaneParametryWejsciowe.clear()
        nazwyParametrowWejsciowychCBWidok.clear()
        rozpoznaneParametryWyjscioweWidok.clear()

        regula?.sekwencja?.komunikaty?.forEach {
            rozpoznaneKomunikatyWidok.add(WierszTabeliDwieWartosci(it.key, it.value))
        }
        regula.sekwencja.rozpoznaneTokeny.forEach {
            rozpoznaneTokenyWidok.add(WierszTabeliTrzyWartosci(it.wartosc, it.typ.toString(), it?.kategoria ?: ""))
        }

        nazwyDopuszczalnychWartosciTypowCBWidok.addAll("Liczba", "Napis", "Data")

        regula.parametry.forEach {
            rozpoznaneParametryWejsciowe.add(WierszTabeliParametrowWe(it.nazwa, it.typ ?: "", it.wartoscDomyslna
                    ?: "", it))
        }

        nazwyParametrowWejsciowychCBWidok.addAll(regula.parametry.map {
            it.nazwa
        })

        regula?.wywolaniaRegul?.forEach {
            val regula_wolana = it.kodRegulyWolanej
            it?.parametry?.forEach {
                rozpoznaneParametryWyjscioweWidok.add(
                        WierszTabeliParametrowWy(
                                regula_wolana + "." + it.nazwaParametruRegulyWolanej + "=", it.nazwaParametruRegulyWolajacej, "", it)
                )
            }
        }

    }


}