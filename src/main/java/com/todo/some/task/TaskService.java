package com.todo.some.task;

import com.todo.some.list.ListRepository;

public class TaskService {

    private TaskRepository taskRepository;
    private ListRepository listRepository;

    public TaskService(TaskRepository taskRepository, ListRepository listRepository) {
        this.taskRepository = taskRepository;
        this.listRepository = listRepository;
    }

    private Task fromTaskDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setParentId(taskDto.getListId());
        task.setName(taskDto.getName());
        task.setDone(taskDto.isDone());
        return task;
    }

    private TaskDto fromTaskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setListId(task.getParentId());
        taskDto.setName(task.getName());
        taskDto.setDone(task.getDone());
        return taskDto;
    }
}
