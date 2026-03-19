package az.afb.todomanagementsystem.model.view;

import az.afb.todomanagementsystem.enums.TaskStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskView {
    Integer id;
    Integer userId;
    String title;
    String description;
    TaskStatus taskStatus;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
