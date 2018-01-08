package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AthleteServiceImpl implements AthleteService {

    @Autowired
    private AthleteRepository sportsmanRepository;


    @Override
    public Athlete saveAthlete(AthleteDto athleteDto) {

        Athlete athlete = new Athlete();
        athlete.setId("201801081240hattie");
        athlete.setName("hattie");
        athlete.setAge(18);
        athlete.setBehalf_unit("sysware");
        athlete.setPre_coach("pre_happy");
        athlete.setCurrent_coach("happy");
        athlete.setEngage_year(5);
        athlete.setGender(0);
        athlete.setItem("溜冰");
        athlete.setFrom_item("滑雪");
        athlete.setHighest_rank(1);
        athlete.setLatest_world_rank(2);
        athlete.setYearly_rank(3);
        athlete.setParticipant_count(5);

        Athlete one = sportsmanRepository.save(athlete);
        return one;
    }
}
