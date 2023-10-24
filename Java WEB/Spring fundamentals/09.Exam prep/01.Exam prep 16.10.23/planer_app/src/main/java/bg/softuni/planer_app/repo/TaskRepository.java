package bg.softuni.planer_app.repo;

import bg.softuni.planer_app.model.entity.TaskEntity;
import bg.softuni.planer_app.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByAssignee(UserEntity user);

    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE assignee_id IS NULL")
    List<TaskEntity> getAllAvailable();
}
