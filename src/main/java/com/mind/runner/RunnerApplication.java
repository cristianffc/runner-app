package com.mind.runner;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.DeleteAthlete;
import com.mind.runner.business.usecase.FindAthlete;
import com.mind.runner.business.usecase.SaveAthlete;
import com.mind.runner.business.usecase.UpdateAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class RunnerApplication implements CommandLineRunner {

    @Autowired
    SaveAthlete saveAthlete;

    @Autowired
    DeleteAthlete deleteAthlete;

    @Autowired
    UpdateAthlete updateAthlete;

    @Autowired
    FindAthlete findAthlete;

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Athlete a1 = new Athlete().builder().withFirstName("Mock Fist").withLastName("Mock1 last name").
                withAge(35).withGoal("Speed").build();
        Athlete a2 = new Athlete().builder().withFirstName("Second Mock").withLastName("Mock2 last name").
                withAge(27).withGoal("Resistence").build();
        Athlete a3 = new Athlete().builder().withFirstName("Mock Third").withLastName("Mock3 last name").
                withAge(40).withGoal("Force").build();
        Athlete a4 = new Athlete().builder().withFirstName("Fourth Mock").withLastName("Mock4 last name").
                withAge(22).withGoal("Potency").build();
        Athlete a5 = new Athlete().builder().withFirstName("Mock Fifth").withLastName("Mock5 last name").
                withAge(26).withGoal("Soccer").build();

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
