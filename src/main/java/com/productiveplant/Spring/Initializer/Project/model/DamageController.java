package com.productiveplant.Spring.Initializer.Project.model;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/damage")
public class DamageController {

    private DamageService damageService;

    @Autowired
    public DamageController(DamageService damageService) {
        this.damageService = damageService;
    }

    @GetMapping
    public List<Damage> getDamage(){return damageService.getDamage();}

    @PostMapping
    public void setDamage(@RequestBody Damage damage){
        damageService.setDamage(damage);
    }

    @DeleteMapping("{damageId}")
    public void deleteDamage(@PathVariable("damageId") Long damageId){
        damageService.deleteDamage(damageId);
    }

    @PutMapping("{damageId}")
    public void updateDamage(
            @PathVariable("damageId") Long damageId,
            @RequestParam(required = false) int damage){
        damageService.updateDamage(damageId, damage);
    }
}
