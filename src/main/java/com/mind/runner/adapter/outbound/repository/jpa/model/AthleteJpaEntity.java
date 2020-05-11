package com.mind.runner.adapter.outbound.repository.jpa.model;

import com.mind.runner.business.entity.Athlete;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Athlete")
public class AthleteJpaEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String goal;
    private Date createdAt;

    public AthleteJpaEntity() {}

    private AthleteJpaEntity(Long id, String firstName, String lastName, String password, Integer age, String goal) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Athlete toAthlete() {
        return Athlete.builder().
                withId(id).
                withFirstName(firstName).
                withLastName(lastName).
                withAge(age).
                withGoal(goal).
                withCreatedAt(createdAt).
                build();
    }

    public static AthleteJpaEntity toAthleteJpaEntity(Athlete athlete) {
        var athleteJpaEntity = new AthleteJpaEntity();

        athleteJpaEntity.setId(athlete.getId());
        athleteJpaEntity.setFirstName(athlete.getFirstName());
        athleteJpaEntity.setLastName(athlete.getLastName());
        athleteJpaEntity.setAge(athlete.getAge());
        athleteJpaEntity.setGoal(athlete.getGoal());

        return athleteJpaEntity;
    }

}
