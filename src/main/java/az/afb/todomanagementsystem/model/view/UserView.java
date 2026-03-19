package az.afb.todomanagementsystem.model.view;

import az.afb.todomanagementsystem.enums.UserRole;
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
public class UserView {
    Integer id;
    String name;
    String email;
    UserRole userRole;
    LocalDateTime createdAt;
}
