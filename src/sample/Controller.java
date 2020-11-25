package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    public void onStatusClicked(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Status.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage s = new Stage();

        s.setTitle("Status");
        s.setScene(new Scene(root));
        s.show();
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
}
