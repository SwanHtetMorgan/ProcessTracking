package dev.swanhtet.todolist.Controllers;

import dev.swanhtet.todolist.Models.ToDoList;
import dev.swanhtet.todolist.Services.ToDoServices;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CRUDController {

  private final ToDoServices toDoServices;

  @Autowired
  public CRUDController(ToDoServices toDoServices) {
    this.toDoServices = toDoServices;
  }

  @PostMapping("/add")
  public String addToDoList(
      @RequestParam("employeeName") String employee,
      @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime date,
      @RequestParam("description") String description,
      @RequestParam("task") String task) {
    ToDoList toDoList = new ToDoList();
    toDoList.setDeveloperName(employee);
    toDoList.setDateTime(date);
    toDoList.setDescription(description);
    toDoList.setWorkId(UUID.randomUUID().toString());
    toDoList.setTaskName(task);
    toDoServices.addition(toDoList);
    return "redirect:/home"; // Redirect to the addition page after adding the task
  }

  @GetMapping("/addition")
  public String showAddition(Model model) {
    model.addAttribute("todoList", toDoServices.findAll());
    return "addition";
  }

  @PostMapping("/delete")
  public String deleteFromDB(@RequestParam String taskName) {
    toDoServices.deleteByName(taskName);
    return "redirect:/addition";
  }

  @PostMapping("/deleteAll")
  public String deleteAllFromDB() {
    toDoServices.deleteAll();
    return "redirect:/addition";
  }

  @GetMapping("/deleteTask/{taskId}")
  public String deleteTaskCard(@PathVariable long taskId) {
    toDoServices.deleteById(taskId);
    return "redirect:/addition";
  }
}
