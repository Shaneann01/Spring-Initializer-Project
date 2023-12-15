package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"damage\"")
public class Damage {
    @Id
    @SequenceGenerator(
            name = "damage_sequence",
            sequenceName = "damage_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "damage_sequence"
    )
    private Long id;
    private int damage;

    public Damage() {
    }

    public Damage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
