package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.model.Status;

public class StatusController {
    public ListView<Status> statusListView;
    public TextField nameTextField;
    public Button add;

    private Status selectedItem = null;

    public void initialize() {
        ObservableList items = Status.getList();
        statusListView.setItems(items);
    }

    public void itemSelected(MouseEvent mouseEvent) {
        Status p = statusListView.getSelectionModel().getSelectedItem();

        if (p != null) {
            nameTextField.setText(p.getName());
            selectedItem = p;
        }
    }

    public void savedClicked(ActionEvent actionEvent) {

    }

    public void newClicked(ActionEvent actionEvent) {

    }

    public void deleteClicked(ActionEvent actionEvent) {

    }

    public void cancelClicked(ActionEvent actionEvent) {

    }
}
