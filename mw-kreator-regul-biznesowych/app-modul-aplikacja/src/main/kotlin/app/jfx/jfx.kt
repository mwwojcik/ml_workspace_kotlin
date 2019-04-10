package app.jfx

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import model.dto.Parametr
import model.dto.ParametrWywolaniaReguly
import model.dto.WywolanieReguly


val SZEROKOSC_TABELI = 0.0
val SZEROKOSC_KOLUMNA_POJEDYNCZA = SZEROKOSC_TABELI
val SZEROKOSC_DWIE_KOLUMNY = SZEROKOSC_TABELI / 2
val SZEROKOSC_TRZY_KOLUMNY = SZEROKOSC_TABELI / 3
val WYSOKOSC_TABELI = 0.0


fun zbudujTabelkeRozpoznanychKomunikatow(parametry: List<WrapperParametruNazwaWartosc>
                                         , szerokoscKolumnyN: Double = SZEROKOSC_DWIE_KOLUMNY
                                         , szerokoscKolumnyW: Double = SZEROKOSC_DWIE_KOLUMNY
                                         , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                         , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<WierszTabeliDwieWartosci> {
    var kolumnaNazwa: TableColumn<WierszTabeliDwieWartosci, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<WierszTabeliDwieWartosci, String> = TableColumn("wartosc")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = parametry.map { it.wartosc.length }.max()!!
    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN


    var list: ObservableList<WierszTabeliDwieWartosci> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(WierszTabeliDwieWartosci(param.nazwa, param.wartosc))
    }

    var tableView: TableView<WierszTabeliDwieWartosci> = TableView()
    tableView.items = list

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

fun zbudujTabelkeRozpoznanychTokenow(parametry: List<WierszTabeliTrzyWartosci>
                                     , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                     , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY,
                                     szerokoscKolumnyK: Double = SZEROKOSC_TRZY_KOLUMNY
                                     , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                     , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<WierszTabeliTrzyWartosci> {
    var kolumnaNazwa: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("wartosc")
    var kolumnaKategoria: TableColumn<WierszTabeliTrzyWartosci, String> = TableColumn("kategoria")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = parametry.map { it.wartosc.length }.max()!!
    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaKategoria.prefWidth = szerokoscKolumnyK


    var list: ObservableList<WierszTabeliTrzyWartosci> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(WierszTabeliTrzyWartosci(param.nazwa, param.wartosc,param.kategoria))
    }

    var tableView: TableView<WierszTabeliTrzyWartosci> = TableView()
    tableView.items = list

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


fun zbudujTabelkeParametrowWejsciowych(parametry: MutableList<Parametr>
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

    var list: ObservableList<WierszTabeliParametrowWe> =
            FXCollections.observableArrayList(parametry.map{WierszTabeliParametrowWe(it.nazwa,it.typ?:"",it.wartoscDomyslna?:"",it)}.toList())
    var tableView: TableView<WierszTabeliParametrowWe> = TableView(list)


    kolumnaNazwa.setCellValueFactory ({ cellData -> cellData.value.nazwaProperty})
    kolumnaNazwa.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaNazwa.isEditable=false

    kolumnaTyp.setCellValueFactory ({ cellData -> cellData.value.typProperty})
    kolumnaTyp.cellFactory = ComboBoxTableCell.forTableColumn("Liczba", "Napis", "Data")
    kolumnaTyp.setOnEditCommit({t->
        t.getTableView().getItems().get(t.getTablePosition().getRow()).parametr.typ=t.newValue
    })


    kolumnaWartoscDomyslna.setCellValueFactory ({ cellData -> cellData.value.wartoscDomyslnaProperty})
    kolumnaWartoscDomyslna.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaWartoscDomyslna.isEditable=false

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaTyp)
    tableView.columns.add(kolumnaWartoscDomyslna)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli

    //tableView.prefHeight = wysokoscTabeli
    tableView.prefHeight = 2 * wyliczWysokoscTabeli(tableView.items.count(), 12, 12, 10)
    //tableView.getStyleClass().add("noheader");

    tableView.isEditable=true
    return tableView
}



fun zbudujTabelkeParametrowWyjsciowych(wywolania: List<WywolanieReguly>
                                       , nazwyParametrowRegulyWejsciowej:List<String>
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

    var list: ObservableList<WierszTabeliParametrowWy> = FXCollections.observableArrayList()

    wywolania.forEach{
        val regula_wolana=it.kodRegulyWolanej
        it.parametry.forEach{
            list.add(

                    WierszTabeliParametrowWy(
                            regula_wolana+"."+it.nazwaParametruRegulyWolanej+"=","","",it)

            )
        }
    }

    var tableView: TableView<WierszTabeliParametrowWy> = TableView(list)


    kolumnaNazwa.setCellValueFactory ({ cellData -> cellData.value.nazwaProperty})
    kolumnaNazwa.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaNazwa.isEditable=false

    kolumnaTyp.setCellValueFactory ({ cellData -> cellData.value.typProperty})
    kolumnaTyp.cellFactory = ComboBoxTableCell.forTableColumn(FXCollections.observableArrayList<String>(nazwyParametrowRegulyWejsciowej))
    kolumnaTyp.setOnEditCommit({t->
        t.getTableView().getItems().get(t.getTablePosition().getRow()).parametr.nazwaParametruRegulyWolajacej=t.newValue
    })


    kolumnaWartoscDomyslna.setCellValueFactory ({ cellData -> cellData.value.wartoscDomyslnaProperty})
    kolumnaWartoscDomyslna.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaWartoscDomyslna.isEditable=false

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaTyp)
    tableView.columns.add(kolumnaWartoscDomyslna)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli

    val iloscElementow =if (tableView.items.count()>0) tableView.items.count() else 2

    tableView.prefHeight = 2 * wyliczWysokoscTabeli(iloscElementow, 12, 12, 10)
    //tableView.getStyleClass().add("noheader");
    tableView.minHeight=tableView.prefHeight


    tableView.isEditable=true
    return tableView
}

