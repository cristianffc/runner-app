package com.mind.runner.config;

import com.mind.runner.adapter.outbound.repository.jpa.AthleteJpaRepository;
import com.mind.runner.business.usecase.DeleteAthlete;
import com.mind.runner.business.usecase.FindAthlete;
import com.mind.runner.business.usecase.SaveAthlete;
import com.mind.runner.business.usecase.UpdateAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Autowired
    private AthleteJpaRepository athleteJpaRepository;

    @Bean
    public SaveAthlete saveAthlete() {
        return new SaveAthlete(athleteJpaRepository);
    }

    @Bean
    public FindAthlete findAthlete() {
        return new FindAthlete(athleteJpaRepository);
    }

    @Bean
    public DeleteAthlete deleteAthlete() {
        return new DeleteAthlete(athleteJpaRepository);
    }

    @Bean
    public UpdateAthlete updateAthlete() {
        return new UpdateAthlete(athleteJpaRepository);
    }

}
