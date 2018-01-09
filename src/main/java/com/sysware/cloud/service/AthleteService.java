package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;

public interface AthleteService {
    Athlete create(AthleteDto athleteDto);
    Athlete getById(String id);
}
