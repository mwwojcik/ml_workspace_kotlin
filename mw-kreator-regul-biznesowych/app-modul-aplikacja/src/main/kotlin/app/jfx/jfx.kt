package app.jfx

import javafx.beans.property.SimpleStringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.control.ComboBox
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.util.Callback
import model.dto.Parametr
import model.dto.ParametrWywolaniaReguly
import model.dto.WywolanieReguly

import sun.misc.Signal.handle


val SZEROKOSC_TABELI = 0.0
val SZEROKOSC_KOLUMNA_POJEDYNCZA = SZEROKOSC_TABELI
val SZEROKOSC_DWIE_KOLUMNY = SZEROKOSC_TABELI / 2
val SZEROKOSC_TRZY_KOLUMNY = SZEROKOSC_TABELI / 3
val WYSOKOSC_TABELI = 0.0


fun zbudujTabelkeProstychWlasnosciKluczWartosc(parametry: List<WrapperParametruNazwaWartosc>
                                               , szerokoscKolumnyN: Double = SZEROKOSC_DWIE_KOLUMNY
                                               , szerokoscKolumnyW: Double = SZEROKOSC_DWIE_KOLUMNY
                                               , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                               , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<ProstaTabelaNazwaWartosc> {
    var kolumnaNazwa: TableColumn<ProstaTabelaNazwaWartosc, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<ProstaTabelaNazwaWartosc, String> = TableColumn("wartosc")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = parametry.map { it.wartosc.length }.max()!!
    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN


    var list: ObservableList<ProstaTabelaNazwaWartosc> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(ProstaTabelaNazwaWartosc(param.nazwa, param.wartosc))
    }

    var tableView: TableView<ProstaTabelaNazwaWartosc> = TableView()
    tableView.items = list

    kolumnaNazwa.cellValueFactory = PropertyValueFactory<ProstaTabelaNazwaWartosc, String>("nazwa")
    kolumnaWartosc.cellValueFactory = PropertyValueFactory<ProstaTabelaNazwaWartosc, String>("wartosc")

    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaWartosc)

    tableView.prefWidth = szerokoscTabeli
    tableView.minWidth = szerokoscTabeli
    tableView.maxWidth = szerokoscTabeli
    tableView.prefHeight = 2 * wyliczWysokoscTabeli(tableView.items.count(), 12, 12, 10)
    tableView.getStyleClass().add("noheader");
    return tableView
}

