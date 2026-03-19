package az.afb.todomanagementsystem.service.impl;

import az.afb.todomanagementsystem.mapper.UserMapper;
import az.afb.todomanagementsystem.model.dto.UserDto;
import az.afb.todomanagementsystem.model.view.UserView;
import az.afb.todomanagementsystem.repository.UserRepository;
import az.afb.todomanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private  final UserMapper userMapper;
    @Override
    public void createUser(UserDto dto) {
    var user=userMapper.mapToEntity(dto);
    userRepository.save(user);
    }

    @Override
    public UserView findById(Integer id) {
        var user=userRepository.findById(id).get();
        return userMapper.mapToView(user);
    }

    @Override
    public void updateUser(Integer id, UserDto dto) {
    var user=userRepository
            .findById(id)
            .orElseThrow(()->new IllegalArgumentException("User not found"));
        BeanUtils.copyProperties(dto,user);
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
     userRepository.findById(id).ifPresent(userRepository::delete);
    }

    @Override
    public List<UserView> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::mapToView)
                .toList();
    }
}
