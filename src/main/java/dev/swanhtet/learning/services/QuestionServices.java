package dev.swanhtet.learning.services;

import dev.swanhtet.learning.dao.QuestionDAO;
import dev.swanhtet.learning.models.QuestionForJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServices {
    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<QuestionForJava>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_GATEWAY);
        }
    }

    public ResponseEntity<List<QuestionForJava>> getAllQuestionByCategory(String category){
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        }catch (Exception ec){
            return  new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public  ResponseEntity<String> addTheQuestion(QuestionForJava questionForJava){
        try {
            questionDAO.save(questionForJava);
            return new ResponseEntity<>("Question Added Successfully", HttpStatus.OK);
        }catch (Exception e){
          return new ResponseEntity<>("Addition Failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //return "Successful in Addition";
    }

    public  ResponseEntity<String> deleteTheQuestion(QuestionForJava questionForJava){
        try {
            questionDAO.delete(questionForJava);
            return  new ResponseEntity<>("Deleted in the server", HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed to deleted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // QuestionServices class
 /*   public String deleteQuestionsByCategory(String category) {
        String deleteResult = questionDAO.deleteByCategory(category);
        return STR."Deleted \{deleteResult} questions in the Server";
    }*/
}
