package com.todo.some.task;

import com.todo.some.list.ListRepository;

public class TaskService {

    private TaskRepository taskRepository;
    private ListRepository listRepository;

    public TaskService(TaskRepository taskRepository, ListRepository listRepository) {
        this.taskRepository = taskRepository;
        this.listRepository = listRepository;
    }


}
