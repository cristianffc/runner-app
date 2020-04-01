package com.mind.runner.config;

import com.mind.runner.adapter.outbound.repository.jpa.AthleteJpaRepository;
import com.mind.runner.business.usecase.CreateAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Autowired
    private AthleteJpaRepository athleteJpaRepository;

    @Bean
    public CreateAthlete createAthlete() {
        return new CreateAthlete(athleteJpaRepository);
    }

}
