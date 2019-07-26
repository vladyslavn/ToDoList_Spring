package com.todo.some.task;

import com.todo.some.list.ListOfTask;
import com.todo.some.list.ListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private ListRepository listRepository;

    public TaskService(TaskRepository taskRepository, ListRepository listRepository) {
        this.taskRepository = taskRepository;
        this.listRepository = listRepository;
    }

    public List<TaskDto> getTasksDtoByListId(int listId) {
        return this.taskRepository.findByListId(listId)
                .stream()
                .map(this :: fromTaskToTaskDto)
                .collect(Collectors.toList());
    }

    public void deleteTaskById(int id) {
        this.taskRepository.deleteById(id);
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = fromTaskDtoToTask(taskDto);
        this.taskRepository.save(task);
        taskDto = fromTaskToTaskDto(task);
        return taskDto;

    }

    public void updateTask(TaskDto taskDto) {
        this.taskRepository.save(fromTaskDtoToTask(taskDto));
    }

    private Task fromTaskDtoToTask(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        ListOfTask list = listRepository.findById(taskDto.getListId())
                .orElse(new ListOfTask());
        task.setList(list);
        task.setName(taskDto.getName());
        task.setDone(taskDto.isDone());
        return task;
    }

    private TaskDto fromTaskToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setListId(task.getList().getId());
        taskDto.setName(task.getName());
        taskDto.setDone(task.getDone());
        return taskDto;
    }
}
