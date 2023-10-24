package bg.softuni.planer_app.model.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {

    private final List<TaskDTO> assignedTasks;
    private final List<TaskDTO> availableTasks;

    private final int availableSize;

    public TaskHomeViewModel() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasks, List<TaskDTO> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
        this.availableSize = availableTasks.size();
    }

    public List<TaskDTO> getAssignedTasks() {
        return assignedTasks;
    }

    public List<TaskDTO> getAvailableTasks() {
        return availableTasks;
    }

    public int getAvailableSize() {
        return availableSize;
    }
}
