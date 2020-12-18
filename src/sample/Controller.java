package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.model.Priority;
import sample.model.Status;
import sample.model.ToDo;

import java.io.IOException;

public class Controller {
    public ComboBox<Status> statusComBox;
    public ComboBox<Priority> priorityComBox;
    public ListView<ToDo> toDoList;

    public TextField toDoTextField;
    public AnchorPane contentPane;

    private ToDoController ToDocontroller;

    public void initialize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ToDo.fxml"));
        Pane todoPane = null;
        try {
            todoPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ToDocontroller = loader.getController();
        contentPane.getChildren().add(todoPane);

        refreshList();
        refreshPriority();
        refreshStatus();
        selectNone();
    }

    public void refreshStatus() {
        statusComBox.setItems(Status.getList());
    }

    public void refreshPriority() {
        priorityComBox.setItems(Priority.getList());
    }

    public void refreshList() {
        toDoList.setItems(ToDo.getList());
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
        ToDo selectedItem = toDoList.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            openToDo(selectedItem);
        }
    }

    public void selectNone() {
        toDoList.getSelectionModel().clearSelection();
        contentPane.setVisible(false);
        refreshList();
    }

    public void acAdd(ActionEvent actionEvent) {
        toDoList.getSelectionModel().clearSelection();
        contentPane.setVisible(false);
        refreshList();


    }

    private void openToDo(ToDo selectedItem) {
        ToDocontroller.setSelectedItem(selectedItem);
        ToDocontroller.setParent(this);

        contentPane.setVisible(true);
    }
}