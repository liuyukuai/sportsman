package com.sysware.cloud.web.view;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AthleteViewController {

    @GetMapping(value = {"/","index"})
    public String sports(){
        return "index";
    }

    @GetMapping(value = "athletes")
    public String createAthlete(){
        return "athlete_create";
    }
}
