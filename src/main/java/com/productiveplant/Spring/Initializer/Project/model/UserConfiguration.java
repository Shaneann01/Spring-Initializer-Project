package com.productiveplant.Spring.Initializer.Project.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.DECEMBER;
import static java.time.Month.SEPTEMBER;

@Configuration
public class UserConfiguration {

    @Bean
    CommandLineRunner commandLineRun(UserRepository repository){
        return args -> {
            User jeff = new User(
                    "jeff",
                    LocalDate.of(2001, DECEMBER, 30),
                    "shaneann@gmail.com"
            );

            User lin = new User(
                    "Lin",
                    LocalDate.of(1993, SEPTEMBER, 06),
                    "Linnea@gmail.com"
            );
            repository.saveAll(
                    List.of(jeff,lin)
            );
        };
    }
}
