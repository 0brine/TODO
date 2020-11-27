package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.model.Priority;
import sample.model.Status;

public class StatusController<s> {

    public TextField nameTextField;
    public ListView<Status> statusListView;
    public Status selectedItem = null;

    public void initialize() {
        statusListView.setItems(Status.getList());
    }

    public void itemSelected(MouseEvent mouseEvent) {
        Status s = statusListView.getSelectionModel().getSelectedItem();
        if (s != null) {
            nameTextField.setText(s.getName());
            selectedItem = s;
        }
    }


    public void savedClicked(ActionEvent actionEvent) {
        if (selectedItem != null) {
            //update existing item
        } else {
            //insert new
        }
    }

    public void cancelClicked(ActionEvent actionEvent) {
        //close dialog
    }

    public void deleteClicked(ActionEvent actionEvent) {
        if (selectedItem != null){
            //delete Item
        }
    }

    public void newClicked(ActionEvent actionEvent) {
        selectedItem = null;
        nameTextField.clear();
        statusListView.setFocusModel(null);
    }

}