fun zbudujKontenerBledow(szerokoscKontenera:Double):KontenerBledow{

    val pPanelBledow=KontenerBledow()
    pPanelBledow.spacing=10.0
    pPanelBledow.padding= Insets(10.0)
    pPanelBledow.style="-fx-border-color: red;"
    pPanelBledow.prefWidth=szerokoscKontenera
    pPanelBledow.minWidth=szerokoscKontenera
    pPanelBledow.maxWidth=szerokoscKontenera

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
fun wyliczWysokoscTabeli(tableItemsCount:Int, rowHeight: Int, headerHeight: Int, margin: Int): Double {
    return (tableItemsCount * rowHeight + headerHeight + margin).toDouble()

}






open class WierszTabeliParametrowWe(aNazwa: String, aTyp: String, aWartosc:String, aParametr:Parametr) {
    val nazwaProperty: SimpleStringProperty
    val typProperty: SimpleStringProperty
    val wartoscDomyslnaProperty: SimpleStringProperty

    val parametr: Parametr

    init {
        nazwaProperty = SimpleStringProperty(aNazwa)
        typProperty = SimpleStringProperty(aTyp)
        wartoscDomyslnaProperty= SimpleStringProperty(aWartosc)
        parametr = aParametr
    }


}

open class WierszTabeliParametrowWy(aNazwa: String, aTyp: String,aWartosc:String,aParametr:ParametrWywolaniaReguly) {
    val nazwaProperty: SimpleStringProperty
    val typProperty: SimpleStringProperty
    val wartoscDomyslnaProperty: SimpleStringProperty

    val parametr: ParametrWywolaniaReguly

    init {
        nazwaProperty = SimpleStringProperty(aNazwa)
        typProperty = SimpleStringProperty(aTyp)
        wartoscDomyslnaProperty= SimpleStringProperty(aWartosc)
        parametr = aParametr
    }


}

open class WierszTabeliDwieWartosci(val nazwa: String, val wartosc: String)

open class WrapperParametruNazwaWartosc(val nazwa: String, val wartosc: String)

open class WierszTabeliTrzyWartosci(val nazwa: String, val wartosc: String, val kategoria:String)


open class KontenerBledow:VBox{
    constructor():super(){
        isVisible=false
    }

    fun dodajBledy(aBledy:List<String>){
        if(aBledy.isEmpty()){
            return
        }

        isVisible=true

        aBledy.forEach{
            val pKom= Label(it)
            pKom.setTextFill(Color.web("#FF0000"));
            children.add(pKom)
        }
    }

    fun wyczyscBledy(){
        children.clear()
        isVisible=false
    }
}

open class RegulaWidok{
    var rozpoznaneKomunikatyWidok: ObservableList<WierszTabeliDwieWartosci> = FXCollections.observableArrayList()
    var rozpoznaneTokenyWidok:ObservableList<WierszTabeliTrzyWartosci> = FXCollections.observableArrayList()
    var rozpoznaneParametryWyjscioweWidok:ObservableList<WierszTabeliParametrowWy> = FXCollections.observableArrayList()
    var rozpoznaneParametryWejsciowe:ObservableList<WierszTabeliParametrowWe> = FXCollections.observableArrayList()
    var nazwyParametrowWejsciowychCBWidok=FXCollections.observableArrayList<String>()
    var nazwyDopuszczalnychTypowCBWidok=FXCollections.observableArrayList<String>()
}