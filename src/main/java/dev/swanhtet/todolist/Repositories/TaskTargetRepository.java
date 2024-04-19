package dev.swanhtet.todolist.Repositories;

import dev.swanhtet.todolist.Models.TaskTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskTargetRepository extends JpaRepository<TaskTarget, Long> {
}
