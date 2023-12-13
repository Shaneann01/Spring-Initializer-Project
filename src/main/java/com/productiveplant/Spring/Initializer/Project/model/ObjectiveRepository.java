package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long> {

    @Query("SELECT o FROM Objective o WHERE o.objectives = ?1")
    Optional<Objective> findByObjective(String objectives);
}
