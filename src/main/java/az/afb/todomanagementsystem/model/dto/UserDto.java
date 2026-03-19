package az.afb.todomanagementsystem.model.dto;

import az.afb.todomanagementsystem.enums.UserRole;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    String name;
    String email;
    UserRole userRole;
}
