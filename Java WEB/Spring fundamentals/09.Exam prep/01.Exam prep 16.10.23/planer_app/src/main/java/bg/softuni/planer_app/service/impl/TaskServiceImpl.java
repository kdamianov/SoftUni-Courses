package bg.softuni.planer_app.service.impl;

import bg.softuni.planer_app.model.dto.TaskAddBindingModel;
import bg.softuni.planer_app.model.dto.TaskDTO;
import bg.softuni.planer_app.model.dto.TaskHomeViewModel;
import bg.softuni.planer_app.model.entity.PriorityEntity;
import bg.softuni.planer_app.model.entity.TaskEntity;
import bg.softuni.planer_app.model.entity.UserEntity;
import bg.softuni.planer_app.repo.PriorityRepository;
import bg.softuni.planer_app.repo.TaskRepository;
import bg.softuni.planer_app.repo.UserRepository;
import bg.softuni.planer_app.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PriorityRepository priorityRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository,
                           PriorityRepository priorityRepository,
                           ModelMapper modelMapper,
                           UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.priorityRepository = priorityRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void add(TaskAddBindingModel taskAddBindingModel) {
        TaskEntity task = new TaskEntity();
        PriorityEntity priority = priorityRepository.findByName(taskAddBindingModel.getPriority());

        task.setDescription(taskAddBindingModel.getDescription());
        task.setDueDate(taskAddBindingModel.getDueDate());
        task.setPriority(priority);

        taskRepository.save(task);
    }

    @Override
    public void assign(Long id, String username) {
        Optional<TaskEntity> byId = taskRepository.findById(id);

        if (byId.isPresent()) {
            TaskEntity task = byId.get();

            if (username == null) {
                task.setUser(null);
            } else {
                task.setUser(userRepository.findByUsername(username).orElse(null));
            }

            taskRepository.save(task);
        }
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskHomeViewModel getHomeViewData(String username) {
        UserEntity user = userRepository.findByUsername(username).orElse(null);

        List<TaskDTO> assignedTasks = taskRepository
                .findByAssignee(user)
                .stream()
                .map(TaskDTO::createFromTask)
                .toList();


        List<TaskDTO> availableTasks = taskRepository.getAllAvailable().stream()
                .map(TaskDTO::createFromTask)
                .toList();;



        return new TaskHomeViewModel(assignedTasks, availableTasks);
    }
}
