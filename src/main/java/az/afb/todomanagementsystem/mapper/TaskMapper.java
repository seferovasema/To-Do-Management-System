package az.afb.todomanagementsystem.mapper;

import az.afb.todomanagementsystem.entity.Task;
import az.afb.todomanagementsystem.model.dto.TaskDto;
import az.afb.todomanagementsystem.model.view.TaskView;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskView mapToView(Task task);
    Task mapToEntity(TaskDto dto);
}
