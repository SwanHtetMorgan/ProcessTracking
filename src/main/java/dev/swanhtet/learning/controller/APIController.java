package dev.swanhtet.learning.controller;

import dev.swanhtet.learning.models.QuestionForJava;
import dev.swanhtet.learning.services.QuestionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
public class APIController {

    @Autowired
    QuestionServices questionServices;
    @GetMapping("/app")
    public String Hello(@RequestParam(value = "name", defaultValue = "WOlrd") String name){
        return STR."Hello \{name}";
    }


    @GetMapping("/Questions")
    public ResponseEntity<List<QuestionForJava>> getAllQuestion(){
        return questionServices.getAllQuestions();
    }

    @GetMapping("/Questions/{category}")
    public ResponseEntity<List<QuestionForJava>> getAllQuestionByCategory(@PathVariable String category){
        return questionServices.getAllQuestionByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> Addition(@RequestBody QuestionForJava questionForJava){ return  questionServices.addTheQuestion(questionForJava);}

    @DeleteMapping("/delete")
    public ResponseEntity<String> Deletion(@RequestBody QuestionForJava questionForJava)
    {
            // Call the service method to delete the question
            return questionServices.deleteTheQuestion(questionForJava);

    }
    // APIController class
/*    @DeleteMapping("/delete/{category}")
    public String DeletionByCategory(@PathVariable String category) {
        try {
            return questionServices.deleteQuestionsByCategory(category);
        } catch (Exception e) {
            return STR."Failed to delete questions for category: \{category}. Error: \{e.getMessage()}";
        }
    }*/


}
