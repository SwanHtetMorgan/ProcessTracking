package dev.swanhtet.todolist.Controllers;

import dev.swanhtet.todolist.Models.ToDoList;
import dev.swanhtet.todolist.Services.ToDoServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GetDataController {
  private final ToDoServices toDoServices;

  public GetDataController(ToDoServices toDoServices) {
    this.toDoServices = toDoServices;
  }

  @GetMapping("/GetUserExistingData/{taskId}")
  public String GettingData(Model model, @PathVariable long taskId) {
    ToDoList toDoList = toDoServices.findById(taskId);
    model.addAttribute("userData", toDoList);
    return "GetUserExistingData";
  }

  @PostMapping("/GetUserExistingDataUpdate/{taskId}")
  public String UpDatingTheUserData(
      @RequestParam("taskName") String developerName,
      @RequestParam String dateTime,
      @RequestParam String description,
      @PathVariable String taskId,
      @RequestParam("task") String task) {
    long id = Integer.parseInt(taskId);

    toDoServices.update(developerName, dateTime, description, taskId, task);
    return "redirect:/addition";
  }
}
