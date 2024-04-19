package dev.swanhtet.todolist.Repositories;

import dev.swanhtet.todolist.Models.ToDoList;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoList, Long> {
  /* @Query(value = "select * from question_for_java q where q.category = :category order by rand() limit :numQ", nativeQuery = true)
      List<QuestionForJava> findRandomQuestion(@Param("category") String category, @Param("numQ") int numQ);
  */
  @Transactional
  @Modifying
  @Query(value = "delete from to_do_list where task_name = :task_name", nativeQuery = true)
  void deleteByName(@Param("task_name") String name);

  @Transactional
  @Modifying
  @Query(
      value =
          "update to_do_list set task_name = :task_name, date_time = :date_time, description ="
              + " :description, task_name = :task_name where  id = :id",
      nativeQuery = true)
  void UpDateFromInput(
      @Param("task_name") String name,
      @Param("date_time") String date_time,
      @Param("description") String description,
      @Param("id") String id,
      @Param("task_name") String taskName);

  @Transactional
  @Modifying
  @Query(value = "alter table to_do_list auto_increment = 1", nativeQuery = true)
  void ResetAutoIncrement();
}
