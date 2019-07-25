package com.todo.some.list;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<ListOfTask, Integer> {
}
