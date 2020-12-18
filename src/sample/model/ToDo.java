package sample.model;

import javafx.collections.ObservableList;
import sample.SQLs;

public class ToDo {
    private int id;
    private String name;
    private String description;
    private Status status;
    private Priority priority;

    public ToDo(int id, String name, String description, int status_id, int prioritaet_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = SQLs.getStatus(status_id);
        this.priority = SQLs.getPriority(prioritaet_id);
    }

    public static ObservableList<ToDo> getList() {
        return SQLs.getToDoList();
    }

    public void change(String name, String description, int priorityID, int statusID) {
        SQLs.updateToDo(this.id, name, description, priorityID, statusID);
    }

    public void deleteItem() {
        SQLs.deleteToDo(this.id);
    }

    public static void createNew(String name, String description, int priorityID, int statusID) {
        SQLs.insertToDo(name, description, priorityID, statusID);
    }

    @Override
    public String toString() {
        return name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
