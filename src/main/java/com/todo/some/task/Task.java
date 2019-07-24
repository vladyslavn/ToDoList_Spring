package com.todo.some.task;

public class Task {
    private int id;
    private int parentId;
    private String name = "";
    private Boolean isDone;

    public void changeName(String newName) {
        this.name = newName;
    }

    public void changeIsDone(Boolean newIsDone) {
        this.isDone = newIsDone;
    }

    public String getName() {
        return this.name;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
