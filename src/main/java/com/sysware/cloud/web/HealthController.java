package com.sysware.cloud.web;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.entity.Health;
import com.sysware.cloud.service.AthleteService;
import com.sysware.cloud.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("sportsman.htm")
    public String sports(){
        return "sportsman";
    }

    /**
     * 增加
     */
    @PostMapping(value = "/health")
    public Health saveHealth(HealthDto healthDto){

        return healthService.saveHealth(healthDto);
    }
}
