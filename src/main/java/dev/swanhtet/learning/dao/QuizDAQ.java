package dev.swanhtet.learning.dao;

import dev.swanhtet.learning.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDAQ extends JpaRepository<Quiz, Integer> {


}
