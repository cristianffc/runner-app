package com.mind.runner.adapter.inbound.api;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.DeleteAthlete;
import com.mind.runner.business.usecase.FindAthlete;
import com.mind.runner.business.usecase.SaveAthlete;
import com.mind.runner.business.usecase.UpdateAthlete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "API")
public class AthleteApi {

    @Autowired
    private FindAthlete findAthlete;

    @Autowired
    private SaveAthlete saveAthlete;

    @Autowired
    private UpdateAthlete updateAthlete;

    @Autowired
    private DeleteAthlete deleteAthlete;

    @GetMapping("/athletes")
    @ApiOperation(value = "Find all athletes", produces = "application/json")
    public ResponseEntity<List<Athlete>> findAll() {
        try {
            List<Athlete> athletes = findAthlete.findAll();
            if(athletes != null) {
                return new ResponseEntity<>(athletes, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/athletes/{id}")
    @ApiOperation(value = "Find athlete by id", produces = "application/json")
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

    @PostMapping(path = "/athletes", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Save athlete")
    public ResponseEntity<Athlete> save(@RequestBody Athlete newAthlete) {
        try {
            Athlete athlete = saveAthlete.save(newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update athlete (idempotent action)")
    public ResponseEntity<Athlete> updateIdempotent(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        try {
            Athlete athlete = updateAthlete.updateIdempotent(id, newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update athlete (not idempotent action)")
    public ResponseEntity<Athlete> update(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        try {
            Athlete athlete = updateAthlete.update(id, newAthlete);
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/athletes/{id}", produces = "application/json")
    @ApiOperation(value = "Delete athlete")
    public ResponseEntity<Athlete> delete(@PathVariable Long id) {
        try {
            deleteAthlete.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            if(e instanceof EmptyResultDataAccessException) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
