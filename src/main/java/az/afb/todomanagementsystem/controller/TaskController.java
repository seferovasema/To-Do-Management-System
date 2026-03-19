package az.afb.todomanagementsystem.controller;

import az.afb.todomanagementsystem.entity.Task;
import az.afb.todomanagementsystem.enums.TaskStatus;
import az.afb.todomanagementsystem.model.dto.TaskDto;
import az.afb.todomanagementsystem.model.view.TaskView;
import az.afb.todomanagementsystem.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskView> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @PostMapping
    public void createTask(@RequestBody TaskDto dto) {
        taskService.createTask(dto);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Integer id, @RequestBody TaskDto dto) {
        taskService.updateTask(id, dto);
    }

    @DeleteMapping
    public void deleteTask(@RequestParam Integer id) {
        taskService.deleteTask(id);
    }

    @GetMapping
    public ResponseEntity<List<TaskView>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PutMapping("/assign/{id}")
    public void assign(@PathVariable Integer id,
                       @RequestParam Integer userId) {
        taskService.assign(id, userId);
    }

    @PutMapping("/unassign")
    public void unassign(@RequestParam Integer id) {
        taskService.unassign(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TaskView>>getTasksByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    @PutMapping("/status/{id}")
    public void changeStatus(@PathVariable Integer id, @RequestParam TaskStatus status){
        taskService.changeStatus(id, status);
    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskView>> getTasksByTaskStatus(@RequestParam TaskStatus taskStatus){
        return ResponseEntity.ok(taskService.getTasksByTaskStatus(taskStatus));
    }

}
