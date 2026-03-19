package az.afb.todomanagementsystem.repository;

import az.afb.todomanagementsystem.entity.Task;
import az.afb.todomanagementsystem.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    Optional<Task> findByUserId(Integer userId);

    List<Task> findAllByUserId(Integer id);
    List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    Integer id(Integer id);
}
