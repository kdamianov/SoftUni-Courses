package bg.softuni.automappingobjectsexercise.repository;

import bg.softuni.automappingobjectsexercise.model.entities.Game;
import bg.softuni.automappingobjectsexercise.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //задължителна анотация
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);

    @Query("SELECT u.games FROM User u WHERE u.Id = :id")
    List<Game> findAllGamesByUser(@Param("id") Long id);
}
