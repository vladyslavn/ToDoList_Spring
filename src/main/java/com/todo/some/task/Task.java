package com.todo.some.task;

import com.todo.some.list.ListOfTask;

import javax.persistence.*;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "list")
    private ListOfTask list;

    @Column
    private String name;

    @Column
    private Boolean done;


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


    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public ListOfTask getList() {
        return list;
    }

    public void setList(ListOfTask list) {
        this.list = list;
    }
}
