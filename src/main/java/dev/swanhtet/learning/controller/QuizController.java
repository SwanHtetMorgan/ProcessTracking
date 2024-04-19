package dev.swanhtet.learning.controller;

import dev.swanhtet.learning.models.QuestionWrapper;
import dev.swanhtet.learning.models.Response;
import dev.swanhtet.learning.services.QuizServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizServices quizServices;

    @PostMapping("/create")
    public ResponseEntity<String> QuizCreation(@RequestParam String category , @RequestParam int numQ, @RequestParam String title){
        return quizServices.QuizCreation(title,numQ, category);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizServices.getQuizbyId(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getTheResult(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizServices.calculateTheResult(id, responses);
    }
}
