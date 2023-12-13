package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ObjectiveConfiguration {

    @Bean
    CommandLineRunner objectionCommandLineRunner(ObjectiveRepository repository){
        return args -> {
            Objective one = new Objective("Go to Store!");
            Objective two = new Objective("finish this project!");

            repository.saveAll(List.of(one,two));
        };
    }
}
