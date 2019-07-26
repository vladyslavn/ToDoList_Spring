package com.todo.some.task;

import com.todo.some.list.ListOfTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByListId(int id);

}
