package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByEmail(String email);

    @Query("select p from Player p where p.birthDate between :after and :before order by p.stat.shooting desc, p.stat.passing desc, " +
            "p.stat.endurance desc, p.lastName ")
    List<Player> findTheBestPlayers(@Param("after") LocalDate after, @Param("before") LocalDate before);

    List<Player> findByBirthDateBetweenOrderByStat_ShootingDescStat_PassingDescStat_EnduranceDescLastName(LocalDate after, LocalDate before);
}
