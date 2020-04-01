package com.mind.runner;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.CreateAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication implements CommandLineRunner {

    @Autowired
    CreateAthlete createAthlete;

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Athlete athlete = new Athlete().builder().
                withFirstName("Mock first name").
                withLastName("Mock last name").
                withAge(35).
                withGoal("Speed").
                withPassword("x232Q2@1e").
                withEmail("mock@mockdomain.com").
                build();

        createAthlete.create(athlete);
    }
}
