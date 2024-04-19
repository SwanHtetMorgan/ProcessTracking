package dev.swanhtet.todolist.Controllers;

import dev.swanhtet.todolist.Services.ToDoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private ToDoServices toDoServices;

  @Autowired
  public HomeController(ToDoServices toDoServices) {
    this.toDoServices = toDoServices;
  }

  @GetMapping(value = {"/", "/home"})
  public String renderHomePage() {
    return "home";
  }
}
