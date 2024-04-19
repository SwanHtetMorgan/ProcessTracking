package dev.swanhtet.learning.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String title;
    private  int  numQ;

    @ManyToMany
    private List<QuestionForJava> Questions;

    public Quiz() {
    }
}
