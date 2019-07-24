package com.todo.some.task;

import com.todo.some.exeptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("tasks")
public class TaskController {

    private int counter = 1;
    private List<Task> tasks = new ArrayList<Task>() {{
        add(generateTask());
        add(generateTask());
        add(generateTask());
    }};

    private Task generateTask() {
        Task a = new Task();
        a.setId(counter++);
        a.setParentId(1);
        a.changeIsDone(false);
        a.changeName("message" + (counter - 1));
        return a;
    }

    @GetMapping("{id}")
    public Task getTaskById(@PathVariable int id) {
        System.out.println(id);
        System.out.println(this.tasks.get(0).getId());
        return this.tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(NotFoundException :: new);
    }

    @DeleteMapping("{task}")
    public void deleteTask(@PathVariable Task task) {
        this.tasks.remove(task);
    }

    @PostMapping("{task}")
    public Task createTask(@PathVariable Task task) {
        task.setId(counter++);
        tasks.add(task);
        return task;
    }

    @PutMapping("{task}")
    public void putTask (@PathVariable Task task) {
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getId() == task.getId()) {
                this.tasks.set(i, task);
                break;
            }
        }
    }
}
