package com.mind.runner.adapter.inbound.api;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.FindAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AthleteApi {

    @Autowired
    private FindAthlete findAthlete;

    @GetMapping("/athlete")
    public List<Athlete> all() {
        return findAthlete.findAll();
    }

    @GetMapping("/athlete/{id}")
    public Athlete one(@PathVariable Long id) {
        return findAthlete.findById(id);
    }
}