fun zbudujTabelkeWlasnosciNazwaWartoscKategoria(parametry: List<WrapperParametruNazwaWartoscKategoria>
                                               , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                               , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY,
                                                szerokoscKolumnyK: Double = SZEROKOSC_TRZY_KOLUMNY
                                               , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                               , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<WrapperParametruNazwaWartoscKategoria> {
    var kolumnaNazwa: TableColumn<WrapperParametruNazwaWartoscKategoria, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<WrapperParametruNazwaWartoscKategoria, String> = TableColumn("wartosc")
    var kolumnaKategoria: TableColumn<WrapperParametruNazwaWartoscKategoria, String> = TableColumn("kategoria")


    var dlugoscNajwiekszegoNapisuKolumnyW: Int = parametry.map { it.wartosc.length }.max()!!
    var maksymalnaDlugoscKolumnyW = dlugoscNajwiekszegoNapisuKolumnyW * 5.0

    kolumnaWartosc.prefWidth = if (maksymalnaDlugoscKolumnyW > szerokoscKolumnyW) maksymalnaDlugoscKolumnyW else szerokoscKolumnyW;
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaKategoria.prefWidth = szerokoscKolumnyK


    var list: ObservableList<WrapperParametruNazwaWartoscKategoria> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(WrapperParametruNazwaWartoscKategoria(param.nazwa, param.wartosc,param.kategoria))
    }

    var tableView: TableView<WrapperParametruNazwaWartoscKategoria> = TableView()
    tableView.items = list

    kolumnaNazwa.cellValueFactory = PropertyValueFactory<WrapperParametruNazwaWartoscKategoria, String>("nazwa")
    kolumnaWartosc.cellValueFactory = PropertyValueFactory<WrapperParametruNazwaWartoscKategoria, String>("wartosc")
    kolumnaKategoria.cellValueFactory = PropertyValueFactory<WrapperParametruNazwaWartoscKategoria, String>("kategoria")

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
): TableView<WierszTabeliParametrowWeWy> {

    //WierszTabeliParametrowWeWy- typ w całym wierszu, String-typ danej kolumny
    var kolumnaTyp: TableColumn<WierszTabeliParametrowWeWy, String> = TableColumn("Typ")
    var kolumnaNazwa: TableColumn<WierszTabeliParametrowWeWy, String> = TableColumn("Nazwa")
    var kolumnaWartoscDomyslna: TableColumn<WierszTabeliParametrowWeWy, String> = TableColumn("Wartość domyślna")

    kolumnaTyp.prefWidth = szerokoscKolumnyT
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaWartoscDomyslna.prefWidth = szerokoscKolumnyW

    var list: ObservableList<WierszTabeliParametrowWeWy> =
            FXCollections.observableArrayList(parametry.map{WierszTabeliParametrowWeWy(it.nazwa,it.typ?:"",it.wartoscDomyslna?:"",it)}.toList())
    var tableView: TableView<WierszTabeliParametrowWeWy> = TableView(list)


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
                                       , szerokoscKolumnyT: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscTabeli: Double = SZEROKOSC_TABELI
): TableView<WierszTabeliParametrowWy> {

    //WierszTabeliParametrowWeWy- typ w całym wierszu, String-typ danej kolumny
    var kolumnaTyp: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Parametr lokalny")
    var kolumnaNazwa: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Parametr wołany")
    var kolumnaWartoscDomyslna: TableColumn<WierszTabeliParametrowWy, String> = TableColumn("Wartość domyślna")

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

   /*list.addAll(wywolania.map{

   }.toList())


            FXCollections.observableArrayList(parametry.map{WierszTabeliParametrowWeWy(it.nazwa,it.typ?:"",it.wartoscDomyslna?:"",it)}.toList())
    */

    var tableView: TableView<WierszTabeliParametrowWy> = TableView(list)


    kolumnaNazwa.setCellValueFactory ({ cellData -> cellData.value.nazwaProperty})
    kolumnaNazwa.cellFactory = TextFieldTableCell.forTableColumn()
    kolumnaNazwa.isEditable=false

    kolumnaTyp.setCellValueFactory ({ cellData -> cellData.value.typProperty})
    kolumnaTyp.cellFactory = ComboBoxTableCell.forTableColumn("Liczba", "Napis", "Data")
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






open class WierszTabeliParametrowWeWy(aNazwa: String, aTyp: String,aWartosc:String,aParametr:Parametr) {
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

open class ProstaTabelaNazwaWartosc(val nazwa: String, val wartosc: String)

open class ProstaTabelaTylkoWartosc(val wartosc: String)

open class WrapperParametruNazwaWartosc(val nazwa: String, val wartosc: String)

open class WrapperParametruNazwaWartoscKategoria(val nazwa: String, val wartosc: String,val kategoria:String)


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

/*fun zbudujTabelkeTylkoWartosc(parametry: List<String>,
                              szerokoscKolumny: Double = SZEROKOSC_KOLUMNA_POJEDYNCZA,
                              szerokoscTabeli: Double = SZEROKOSC_TABELI,
                              wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<ProstaTabelaTylkoWartosc> {
    var kolumnaWartosc: TableColumn<ProstaTabelaTylkoWartosc, String> = TableColumn("wartosc")


    kolumnaWartosc.prefWidth = szerokoscKolumny


    var list: ObservableList<ProstaTabelaTylkoWartosc> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(ProstaTabelaTylkoWartosc(param))
    }

    var tableView: TableView<ProstaTabelaTylkoWartosc> = TableView()
    tableView.items = list



    kolumnaWartosc.cellValueFactory = PropertyValueFactory<ProstaTabelaTylkoWartosc, String>("wartosc")


    tableView.columns.add(kolumnaWartosc)


    tableView.prefWidth = szerokoscTabeli

    //tableView.prefHeight =wysokoscTabeli
    tableView.prefHeight= wyliczWysokoscTabeli(tableView,12,12,10)
    return tableView
}*/