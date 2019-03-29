package app

import javafx.application.Application
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.scene.Scene
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.layout.BorderPane
import javafx.stage.Stage

class TableWithComboBoxExample : Application() {

    override fun start(primaryStage: Stage) {
        val contactTable = TableView<Contact>()
        contactTable.isEditable = true

        val nameCol = TableColumn<Contact, String>("Name")
        nameCol.setCellValueFactory { cellData -> cellData.value.nameProperty() }
        nameCol.cellFactory = TextFieldTableCell.forTableColumn()
        contactTable.columns.add(nameCol)


        val categoryCol = TableColumn<Contact, String>("Category")
        categoryCol.setCellValueFactory { cellData -> cellData.value.categoryProperty() }

        categoryCol.cellFactory = ComboBoxTableCell.forTableColumn("Friends", "Family", "Work Contacts")

        contactTable.columns.add(categoryCol)

        contactTable.items.addAll(
                Contact("Bill Gates", "Work Contacts"),
                Contact("Barack Obama", "Friends"),
                Contact("Tim Cook", "Work Contacts")
        )

        val scene = Scene(BorderPane(contactTable), 600.0, 600.0)
        primaryStage.scene = scene
        primaryStage.show()
    }

    class Contact(name: String, category: String) {
        private val name = SimpleStringProperty()
        private val category = SimpleStringProperty()

        init {
            setName(name)
            setCategory(category)
        }

        fun nameProperty(): StringProperty {
            return this.name
        }


        fun getName(): String {
            return this.nameProperty().get()
        }


        fun setName(name: String) {
            this.nameProperty().set(name)
        }


        fun categoryProperty(): StringProperty {
            return this.category
        }


        fun getCategory(): String {
            return this.categoryProperty().get()
        }


        fun setCategory(category: String) {
            this.categoryProperty().set(category)
        }

    }


}

fun main(args: Array<String>) {
    Application.launch(TableWithComboBoxExample::class.java, *args)
}