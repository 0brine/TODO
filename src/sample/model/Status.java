package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Constants;
import sample.SQLs;
import sample.model.db.AbstractDatabase;
import sample.model.db.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Status {

    private int id;
    private String name;


    public Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public static ObservableList<Status> getList(){
        return SQLs.getStatusList();
    }

    public void rename(String name) {
        SQLs.updateStatus(name, this.id);
    }

    public void deleteItem() {
        SQLs.deleteStatus(this.id);
    }

    public static void createNew(String name) {
        SQLs.insertStatus(name);
    }


}