package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Constants;
import sample.model.db.AbstractDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToDo {
    private int id;
    private String name;
    private String beschreibung;
    private int status_id;
    private int prioritaet_id;

    public ToDo(int id, String name, String beschreibung, int status_id, int prioritaet_id) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.status_id = status_id;
        this.prioritaet_id = prioritaet_id;
    }

    public static ObservableList<ToDo> getList() {
        ObservableList<ToDo> list = FXCollections.observableArrayList();

        AbstractDatabase conn = Constants.getConn();
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM gr8_ToDo");

            ResultSet results = statement.executeQuery();

            while (results.next()) {
                ToDo tmp = new ToDo(results.getInt("todo_id"), results.getString("name"), results.getString("beschreibung"), results.getInt("status_id"), results.getInt("prioritaet_id"));

                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                ", status_id=" + status_id +
                ", prioritaet_id=" + prioritaet_id +
                '}';
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getPrioritaet_id() {
        return prioritaet_id;
    }

    public void setPrioritaet_id(int prioritaet_id) {
        this.prioritaet_id = prioritaet_id;
    }
}
