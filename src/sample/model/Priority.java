package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Constants;
import sample.model.db.AbstractDatabase;
import sample.model.db.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Priority {
    private int id;
    private String name;

    public Priority(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public void rename(String name) {
        AbstractDatabase conn = Constants.getConn();

        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("UPDATE `gr8_Prioritaet` SET `name` = '" + name + "' WHERE `gr8_Prioritaet`.`prioritaet_id` = " + this.id + ";");

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem() {
        AbstractDatabase conn = Constants.getConn();

        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("DELETE FROM `gr8_Prioritaet` WHERE `gr8_Prioritaet`.`prioritaet_id` = " + this.id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNew(String name) {
        AbstractDatabase conn = Constants.getConn();

        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("INSERT INTO `gr8_Prioritaet` (`name`) VALUES ('" + name + "')");

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Priority> getList() {
        ObservableList<Priority> list = FXCollections.observableArrayList();

        AbstractDatabase conn = Constants.getConn();
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM gr8_Prioritaet");

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Priority tmp = new Priority(results.getInt("prioritaet_id"), results.getString("name"));

                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
