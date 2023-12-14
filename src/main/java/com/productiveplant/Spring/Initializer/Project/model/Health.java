package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "health")
public class Health {

    @Id
    @SequenceGenerator(
            name = "health_sequence",
            sequenceName = "health_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "health_sequence"
    )
    private Long id;
    private int health;

    public Health() {
    }

    public Health(Long id, int health) {
        this.id = id;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
