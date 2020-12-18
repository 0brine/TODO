package sample.model;

import javafx.collections.ObservableList;
import sample.SQLs;

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
        SQLs.updatePriority(this.id, name);
    }

    public void deleteItem() {
        SQLs.deletePriority(this.id);
    }

    public static void createNew(String name) {
        SQLs.insertPriority(name);
    }

    public static ObservableList<Priority> getList() {
        return SQLs.getPriorityList();
    }
}
