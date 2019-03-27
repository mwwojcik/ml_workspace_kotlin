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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import uslugi.RegulyUslugaBean



@Controller
class MainController {

    @Autowired
    lateinit var reguly: RegulyUslugaBean

    @Value("\${my.url}")
    private val myUrl: String? = null

    @FXML
    lateinit var panelRegul: VBox

    @FXML
    private fun initialize() {

        for (i in 0..5) {
            panelRegul.children.add(TextField("Hello world!"))
            var kolumnaTyp: TableColumn<TableBean, ComboBox<String>> = TableColumn("Hello")
            var kolumnaNazwa: TableColumn<TableBean, String> = TableColumn("Hello")

            var list: ObservableList<TableBean> = FXCollections.observableArrayList()
            list.add(TableBean("param", zbudujCombo()))
            list.add(TableBean("param1", zbudujCombo()))
            list.add(TableBean("param2", zbudujCombo()))
            list.add(TableBean("param3", zbudujCombo()))

            var tableView: TableView<TableBean> = TableView()
            tableView.items = list
            panelRegul.children.add(tableView)

            kolumnaNazwa.cellValueFactory = PropertyValueFactory<TableBean, String>("nazwa")
            kolumnaTyp.cellValueFactory = PropertyValueFactory<TableBean, ComboBox<String>>("typ")
            tableView.columns.add(kolumnaNazwa)
            tableView.columns.add(kolumnaTyp)
            panelRegul.spacing = 5.0
            tableView.resize(300.0,50.0)

        }
    }

    fun zbudujCombo():ComboBox<String>{
        var typCombo:ComboBox<String> = ComboBox<String>()
        typCombo.items.add("Liczba")
        typCombo.items.add("Napis")
        typCombo.items.add("Data")
        return typCombo;
    }


    @FXML
    fun onWczytajRegulyKLIK(){
        println(myUrl)

    }

    @FXML
    fun onWalidujRegulyKLIK(){
        println(myUrl)

    }

    @FXML
    fun onZapiszRegulyKLIK(){
        println(myUrl)

    }

    @FXML
    fun onGenerujKodKLIK(){
        println(myUrl)

    }
}

open class TableBean(val nazwa:String,val typ: ComboBox<String>){
    var wartoscDomyslna:String?=null;
}