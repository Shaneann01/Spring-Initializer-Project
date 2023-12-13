package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectiveService {
    private final ObjectiveRepository objectiveRepository;

    @Autowired
    public ObjectiveService(ObjectiveRepository objectiveRepository) {
        this.objectiveRepository = objectiveRepository;
    }
    public List<Objective> getObjective(){
        return objectiveRepository.findAll();
    }
}
