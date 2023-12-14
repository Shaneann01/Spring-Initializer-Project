package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlantConfiguration {

    @Bean
    CommandLineRunner plantCommandLineRunner(PlantRespository respository){
        return args -> {
            Plant original = new Plant(1L, "Production Plant");

            respository.save(original);
        };
    }
}
