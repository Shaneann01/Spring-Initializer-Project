package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\"plant\"")
public class Plant {
    @Id
    @SequenceGenerator(
            name = "plant_sequence",
            sequenceName = "plant_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plant_sequence"
    )
    private Long id;
    private String name;

    private int health;
    public Plant() {
    }

    public Plant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
