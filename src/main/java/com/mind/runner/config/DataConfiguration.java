package com.mind.runner.config;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.athlete.DeleteAthlete;
import com.mind.runner.business.usecase.athlete.FindAthlete;
import com.mind.runner.business.usecase.athlete.SaveAthlete;
import com.mind.runner.business.usecase.athlete.UpdateAthlete;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataConfiguration {

    private final SaveAthlete saveAthlete;

    private final DeleteAthlete deleteAthlete;

    private final UpdateAthlete updateAthlete;

    private final FindAthlete findAthlete;

    public DataConfiguration(final SaveAthlete saveAthlete,
                             final DeleteAthlete deleteAthlete,
                             final UpdateAthlete updateAthlete,
                             final FindAthlete findAthlete) {
        this.saveAthlete = saveAthlete;
        this.deleteAthlete = deleteAthlete;
        this.updateAthlete = updateAthlete;
        this.findAthlete = findAthlete;
    }

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            Athlete a1 = Athlete.builder().withFirstName("Test fake").withLastName("Mock1 last name").
                    withBirth(new Date()).build();
            Athlete a2 = Athlete.builder().withFirstName("Mock Second").withLastName("Mock2 last name").
                    withBirth(new Date()).build();
            Athlete a3 = Athlete.builder().withFirstName("Mock Third").withLastName("Mock3 last name").
                    withBirth(new Date()).build();
            Athlete a4 = Athlete.builder().withFirstName("Mock Fourth").withLastName("Mock4 last name").
                    withBirth(new Date()).build();
            Athlete a5 = Athlete.builder().withFirstName("Mock Fifth").withLastName("Mock5 last name").
                    withBirth(new Date()).build();

            saveAthlete.save(a1);
            saveAthlete.save(a2);
            saveAthlete.save(a3);
            saveAthlete.save(a4);
            saveAthlete.save(a5);
        };
    }

}
