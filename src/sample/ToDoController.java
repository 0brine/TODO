package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.Priority;
import sample.model.Status;
import sample.model.ToDo;

public class ToDoController {
    public TextField tfName;
    public TextArea taDescription;
    public ComboBox cbStatus;
    public ComboBox cbPriority;
    private ToDo selectedItem;
    private ObservableList<ToDo> todoList;

    public void initialize() {
        displayItem();
    }

    public void setSelectedItem(ToDo item) {
        selectedItem = item;
    }

    private void displayItem() {
        if (selectedItem != null) {
            tfName.setText(selectedItem.getName());
            taDescription.setText(selectedItem.getBeschreibung());
            cbStatus.setItems(Status.getList());
            cbStatus.getSelectionModel().select(selectedItem.getStatus());
            cbPriority.setItems(Priority.getList());
            cbPriority.getSelectionModel().select(selectedItem.getPriority());

        }

    }

    public void setToDoList(ObservableList<ToDo> list) {
        this.todoList = list;
    }
}
