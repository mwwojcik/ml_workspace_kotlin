package app.jfx

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ComboBox
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.PropertyValueFactory
import model.encje.ParametrRegulyEncja

val SZEROKOSC_TABELI = 600.0
val SZEROKOSC_KOLUMNA_POJEDYNCZA = SZEROKOSC_TABELI
val SZEROKOSC_DWIE_KOLUMNY = SZEROKOSC_TABELI / 2
val SZEROKOSC_TRZY_KOLUMNY = SZEROKOSC_TABELI / 3
val WYSOKOSC_TABELI = 100.0

fun zbudujTabelkeTylkoWartosc(parametry: List<String>,
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
    tableView.prefHeight =wysokoscTabeli
    return tableView
}

fun zbudujTabelkeProstychWlasnosciKluczWartosc(parametry: List<WrapperParametruNazwaWartosc>
                                               , szerokoscKolumnyN: Double = SZEROKOSC_DWIE_KOLUMNY
                                               , szerokoscKolumnyW: Double = SZEROKOSC_DWIE_KOLUMNY
                                               , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                               , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<ProstaTabelaNazwaWartosc> {
    var kolumnaNazwa: TableColumn<ProstaTabelaNazwaWartosc, String> = TableColumn("nazwa")
    var kolumnaWartosc: TableColumn<ProstaTabelaNazwaWartosc, String> = TableColumn("wartosc")


    kolumnaWartosc.prefWidth = szerokoscKolumnyW
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
    tableView.prefHeight = wysokoscTabeli
    return tableView
}

fun zbudujTabelkeParametrowWejsciowych(parametry: MutableList<ParametrRegulyEncja>
                                       , szerokoscKolumnyT: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyN: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscKolumnyW: Double = SZEROKOSC_TRZY_KOLUMNY
                                       , szerokoscTabeli: Double = SZEROKOSC_TABELI
                                       , wysokoscTabeli: Double = WYSOKOSC_TABELI): TableView<TabelaPoleCombo> {
    var kolumnaTyp: TableColumn<TabelaPoleCombo, ComboBox<String>> = TableColumn("Parametr")
    var kolumnaNazwa: TableColumn<TabelaPoleCombo, String> = TableColumn("Typ")
    var kolumnaWartoscDomyslna: TableColumn<TabelaPoleCombo, String> = TableColumn("Wartość domyślna")

    kolumnaTyp.prefWidth = szerokoscKolumnyT
    kolumnaNazwa.prefWidth = szerokoscKolumnyN
    kolumnaWartoscDomyslna.prefWidth = szerokoscKolumnyW

    var list: ObservableList<TabelaPoleCombo> = FXCollections.observableArrayList()

    for (param in parametry) {
        list.add(TabelaPoleCombo(param.nazwa, zbudujCombo()))
    }

    var tableView: TableView<TabelaPoleCombo> = TableView()
    tableView.items = list


    kolumnaNazwa.cellValueFactory = PropertyValueFactory<TabelaPoleCombo, String>("nazwa")
    kolumnaTyp.cellValueFactory = PropertyValueFactory<TabelaPoleCombo, ComboBox<String>>("typ")
    kolumnaWartoscDomyslna.cellValueFactory = PropertyValueFactory<TabelaPoleCombo, String>("wartoscDomyslna")
    tableView.columns.add(kolumnaNazwa)
    tableView.columns.add(kolumnaTyp)
    tableView.columns.add(kolumnaWartoscDomyslna)

    tableView.prefWidth = szerokoscTabeli
    tableView.prefHeight = wysokoscTabeli
    return tableView
}

fun zbudujCombo(): ComboBox<String> {
    var typCombo: ComboBox<String> = ComboBox<String>()
    typCombo.items.add("Liczba")
    typCombo.items.add("Napis")
    typCombo.items.add("Data")
    typCombo.prefHeight = 9.0
    return typCombo;
}

open class TabelaPoleCombo(val nazwa: String, val typ: ComboBox<String>) {
    var wartoscDomyslna: String? = null;
}

open class ProstaTabelaNazwaWartosc(val nazwa: String, val wartosc: String)

open class ProstaTabelaTylkoWartosc(val wartosc: String)

open class WrapperParametruNazwaWartosc(val nazwa: String, val wartosc: String)