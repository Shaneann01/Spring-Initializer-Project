package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HealthService {
    private final HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public List<Health> getHealth(){
        return healthRepository.findAll();
    }

    public void createHealth(Health health){
        Optional<Health> optionalHealth = healthRepository.findByHealth(health.getHealth());
        if(optionalHealth.isPresent()){
            throw new IllegalStateException("Health is already create!");
        }
        healthRepository.save(health);
    }

    public void deleteHealth(Long healthId){
        boolean exists = healthRepository.existsById(healthId);
        if(!exists){
            throw new IllegalStateException("This health does not exists!");
        }
        healthRepository.deleteById(healthId);
    }

@Transactional
    public void updateHealth(Long healthId, int newHealth){
        Health existingHealth = healthRepository.findById(healthId).orElseThrow(() -> new IllegalStateException("Health does not exists!"));

        if(newHealth <= 100 && newHealth >= 0 && existingHealth.getHealth() != newHealth){
            existingHealth.setHealth(newHealth);
        }
   }

}
