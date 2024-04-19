package dev.swanhtet.learning.services;

import dev.swanhtet.learning.dao.QuestionDAO;
import dev.swanhtet.learning.dao.QuizDAQ;
import dev.swanhtet.learning.models.QuestionForJava;
import dev.swanhtet.learning.models.QuestionWrapper;
import dev.swanhtet.learning.models.Quiz;
import dev.swanhtet.learning.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServices {

    @Autowired
    QuizDAQ quizDAQ; // Assuming this is your repository for Quiz entity

    @Autowired
    private QuestionDAO questionDAO;

    public ResponseEntity<String> QuizCreation(String title, int NumQ, String category) {
        try {
            List<QuestionForJava> questionForJava = questionDAO.findRandomQuestion(category, NumQ);

            if (questionForJava.isEmpty()) {
                return new ResponseEntity<>("No questions found for the given category.", HttpStatus.NOT_FOUND);
            }

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questionForJava);
            quizDAQ.save(quiz);

            return new ResponseEntity<>("Quiz creation completed.", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging purposes
            return new ResponseEntity<>("Failed to create quiz. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //DONE We don't want to use show all of the data in the Question data,
    //Just wanna show the question option and title;
    //Not the right answer;
    //So we have to make the proxy wrapper to maintain the desired data;
    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(Integer id) {
        Optional<Quiz> quiz = quizDAQ.findById(id);
        List<QuestionForJava> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> QuestionForUser = new ArrayList<>();
        for(QuestionForJava question : questionsFromDB){
            QuestionWrapper  questionWrapper = new QuestionWrapper(question.getId(), question.getQuestion(), question.getOption1(),question.getOption2(),question.getOption3());
            QuestionForUser.add(questionWrapper);
        }
        return new ResponseEntity<>(QuestionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateTheResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDAQ.findById(id).get();
        List<QuestionForJava> questionForJavas = quiz.getQuestions();
        int sum = 0;
        int i = 0;
        for (Response response : responses) {
            System.out.println(response.getResponse());
            // Check if response or getResponse() is null before calling equals()
            if (response.getResponse().equals(questionForJavas.get(i).getRightAns())) {
                sum += 1;
                System.out.println("Equal");
            }
            i++;
        }

        return new ResponseEntity<>(sum, HttpStatus.OK);
    }

}
