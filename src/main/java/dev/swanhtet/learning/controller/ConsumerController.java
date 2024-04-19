package dev.swanhtet.learning.controller;

import dev.swanhtet.learning.models.Consumer;
import dev.swanhtet.learning.models.LoginForm;
import dev.swanhtet.learning.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// AuthController.java

@Controller
@RequestMapping("/api")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    private Consumer consumer;
    @GetMapping("/adduser")
    public  String ConsumerRandering(){
        return "Consumer";
    }
    @PostMapping("/adduser")
    public ResponseEntity<String> loginUser(@RequestBody LoginForm loginForm) {
        // Retrieve username and password from the LoginForm object
        consumer.setConsumerName(loginForm.getUserName());
        consumer.setPassword(loginForm.getPassword());

        // Call the service method to process login logic and save data
        consumerService.SaveConsumer(consumer);

        // Return a success response
        return ResponseEntity.ok("Login successful");
    }
}

