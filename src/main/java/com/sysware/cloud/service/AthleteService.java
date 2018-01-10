package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;

import java.util.List;

public interface AthleteService {
    Athlete create(AthleteDto athleteDto);
    Athlete getById(String id);
    List<Athlete> list();
}
