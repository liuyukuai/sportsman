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

    @GetMapping("sportsman.htm")
    public String sports(){
        return "sportsman";
    }

    /**
     * 增加
     */
    @PostMapping(value = "/sportsman")
    public Athlete addSportsman(AthleteDto athleteDto){
        return athleteService.saveAthlete(athleteDto);
    }
}
