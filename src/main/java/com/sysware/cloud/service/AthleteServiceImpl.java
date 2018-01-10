package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.repository.AthleteRepository;
import com.sysware.cloud.support.AthleteSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteRepository athleteRepository;


    @Override
    public Athlete create(AthleteDto athleteDto) {
        Athlete athlete = AthleteSupport.process(athleteDto);
        return athleteRepository.save(athlete);
    }

    @Override
    public Athlete getById(String id) {
       return athleteRepository.findOne(id);
    }

    @Override
    public List<Athlete> list() {
        return athleteRepository.findAll();
    }
}
