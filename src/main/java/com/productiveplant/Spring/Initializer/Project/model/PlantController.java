package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/plant")
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping
    public List<Plant> getPlant(){return plantService.getPlant();}

    @PostMapping
    public void createNewPlant(@RequestBody Plant plant){
        plantService.namePlant(plant);
    }

    @DeleteMapping("{plantId}")
    public void deletePlant(@PathVariable("plantId") Long plantId){
        plantService.deletePlant(plantId);
    }

    @PutMapping("{plantId}")
    public void updatePlant(
            @PathVariable("plantId") Long plantId,
            @RequestParam(required = false) String name
    ){
        plantService.updatePlant(plantId, name);
    }
}
