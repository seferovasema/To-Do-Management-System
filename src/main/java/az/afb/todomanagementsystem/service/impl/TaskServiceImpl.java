package az.afb.todomanagementsystem.service.impl;

import az.afb.todomanagementsystem.entity.Task;
import az.afb.todomanagementsystem.enums.TaskStatus;
import az.afb.todomanagementsystem.mapper.TaskMapper;
import az.afb.todomanagementsystem.mapper.UserMapper;
import az.afb.todomanagementsystem.model.dto.TaskDto;
import az.afb.todomanagementsystem.model.view.TaskView;
import az.afb.todomanagementsystem.repository.TaskRepository;
import az.afb.todomanagementsystem.repository.UserRepository;
import az.afb.todomanagementsystem.service.TaskService;
import az.afb.todomanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createTask(TaskDto dto) {
        var task = taskMapper.mapToEntity(dto);
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Integer id, TaskDto dto) {
        var task = taskRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        BeanUtils.copyProperties(dto, task);
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.findById(id).ifPresent(taskRepository::delete);
    }

    @Override
    public TaskView findById(Integer id) {
        var task = taskRepository.findById(id).get();
        return taskMapper.mapToView(task);
    }

    @Override
    public List<TaskView> findAll() {
        return taskRepository
                .findAll()
                .stream()
                .map(taskMapper::mapToView)
                .toList();
    }

    @Override
    public void assign(Integer id, Integer userId) {
        taskRepository
                .findById(id)
                .ifPresent(task -> {
                    task.setUserId(userId);
                    taskRepository.save(task);
                });
    }

    @Override
    public List<TaskView> getTasksByTaskStatus(TaskStatus taskStatus) {
      return  taskRepository
                .findAllByTaskStatus(taskStatus)
                .stream()
                .map(taskMapper::mapToView)
                .toList();

    }

    @Override
    public void changeStatus(Integer id, TaskStatus status) {
        var task=taskRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Task not found"));
        task.setTaskStatus(status);
        taskRepository.save(task);
    }

    @Override
    public List<TaskView> getTasksByUserId(Integer userId) {
       userRepository
                .findById(userId)
                .orElseThrow(()->new IllegalArgumentException("User not found"));

        return taskRepository
                .findAllByUserId(userId)
                .stream()
                .map(taskMapper::mapToView)
                .toList();

    }

    @Override
    public void unassign(Integer id) {
        taskRepository
                .findById(id)
                .ifPresent(task->{
                    task.setUserId(null);
                    taskRepository.save(task);
                });
    }
}
