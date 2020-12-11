package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.Priority;
import sample.model.Status;
import sample.model.db.AbstractDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLs {
    private static AbstractDatabase conn;

    static {
        conn = Constants.getConn();
    }

    // --------- Status ---------

    public static Status getStatus(int id) {
        Status result = null;
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM gr8_Status WHERE status_id = " + id);
            ResultSet results = statement.executeQuery();

            results.next();
            result = new Status(results.getInt("status_id"), results.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Status> getStatusList() {
        ObservableList<Status> result = FXCollections.observableArrayList();

        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT  * FROM gr8_Status");

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                Status tmp = new Status(results.getInt("Status_id"), results.getString("name"));

                result.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void updateStatus(String newName, int id) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("UPDATE `gr8_Status` SET `name` = '" + newName + "' WHERE `gr8_Status`.`status_id` = " + id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStatus(int id) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("DELETE FROM `gr8_Status` WHERE `gr8_Status`.`status_id` = " + id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertStatus(String name) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("INSERT INTO `gr8_Status` (`name`) VALUES ('" + name + "')");

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // --------- Priority ---------

    public static Priority getPriority(int id) {
        Priority result = null;
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM gr8_Prioritaet WHERE prioritaet_id = " + id);
            ResultSet results = statement.executeQuery();

            results.next();
            result = new Priority(results.getInt("prioritaet_id"), results.getString("name"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static ObservableList<Priority> getPriorityList() {
        ObservableList<Priority> list = FXCollections.observableArrayList();

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

    public static void updatePriority(String name, int id) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("UPDATE `gr8_Prioritaet` SET `name` = '" + name + "' WHERE `gr8_Prioritaet`.`prioritaet_id` = " + id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePriority(int id) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("DELETE FROM `gr8_Prioritaet` WHERE `gr8_Prioritaet`.`prioritaet_id` = " + id);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertPriority(String name) {
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("INSERT INTO `gr8_Prioritaet` (`name`) VALUES ('" + name + "')");

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
