package dev.swanhtet.todolist.Controllers;

import dev.swanhtet.todolist.Models.TaskTarget;
import dev.swanhtet.todolist.Services.TaskTargetServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import java.time.LocalDateTime;

@Controller
public class TaskTargetController {

     private final
    TaskTargetServices taskTargetServices;

    public TaskTargetController(TaskTargetServices taskTargetServices) {
        this.taskTargetServices = taskTargetServices;
    }

    @GetMapping("/tasks")
    public  String renderingTaskTarget(){
        return "TaskTarget";
    }

    @GetMapping("/table")
    public  String TargetTable(Model model){
        model.addAttribute("Targets", taskTargetServices.findAllBy());
        return "TargetTable";
    }

    @PostMapping("/tasksSave")
    public  String SavingTheTask(
            @RequestParam String taskTarget,
            @RequestParam("deadline") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime deadline,
            @RequestParam("short-description") String shortDescription
    ){
        TaskTarget taskTarget1 = new TaskTarget();
        taskTarget1.setTargetName(taskTarget);
        taskTarget1.setDeadLine(deadline);
        taskTarget1.setShortDescription(shortDescription);
        taskTargetServices.SavingToDB(taskTarget1);
        return "redirect:/home";
    }



    @PostMapping("/listTargets")
    public  String listing_task(Model model){
        model.addAttribute("listingOfTarget", taskTargetServices.findAllBy());
        return "TargetTable";
    }

    @PostMapping("/tasksDelete")
    public  String deleteTasks(){
        taskTargetServices.delete();
        return "redirect:/table";
    }
}
