package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;

public interface AthleteService {
    Athlete saveAthlete(AthleteDto athleteDto);
}
