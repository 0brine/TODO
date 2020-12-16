package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.model.Priority;
import sample.model.Status;
import sample.model.ToDo;

import java.io.IOException;

public class Controller {
    public ComboBox<Status> statusComBox;
    public ComboBox<Priority> priorityComBox;
    public ListView<ToDo> todoList;

    public TextField toDoTextField;
    public Pane contentPane;

    public void initialize() {
        refreshList();
        refreshPriority();
        refreshStatus();
    }

    private void refreshStatus() {
        statusComBox.setItems(Status.getList());
    }

    private void refreshPriority() {
        priorityComBox.setItems(Priority.getList());
    }

    private void refreshList() {
        todoList.setItems(ToDo.getList());
    }


    public void onStatusClicked(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Status.fxml"));
            Stage s = new Stage();

            s.setTitle("Status");
            s.setScene(new Scene(root));
            s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onPriorityClicked(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Priority.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = new Stage();

        s.setTitle("Priority");
        s.setScene(new Scene(root));
        s.show();
    }

    public void toDoListClicked(MouseEvent mouseEvent) {
        ToDo selectedItem = todoList.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDo.fxml"));
                Pane todoPane = loader.load();

                ToDoController controller = loader.getController();
                controller.setSelectedItem(selectedItem);

                controller.setToDoList(todoList.getItems());

                contentPane.getChildren().add(todoPane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

