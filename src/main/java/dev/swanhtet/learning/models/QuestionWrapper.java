package dev.swanhtet.learning.models;

import lombok.Data;


@Data
public class QuestionWrapper {

    private long id;
    private  String Question;
    private String Option1;
    private String Option2;
    private String Option3;

    public QuestionWrapper(long id, String question, String option1, String option2, String option3) {
        this.id = id;
        Question = question;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
    }
}
