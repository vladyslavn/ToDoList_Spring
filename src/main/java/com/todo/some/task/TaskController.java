package com.todo.some.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("{parentId}")
    public List<Task> getTasksByListId(@PathVariable int parentId) {
        return taskRepository.findByParentId(parentId);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable int id) {
        taskRepository.deleteById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        taskRepository.save(task);
        return task;
    }

    @PutMapping
    public void putTask(@RequestBody Task task) {
        taskRepository.save(task);
    }
}
