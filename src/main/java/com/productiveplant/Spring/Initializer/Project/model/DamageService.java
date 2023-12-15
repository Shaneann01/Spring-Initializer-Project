package com.productiveplant.Spring.Initializer.Project.model;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DamageService {
    private final DamageRespository damageRespository;

@Autowired
    public DamageService(DamageRespository damageRespository) {
        this.damageRespository = damageRespository;
    }

    public List<Damage> getDamage(){return damageRespository.findAll();}

    public void setDamage(Damage damage){
        Optional<Damage> damageOptional = damageRespository.findByDamage(damage.getDamage());
        if(damageOptional.isPresent()){
            throw new IllegalStateException("This already exists!");
        }
        damageRespository.save(damage);
    }

    public void deleteDamage(Long damageId){
        boolean exists = damageRespository.existsById(damageId);
        if(!exists){
            throw new IllegalStateException("There isn't any damage create to delete!");
        }
        damageRespository.deleteById(damageId);
    }

    @Transactional
    public void updateDamage(Long damageId, int newDamage){
        Damage existingDamage = damageRespository.findById(damageId).orElseThrow(() -> new IllegalStateException("Damage data does not exists!"));

        if(existingDamage.getDamage() != newDamage && newDamage != 0){
            existingDamage.setDamage(newDamage);
        }
    }
}
