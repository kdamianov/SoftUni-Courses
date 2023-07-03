package bg.softuni.springdataadvancedqueryinglab.repositories;

import bg.softuni.springdataadvancedqueryinglab.models.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {
}
