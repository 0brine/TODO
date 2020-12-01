package sample;


import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.model.Priority;

public class PriorityController {
    public TextField name;
    public Button add;
    public ListView<Priority> list;
    private Priority selectedItem = null;

    public void initialize() {
        list.setItems(Priority.getList());
    }

    public void listClicked(MouseEvent mouseEvent) {
        Priority p = list.getSelectionModel().getSelectedItem();
        if (p != null) {
            name.setText(p.getName());
            selectedItem = p;
        }
    }

    public void addClicked(ActionEvent actionEvent) {

    }

    public void delClicked(ActionEvent actionEvent) {

    }

    public void cancelClicked(ActionEvent actionEvent) {

    }

    public void saveClicked(ActionEvent actionEvent) {

    }
}
