package com.todo.some.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("{listId}")
    public List<TaskDto> getTasksByListId(@PathVariable int listId) {
        return this.taskService.getTasksDtoByListId(listId);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable int id) {
        this.taskService.deleteTaskById(id);
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        taskDto = this.taskService.createTask(taskDto);
        return taskDto;
    }

    @PutMapping
    public void putTask(@RequestBody TaskDto taskDto) {
        this.taskService.updateTask(taskDto);
    }
}
