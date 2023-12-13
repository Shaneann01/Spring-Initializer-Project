package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void newObjective(Objective objective){
        Optional<Objective> objectiveOptional = objectiveRepository.findByObjective(objective.getObjectives());
        if(objectiveOptional.isPresent()){
            throw new IllegalStateException("This is already an Objective, please complete that one first or make another one.");
        }
        objectiveRepository.save(objective);
    }

    public void deleteObjective(Long objectivesId){
        boolean exists = objectiveRepository.existsById(objectivesId);
        if(!exists){
            throw new IllegalStateException("This objective does not exists, try and create a new one instead! ");
        }
        objectiveRepository.deleteById(objectivesId);
    }
}
