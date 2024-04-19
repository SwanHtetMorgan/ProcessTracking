package dev.swanhtet.todolist.Services;


import dev.swanhtet.todolist.Models.TaskTarget;
import dev.swanhtet.todolist.Repositories.TaskTargetRepository;
import dev.swanhtet.todolist.Repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskTargetServices {
    @Autowired
    private TaskTargetRepository taskTargetRepository;

    public List<TaskTarget> findAllBy() {
        return taskTargetRepository.findAll();
    }

    public void SavingToDB(TaskTarget taskTarget1) {
        taskTargetRepository.save(taskTarget1);
    }

    public void delete() {
        taskTargetRepository.deleteAll();
    }
}
