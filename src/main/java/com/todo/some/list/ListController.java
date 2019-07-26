package com.todo.some.list;

import com.todo.some.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("lists")
public class ListController {

    private final ListRepository listRepository;

    @Autowired
    public ListController(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @GetMapping
    public List<ListOfTask> getLists() {
        return listRepository.findAll();
    }

    @PostMapping
    public ListOfTask createList(@RequestBody ListOfTask list) {
        listRepository.save(list);
        return list;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable int id) {
        listRepository.deleteById(id);
    }
}

