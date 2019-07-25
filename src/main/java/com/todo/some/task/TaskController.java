package com.todo.some.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();

    @GetMapping("{parentId}")
    public List<Task> getTasksByListId(@PathVariable int parentId) {
        List<Task> ts = new ArrayList<>();

        for (int i = 0; i < tasks.size(); i++) {
            if (this.tasks.get(i).getParentId() == parentId) {
                ts.add(this.tasks.get(i));
            }
        }
        return ts;
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable int id) {
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getId() == id) {
                this.tasks.remove(this.tasks.get(i));
            }
        }
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        tasks.add(task);
        return task;
    }

    @PutMapping("{id}")
    public void putTask (@PathVariable int id, @RequestBody Task task) {
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getId() == id) {
                this.tasks.set(i, task);
                break;
            }
        }
    }
}
