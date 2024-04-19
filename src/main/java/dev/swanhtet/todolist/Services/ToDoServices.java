package dev.swanhtet.todolist.Services;

import dev.swanhtet.todolist.Models.ToDoList;
import dev.swanhtet.todolist.Repositories.ToDoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServices {
  private final ToDoRepository toDoRepository;

  @Autowired
  public ToDoServices(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public void addition(ToDoList toDoList) {
    toDoRepository.save(toDoList);
  }

  public ToDoList findById(long id) {
    return toDoRepository.findById(id).orElse(null);
  }

  public List<ToDoList> findAll() {
    return toDoRepository.findAll();
  }

  public void deleteAll() {
    toDoRepository.deleteAll();
  }

  public void deleteByName(String name) {
    toDoRepository.deleteByName(name);
  }

  @Transactional
  public void update(String name, String dateTime, String description, String id, String task) {
    toDoRepository.UpDateFromInput(name, dateTime, description, id, task);
  }

  public void deleteById(long taskId) {
    toDoRepository.deleteById(taskId);
  }
}
