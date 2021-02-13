package com.mind.runner.adapter.inbound.api;

import com.mind.runner.adapter.inbound.api.dto.AthleteDto;
import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.usecase.athlete.DeleteAthlete;
import com.mind.runner.business.usecase.athlete.FindAthlete;
import com.mind.runner.business.usecase.athlete.SaveAthlete;
import com.mind.runner.business.usecase.athlete.UpdateAthlete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Api(value = "Athlete API")
public class AthleteApi {

    private final FindAthlete findAthlete;
    private final SaveAthlete saveAthlete;
    private final UpdateAthlete updateAthlete;
    private final DeleteAthlete deleteAthlete;

    public AthleteApi(final FindAthlete findAthlete,
                      final SaveAthlete saveAthlete,
                      final UpdateAthlete updateAthlete,
                      final DeleteAthlete deleteAthlete) {
        this.findAthlete = findAthlete;
        this.saveAthlete = saveAthlete;
        this.updateAthlete = updateAthlete;
        this.deleteAthlete = deleteAthlete;
    }

    @ApiOperation(value = "Find all athletes", produces = "application/json")
    @GetMapping("/athletes")
    public ResponseEntity<List<AthleteDto>> findAll() {
        try {
            final var athletesDto = findAthlete.findAll()
                    .stream()
                    .map(AthleteDto::athleteDtoBuilder)
                    .collect(toList());
            //HATEOAS
            athletesDto.forEach(athleteDto ->
                    athleteDto.add(linkTo(methodOn(AthleteApi.class).findById(
                            athleteDto.getId())).withSelfRel()));
            return new ResponseEntity<>(athletesDto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Save athlete")
    @PostMapping(path = "/athletes", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AthleteDto> save(@RequestBody final Athlete newAthlete) {
        try {
            final var athleteDto = AthleteDto.athleteDtoBuilder(saveAthlete.save(newAthlete));
            return new ResponseEntity<>(athleteDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Find athlete by id", produces = "application/json")
    @GetMapping("/athletes/{id}")
    public ResponseEntity<AthleteDto> findById(@PathVariable final Long id) {
        try {
            final var athlete = findAthlete.findById(id);
            if (athlete.isPresent()) {
                AthleteDto athleteDto = AthleteDto.athleteDtoBuilder(athlete.get());

                //HATEOAS
                athleteDto.add(linkTo(methodOn(AthleteApi.class).findAll()).withRel("findAll"));
                athleteDto.add(linkTo(methodOn(AthleteApi.class).delete(athleteDto.getId())).withRel("delete"));
                return new ResponseEntity<>(athleteDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update athlete (idempotent action)")
    @PutMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AthleteDto> updateIdempotent(@PathVariable final Long id,
                                                       @RequestBody final Athlete newAthlete) {
        try {
            final var athlete = updateAthlete.updateIdempotent(id, newAthlete);
            if (athlete.isPresent()) {
                final var athleteDto = AthleteDto.athleteDtoBuilder(athlete.get());
                return new ResponseEntity<>(athleteDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Update athlete (not idempotent action)")
    @PatchMapping(path = "/athletes/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AthleteDto> update(@PathVariable final Long id,
                                             @RequestBody final Athlete newAthlete) {
        try {
            final var athlete = updateAthlete.update(id, newAthlete);
            if (athlete.isPresent()) {
                final var athleteDto = AthleteDto.athleteDtoBuilder(athlete.get());
                return new ResponseEntity<>(athleteDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Delete athlete")
    @DeleteMapping(path = "/athletes/{id}", produces = "application/json")
    public ResponseEntity<AthleteDto> delete(@PathVariable final Long id) {
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

    @ApiOperation(value = "Available verbs")
    @RequestMapping(value = "/athletes/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options() {
        return ResponseEntity.ok()
                .allow(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.PATCH,
                        HttpMethod.OPTIONS)
                .build();
    }
}