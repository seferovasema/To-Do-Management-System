package az.afb.todomanagementsystem.service;

import az.afb.todomanagementsystem.entity.Task;
import az.afb.todomanagementsystem.enums.TaskStatus;
import az.afb.todomanagementsystem.model.dto.TaskDto;
import az.afb.todomanagementsystem.model.view.TaskView;

import java.util.List;

public interface TaskService {
    void createTask(TaskDto dto);
    void updateTask(Integer id,TaskDto dto);
    void deleteTask(Integer id);
    TaskView findById(Integer id);
    List<TaskView> findAll();

    void assign(Integer id,Integer userId);
    void unassign(Integer id);
    List<TaskView> getTasksByUserId(Integer userId);
    void changeStatus(Integer id, TaskStatus status);
    List<TaskView> getTasksByTaskStatus(TaskStatus taskStatus);
}
