package dev.swanhtet.learning.dao;

import dev.swanhtet.learning.models.QuestionForJava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface QuestionDAO extends JpaRepository<QuestionForJava,Integer> {
    List<QuestionForJava> findByCategory(String category);
    String deleteByCategory(String category);

    //DONE Error was here and related tp QUery
    @Query(value = "select * from question_for_java q where q.category = :category order by rand() limit :numQ", nativeQuery = true)
    List<QuestionForJava> findRandomQuestion(@Param("category") String category, @Param("numQ") int numQ);



}
