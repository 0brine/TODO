package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import sample.model.Priority;
import sample.model.db.AbstractDatabase;

public class PriorityController {

    public TextField nameTextField;
    public ListView<Priority> priorityListView;
    public Priority selectedItem = null;
    public AnchorPane ap;

    public void initialize() {
        refreshList();
    }

    private void refreshList() {
        priorityListView.setItems(Priority.getList());
    }

    public void itemSelected(MouseEvent mouseEvent) {
        Priority p = priorityListView.getSelectionModel().getSelectedItem();

        if (p != null) {
            nameTextField.setText(p.getName());
            selectedItem = p;
        }
    }


    public void savedClicked(ActionEvent actionEvent) {
        String name = nameTextField.getText();

        if (selectedItem != null) {
            selectedItem.rename(name);
        } else {
            selectedItem.createNew(name);
        }

        refreshList();
    }

    public void cancelClicked(ActionEvent actionEvent) {
        //close
    }

    public void deleteClicked(ActionEvent actionEvent) {

        if (selectedItem != null){
            selectedItem.deleteItem();
        }

        refreshList();
    }

    public void newClicked(ActionEvent actionEvent) {
        nameTextField.clear();
        priorityListView.getSelectionModel().clearSelection();
        selectedItem = null;
    }
}