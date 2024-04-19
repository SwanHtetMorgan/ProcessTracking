package dev.swanhtet.todolist.Controllers;

import dev.swanhtet.todolist.Models.EmailRequest;
import dev.swanhtet.todolist.Services.EmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmailController {

  private final EmailServices emailService;

  @Autowired
  public EmailController(EmailServices emailService) {
    this.emailService = emailService;
  }

  @PostMapping("/sendEmail")
  public String sendEmail(@RequestParam("recipient") String recipient,
                        @RequestParam("subject") String subject,
                        @RequestParam("message") String message
                        ) {
    emailService.MailSendingFunction(recipient, subject, message);
    return "redirect:/addition";
  }
}
