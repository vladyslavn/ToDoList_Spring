package com.todo.some.list;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("tasks")
public class ListController {

    int counter = 1;
    List<ListOfTask> lists = new ArrayList<>();

    @PostMapping
    public ListOfTask createList(@RequestBody ListOfTask list) {
        if (list.getId() == 0) {
            list.setId(counter++);
        }
        this.lists.add(list);
        return list;
    }

    @DeleteMapping("{id}")
    public void deleteList(@PathVariable String id) {

        for (int i = 0; i < this.lists.size(); i++) {
            if (Integer.parseInt(id) == this.lists.get(i).getId()) {
                this.lists.remove(this.lists.get(i));
            }
        }
    }

}

