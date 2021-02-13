package com.mind.runner.adapter.outbound.jpa.entity;

import com.mind.runner.business.entity.Athlete;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Athlete")
public class AthleteJpaEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Date birth;
    @NotNull
    private String email;
    private Date createdAt;

    public AthleteJpaEntity() {}

    public AthleteJpaEntity(Long id, String firstName, String lastName, Date birth, String email, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.email = email;
        this.createdAt = createdAt;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    public Athlete athleteBuilder() {
        return Athlete.builder().
                withId(id).
                withFirstName(firstName).
                withLastName(lastName).
                withBirth(birth).
                withEmail(email).
                withCreatedAt(createdAt).
                build();
    }

    public static AthleteJpaEntity athleteJpaEntityBuilder(Athlete athlete) {
        var athleteJpaEntity = new AthleteJpaEntity();

        athleteJpaEntity.setId(athlete.getId());
        athleteJpaEntity.setFirstName(athlete.getFirstName());
        athleteJpaEntity.setLastName(athlete.getLastName());
        athleteJpaEntity.setBirth(athlete.getBirth());
        athleteJpaEntity.setEmail(athlete.getEmail());

        return athleteJpaEntity;
    }
}