package bg.softuni.planer_app.service;

import bg.softuni.planer_app.model.dto.TaskAddBindingModel;
import bg.softuni.planer_app.model.dto.TaskHomeViewModel;
import bg.softuni.planer_app.model.entity.TaskEntity;
import org.springframework.scheduling.config.Task;

public interface TaskService {

    void add(TaskAddBindingModel task);

    void assign(Long id, String username);

    void remove(Long id);

    TaskHomeViewModel getHomeViewData(String username);
}
