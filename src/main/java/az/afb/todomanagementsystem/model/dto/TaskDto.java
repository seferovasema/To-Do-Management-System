package az.afb.todomanagementsystem.model.dto;

import az.afb.todomanagementsystem.enums.TaskStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto {
    String title;
    String description;
    TaskStatus taskStatus;
}
