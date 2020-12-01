package sample;

import sample.model.db.AbstractDatabase;
import sample.model.db.MySQLConnector;

public class Constants {
    public static AbstractDatabase getConn() {
        return new MySQLConnector("d0345764", "5AHEL2021", "rathgeb.at", 3306, "d0345764");
    }
}
