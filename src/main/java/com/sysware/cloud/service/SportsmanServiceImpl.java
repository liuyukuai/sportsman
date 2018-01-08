package com.sysware.cloud.service;

import com.sysware.cloud.dto.SportsmanDto;
import com.sysware.cloud.entity.Sportsman;
import com.sysware.cloud.repository.SportsmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsmanServiceImpl implements SportsmanService{

    @Autowired
    private SportsmanRepository sportsmanRepository;


    @Override
    public Sportsman addSportsman(SportsmanDto sportsmanDto) {

        Sportsman sportsman = new Sportsman();
        sportsman.setId("201801081240hattie");
        sportsman.setName("hattie");
        sportsman.setAge(18);
        sportsman.setBehalf_unit("sysware");
        sportsman.setPre_coach("pre_happy");
        sportsman.setCurrent_coach("happy");
        sportsman.setEngage_year(5);
        sportsman.setGender(0);
        sportsman.setItem("溜冰");
        sportsman.setFrom_event("滑雪");
        sportsman.setHighest_rank(1);
        sportsman.setLatest_world_rank(2);
        sportsman.setYearly_rank(3);
        sportsman.setParticipant_count(5);

        Sportsman one = sportsmanRepository.save(sportsman);
        return one;
    }
}
