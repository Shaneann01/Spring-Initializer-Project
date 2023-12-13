package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/objectives")
public class ObjectiveController {
    private ObjectiveService objectiveService;

    @Autowired
    public ObjectiveController(ObjectiveService objectiveService) {
        this.objectiveService = objectiveService;
    }

    @GetMapping
    public List<Objective> getObjective(){
        return objectiveService.getObjective();
    }

    @PostMapping
    public void createNewObjective(@RequestBody Objective objective){
        objectiveService.newObjective(objective);
    }

    @DeleteMapping(path = "{objectiveId}")
    public void deleteObjective(@PathVariable("objectiveId") Long objectiveId){
        objectiveService.deleteObjective(objectiveId);
    }
}
