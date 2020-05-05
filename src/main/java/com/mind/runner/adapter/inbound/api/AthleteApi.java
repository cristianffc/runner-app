package com.mind.runner.adapter.inbound.api;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.FindAthlete;
import com.mind.runner.business.usecase.SaveAthlete;
import com.mind.runner.business.usecase.UpdateAthlete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AthleteApi {

    @Autowired
    private FindAthlete findAthlete;

    @Autowired
    private SaveAthlete saveAthlete;

    @Autowired
    private UpdateAthlete updateAthlete;

    @GetMapping("/athlete")
    public ResponseEntity<List<Athlete>> findAll() {
        List<Athlete> response = null;
        try {
            response = findAthlete.findAll();
            if(response != null) {
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/athlete/{id}")
    public ResponseEntity<Athlete> findById(@PathVariable Long id) {
        try {
            Athlete athlete = findAthlete.findById(id);
            if(athlete != null) {
                return new ResponseEntity<>(athlete, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/athlete", consumes = "application/json")
    public ResponseEntity<Athlete> save(@RequestBody Athlete newAthlete) {
        Athlete athlete = null;
        try {
            athlete = saveAthlete.save(newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/athlete/{id}", consumes = "application/json")
    public ResponseEntity<Athlete> updateIdempotent(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        Athlete athlete = null;
        try {
            athlete = updateAthlete.updateIdempotent(id, newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(path = "/athlete/{id}", consumes = "application/json")
    public ResponseEntity<Athlete> update(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        Athlete athlete = null;
        try {
            athlete = updateAthlete.update(id, newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
