package com.mind.runner.config;

import com.mind.runner.adapter.outbound.jpa.AthleteJpaRepositoryImpl;
import com.mind.runner.business.port.AthleteRepository;
import com.mind.runner.business.usecase.athlete.DeleteAthlete;
import com.mind.runner.business.usecase.athlete.FindAthlete;
import com.mind.runner.business.usecase.athlete.SaveAthlete;
import com.mind.runner.business.usecase.athlete.UpdateAthlete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Bean
    AthleteRepository athleteRepository() {
        return new AthleteJpaRepositoryImpl();
    }

    @Bean
    SaveAthlete saveAthlete() {
        return new SaveAthlete(athleteRepository());
    }

    @Bean
    FindAthlete findAthlete() {
        return new FindAthlete(athleteRepository());
    }

    @Bean
    DeleteAthlete deleteAthlete() {
        return new DeleteAthlete(athleteRepository());
    }

    @Bean
    UpdateAthlete updateAthlete() {
        return new UpdateAthlete(athleteRepository());
    }
}