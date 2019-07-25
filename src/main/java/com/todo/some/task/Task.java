package com.todo.some.task;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column
    private int parentId;

    @Column
    private String name;

    @Column
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

}
