package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HealthRepository extends JpaRepository<Health, Long> {

    @Query("SELECT h FROM Health h WHERE h.health=?1")
    Optional<Health> findByHealth(int Health);
}
