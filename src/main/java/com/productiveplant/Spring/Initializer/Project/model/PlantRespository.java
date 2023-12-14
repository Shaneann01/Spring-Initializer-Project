package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRespository extends JpaRepository<Plant, Long> {

    @Query("SELECT p FROM Plant p WHERE p.name = ?1")
    Optional<Plant> findByName(String name);
}
