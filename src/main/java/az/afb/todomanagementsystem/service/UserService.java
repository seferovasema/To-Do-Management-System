package az.afb.todomanagementsystem.service;

import az.afb.todomanagementsystem.model.dto.UserDto;
import az.afb.todomanagementsystem.model.view.UserView;

import java.util.List;

public interface UserService {
  void createUser(UserDto dto);
  UserView findById(Integer id);
  void updateUser(Integer id,UserDto dto);
  void deleteUser(Integer id);
  List<UserView> findAll();
}
