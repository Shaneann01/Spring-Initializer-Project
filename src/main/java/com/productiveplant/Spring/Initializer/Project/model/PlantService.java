package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlantService {
    private final PlantRespository plantRespository;

    @Autowired
    public PlantService(PlantRespository plantRespository) {
        this.plantRespository = plantRespository;
    }

    public List<Plant> getPlant() {return plantRespository.findAll();}

    public void namePlant(Plant plant){
        Optional<Plant> optionalPlant = plantRespository.findByName(plant.getName());
        if(optionalPlant.isPresent()){
            throw new IllegalStateException("This name already exists!");
        }
        plantRespository.save(plant);
    }

    public void deletePlant(Long plantId){
        boolean exists = plantRespository.existsById(plantId);
        if(!exists){
            throw new IllegalStateException("This plant does not exists!");
        }
        plantRespository.deleteById(plantId);
    }

    @Transactional
    public void updatePlant(Long plantId, String name){
        Plant plant = plantRespository.findById(plantId).orElseThrow(() -> new IllegalStateException("Unfortunately you have not created a plant yet!"));

        if(name != null && name.length() > 0 && !Objects.equals(plant.getName(), name)){
            plant.setName(name);
        }
    }

}
