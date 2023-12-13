package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "\" objective \"")
public class Objective {
    @Id
    @SequenceGenerator(
            name = "objective_sequence",
            sequenceName = "objective_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "objective_sequence"
    )

    private Long id;
    private String objectives;

    public Objective() {
    }

    public Objective(Long id, String objectives) {
        this.id = id;
        this.objectives = objectives;
    }

    public Objective(String objectives){
        this.objectives = objectives;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }
}
