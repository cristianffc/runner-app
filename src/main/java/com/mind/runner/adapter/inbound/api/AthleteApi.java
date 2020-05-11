package com.mind.runner.adapter.inbound.api;

import com.mind.runner.adapter.inbound.api.dto.AthleteDto;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.DeleteAthlete;
import com.mind.runner.business.usecase.FindAthlete;
import com.mind.runner.business.usecase.SaveAthlete;
import com.mind.runner.business.usecase.UpdateAthlete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public ResponseEntity<List<AthleteDto>> findAll() {
        try {
            List<AthleteDto> athletes = findAthlete.findAll()
                                                   .stream()
                                                   .map(AthleteDto::toAthleteDto)
                                                   .collect(Collectors.toList());
            //HATEOAS
            athletes.forEach(athleteDto -> athleteDto.add(linkTo(methodOn(AthleteApi.class).findById(
                    athleteDto.getId())).withSelfRel()));
            return new ResponseEntity<>(athletes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/athletes", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Save athlete")
    public ResponseEntity<AthleteDto> save(@RequestBody Athlete newAthlete) {
        try {
            AthleteDto athlete = AthleteDto.toAthleteDto(saveAthlete.save(newAthlete));
            return new ResponseEntity<>(athlete, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/athletes/{id}")
    @ApiOperation(value = "Find athlete by id", produces = "application/json")
    public ResponseEntity<AthleteDto> findById(@PathVariable Long id) {
        try {
            AthleteDto athlete = AthleteDto.toAthleteDto(findAthlete.findById(id));
            //HATEOAS
            athlete.add(linkTo(methodOn(AthleteApi.class).findAll()).withRel("findAll"));
            athlete.add(linkTo(methodOn(AthleteApi.class).delete(athlete.getId())).withRel("delete"));
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update athlete (idempotent action)")
    public ResponseEntity<AthleteDto> updateIdempotent(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        try {
            AthleteDto athlete = AthleteDto.toAthleteDto(updateAthlete.updateIdempotent(id, newAthlete));
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "Update athlete (not idempotent action)")
    public ResponseEntity<AthleteDto> update(@PathVariable Long id, @RequestBody Athlete newAthlete) {
        try {
            AthleteDto athlete = AthleteDto.toAthleteDto(updateAthlete.update(id, newAthlete));
            return new ResponseEntity<>(athlete, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/athletes/{id}", produces = "application/json")
    @ApiOperation(value = "Delete athlete")
    public ResponseEntity<AthleteDto> delete(@PathVariable Long id) {
        try {
            deleteAthlete.delete(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            if (e instanceof EmptyResultDataAccessException) {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/athletes/{id}", method = RequestMethod.OPTIONS)
    @ApiOperation(value = "Available verbs")
    public ResponseEntity<?> options() {
        return ResponseEntity.ok()
                             .allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.PATCH, HttpMethod.OPTIONS)
                             .build();
    }
}
