package app.jfx

import db.RegulyDbBean
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.web.WebView
import model.encje.ParametrRegulyEncja
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
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

            panelRegul.children.add(pKontener)
            pKontener.prefWidth=800.0

            val pKodReguly=Label(reg.nazwa)
            pKodReguly.style="-fx-font-weight: bold;-fx-font-size:14px;"
            pKontener.children.add(pKodReguly)

            val ta=TextArea(reg.tresc)
            ta.appendText("\n")
            ta.appendText(reg.sekwencja?.drukujDoStr())
            //ta.prefWidth=600.0
            ta.prefHeight=150.0
            ta.prefWidth=pKontener.prefWidth

            pKontener.children.add(ta)

            pKontener.children.add(zbudujTabelkeParametrowWejsciowych(reg.parametry))

        }
    }

    fun zbudujTabelkeParametrowWejsciowych(parametry: MutableList<ParametrRegulyEncja>): TableView<TableBean> {
        var kolumnaTyp: TableColumn<TableBean, ComboBox<String>> = TableColumn("Parametr")
        var kolumnaNazwa: TableColumn<TableBean, String> = TableColumn("Typ")
        var kolumnaWartoscDomyslna: TableColumn<TableBean, String> = TableColumn("Wartość domyślna")

        kolumnaTyp.prefWidth = 150.0
        kolumnaNazwa.prefWidth = 150.0
        kolumnaWartoscDomyslna.prefWidth = 90.0

        var list: ObservableList<TableBean> = FXCollections.observableArrayList()

        for (param in parametry) {
            list.add(TableBean(param.nazwa, zbudujCombo()))
        }

        var tableView: TableView<TableBean> = TableView()
        tableView.items = list


        kolumnaNazwa.cellValueFactory = PropertyValueFactory<TableBean, String>("nazwa")
        kolumnaTyp.cellValueFactory = PropertyValueFactory<TableBean, ComboBox<String>>("typ")
        kolumnaWartoscDomyslna.cellValueFactory = PropertyValueFactory<TableBean, String>("wartoscDomyslna")
        tableView.columns.add(kolumnaNazwa)
        tableView.columns.add(kolumnaTyp)
        tableView.columns.add(kolumnaWartoscDomyslna)

        tableView.prefWidth = 600.0
        tableView.prefHeight = 150.0
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

open class TableBean(val nazwa: String, val typ: ComboBox<String>) {
    var wartoscDomyslna: String? = null;
}