package com.sysware.cloud.web;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AthleteController {

    @Autowired
    private AthleteService athleteService;

    @GetMapping(value = {"/","index"})
    public String sports(){
        return "index";
    }

    @GetMapping(value = "athletes")
    public String createView(){
        return "athlete_create";
    }

    /**
     * 增加
     */
    @PostMapping(value = "/athlete")
    public Athlete saveAthlete(AthleteDto athleteDto){
        return athleteService.create(athleteDto);
    }
}
