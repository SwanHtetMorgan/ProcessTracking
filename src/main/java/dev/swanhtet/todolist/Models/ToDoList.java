package dev.swanhtet.todolist.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
public class ToDoList implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotBlank private String DeveloperName;

  private String taskName;

  @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // Format pattern for parsing date-time string
  private LocalDateTime dateTime;

  private String Description;

  // AutoGenerate By the WorkId
  private String workId;
}
