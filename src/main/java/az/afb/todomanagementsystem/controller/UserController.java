package az.afb.todomanagementsystem.controller;

import az.afb.todomanagementsystem.entity.User;
import az.afb.todomanagementsystem.model.dto.UserDto;
import az.afb.todomanagementsystem.model.view.UserView;
import az.afb.todomanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserView> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public void createUser(@RequestBody UserDto dto) {
        userService.createUser(dto);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody UserDto dto) {
        userService.updateUser(id, dto);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping
    public ResponseEntity<List<UserView>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}
