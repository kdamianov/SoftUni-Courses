package bg.softuni.automappingobjectsexercise.repository;

import bg.softuni.automappingobjectsexercise.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findGameByTitle(String title);
}
