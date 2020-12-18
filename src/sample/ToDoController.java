package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.model.Priority;
import sample.model.Status;
import sample.model.ToDo;

public class ToDoController {
    public TextField tfName;
    public TextArea taDescription;
    public ComboBox<Status> cbStatus;
    public ComboBox<Priority> cbPriority;
    private ToDo selectedItem;
    private Controller parent;

    public void initialize() {
        displayItem();
    }

    public void setParent(Controller parent) {
        this.parent = parent;
    }

    public void setSelectedItem(ToDo item) {
        selectedItem = item;
        displayItem();
    }

    private void displayItem() {
        if (selectedItem != null) {
            tfName.setText(selectedItem.getName());

            taDescription.setText(selectedItem.getDescription());

            cbStatus.setItems(Status.getList());
            cbStatus.getSelectionModel().select(selectedItem.getStatus());

            cbPriority.setItems(Priority.getList());
            cbPriority.getSelectionModel().select(selectedItem.getPriority());
        }
    }

    public void buSave(ActionEvent actionEvent) {
        if (selectedItem != null)
            selectedItem.change(tfName.getText(), taDescription.getText(), cbPriority.getValue().getId(), cbStatus.getValue().getId());
        else
            ToDo.createNew(tfName.getText(), taDescription.getText(), cbPriority.getValue().getId(), cbStatus.getValue().getId());
        parent.refreshList();
        parent.selectNone();
    }

    public void buCancel(ActionEvent actionEvent) {
        parent.selectNone();
    }
}
