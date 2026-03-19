package az.afb.todomanagementsystem.mapper;


import az.afb.todomanagementsystem.entity.User;
import az.afb.todomanagementsystem.model.dto.UserDto;
import az.afb.todomanagementsystem.model.view.UserView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserView mapToView(User user);
    User mapToEntity(UserDto dto);

}
