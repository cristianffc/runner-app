package com.mind.runner.business.entity.builder;

import com.mind.runner.business.entity.Athlete;
import com.mind.runner.business.entity.Track;
import com.mind.runner.business.entity.Trainer;
import com.mind.runner.business.entity.Training;

public class TrainingBuilder {

    private Training training = new Training();

    public TrainingBuilder withAthlete(Athlete athlete) {
        this.training.setAthlete(athlete);
        return this;
    }

    public TrainingBuilder withTrainer(Trainer trainer) {
        this.training.setTrainer(trainer);
        return this;
    }

    public TrainingBuilder withTrack(Track track) {
        this.training.setTrack(track);
        return this;
    }

    public Training build() {
        return this.training;
    }

}
