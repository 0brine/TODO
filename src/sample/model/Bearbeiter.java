package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.model.db.AbstractDatabase;
import sample.model.db.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bearbeiter {

    private int bearbeiter_id;
    private String name;
    private String strasse;
    private int plz;
    private String ort;

    public Bearbeiter(int bearbeiter_id, String name, String strasse, int plz, String ort) {
        this.bearbeiter_id = bearbeiter_id;
        this.name = name;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
    }

    public int getBearbeiter_id() {
        return bearbeiter_id;
    }

    public void setBearbeiter_id(int bearbeiter_id) {
        this.bearbeiter_id = bearbeiter_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }
    public static ObservableList<Bearbeiter> getList(){
        ObservableList<Bearbeiter> list = FXCollections.observableArrayList();

        AbstractDatabase conn = new MySQLConnector("d0345762","5AHEL2021","rathgeb.at",3306,"d0345762");
        try {
            PreparedStatement statement = conn.getConnection().prepareStatement("SELECT * FROM gr3_Bearbeiter");

            ResultSet results = statement.executeQuery();

            while (results.next()){
                Bearbeiter tmp = new Bearbeiter(results.getInt("bearbeiter_id"),results.getString("name"),results.getString("strasse"),results.getInt("plz"),results.getString("ort"));

                list.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
