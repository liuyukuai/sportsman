package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.entity.Health;
import com.sysware.cloud.repository.AthleteRepository;
import com.sysware.cloud.repository.HealthRepository;
import com.sysware.cloud.support.AthleteSupport;
import com.sysware.cloud.support.HealthSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthRepository healthRepository;


    @Override
    public Health saveHealth(HealthDto healthDto) {

        Health health = HealthSupport.process(healthDto);

        Health one = healthRepository.save(health);
        return one;
    }
}
