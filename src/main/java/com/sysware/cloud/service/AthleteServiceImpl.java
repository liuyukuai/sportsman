package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.repository.AthleteRepository;
import com.sysware.cloud.support.AthleteSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteRepository sportsmanRepository;


    @Override
    public Athlete create(AthleteDto athleteDto) {

        Athlete athlete = AthleteSupport.process(athleteDto);

        Athlete one = sportsmanRepository.save(athlete);
        return one;
    }
}
