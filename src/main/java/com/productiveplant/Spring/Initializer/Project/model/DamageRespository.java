package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DamageRespository extends JpaRepository<Damage, Long> {

    @Query("SELECT d FROM Damage d WHERE d.damage=?1")
    Optional<Damage> findByDamage(int damage);
}
