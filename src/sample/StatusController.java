package sample;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.model.Status;

public class StatusController<s> {

    public TextField nameTextField;
    public ListView<Status> statusListView;
    public Button add;

    public void initialize() {
        statusListView.setItems(Status.getList());
        Status s = statusListView.getSelectionModel().getSelectedItem();
        if (s != null) {
            nameTextField.setText(s.getName());
        }
    }

    public void itemSelected(MouseEvent mouseEvent) {

    }

}
