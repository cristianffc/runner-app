package com.mind.runner;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.athlete.DeleteAthlete;
import com.mind.runner.business.usecase.athlete.FindAthlete;
import com.mind.runner.business.usecase.athlete.SaveAthlete;
import com.mind.runner.business.usecase.athlete.UpdateAthlete;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RunnerApplication implements CommandLineRunner {

    private final SaveAthlete saveAthlete;

    private final DeleteAthlete deleteAthlete;

    private final UpdateAthlete updateAthlete;

    private final FindAthlete findAthlete;

    public RunnerApplication(SaveAthlete saveAthlete, DeleteAthlete deleteAthlete, UpdateAthlete updateAthlete, FindAthlete findAthlete) {
        this.saveAthlete = saveAthlete;
        this.deleteAthlete = deleteAthlete;
        this.updateAthlete = updateAthlete;
        this.findAthlete = findAthlete;
    }

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }

    @Override
    public void run(String... args) {

        var a1 = Athlete.builder().withFirstName("Test fake").withLastName("Mock1 last name").
                withBirth(new Date()).build();
        var a2 = Athlete.builder().withFirstName("Mock Second").withLastName("Mock2 last name").
                withBirth(new Date()).build();
        var a3 = Athlete.builder().withFirstName("Mock Third").withLastName("Mock3 last name").
                withBirth(new Date()).build();
        var a4 = Athlete.builder().withFirstName("Mock Fourth").withLastName("Mock4 last name").
                withBirth(new Date()).build();
        var a5 = Athlete.builder().withFirstName("Mock Fifth").withLastName("Mock5 last name").
                withBirth(new Date()).build();

        saveAthlete.save(a1);
        saveAthlete.save(a2);
        saveAthlete.save(a3);
        saveAthlete.save(a4);
        saveAthlete.save(a5);

        List<Athlete> athletes = findAthlete.findByOrderByCreatedAtDesc();
        athletes.forEach(System.out::println);

//        String salt = BCrypt.gensalt(12);
//        String hashed_password = BCrypt.hashpw("mind123", salt);
//        System.out.println(hashed_password);
    }
}
