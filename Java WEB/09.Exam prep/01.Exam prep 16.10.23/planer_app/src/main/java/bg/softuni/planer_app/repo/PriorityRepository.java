package bg.softuni.planer_app.repo;

import bg.softuni.planer_app.model.entity.PriorityEntity;
import bg.softuni.planer_app.model.enums.PriorityNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity, Long> {

    PriorityEntity findByName(PriorityNameEnum name);
}
