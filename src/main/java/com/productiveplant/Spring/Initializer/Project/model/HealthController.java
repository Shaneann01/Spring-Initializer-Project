package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/health")
public class HealthController {
    private final HealthService healthService;

    @Autowired
    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public List<Health> getHealth(){return healthService.getHealth();}

    @PostMapping
    public void createHealth(@RequestBody Health health){
        healthService.createHealth(health);
    }

    @DeleteMapping("{healthId}")
    public void deleteHealth(@PathVariable("healthId") Long healthId){
        healthService.deleteHealth(healthId);
    }

    @PutMapping("{healthId}")
    public void updateHealth(
            @PathVariable("healthId") Long healthId,
            @RequestParam(required = false) int health
            ){
        healthService.updateHealth(healthId, health);
    }
}
