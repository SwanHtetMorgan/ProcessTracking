package dev.swanhtet.learning.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class QuestionForJava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String Question;
    private String Option1;
    private String Option2;
    private String Option3;
    private String rightAns;
    private String category;

    public QuestionForJava(String question, String option1, String option2, String option3, String rightAns, String category) {
        Question = question;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        this.rightAns = rightAns;
        this.category = category;
    }

    // DONE For the Hibernate
    public QuestionForJava() {

    }
}

