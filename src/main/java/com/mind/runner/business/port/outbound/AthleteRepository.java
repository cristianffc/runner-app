package com.mind.runner.business.port.outbound;

import com.mind.runner.business.entity.Athlete;

public interface AthleteRepository {

    void create(Athlete athlete);

}
