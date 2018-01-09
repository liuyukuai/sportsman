package com.sysware.cloud.web.api;

import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Health;
import com.sysware.cloud.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HealthController {

    @Autowired
    private HealthService healthService;

    /**
     * 增加
     */
    @PostMapping(value = "/health")
    public Health saveHealth(HealthDto healthDto){
        return healthService.saveHealth(healthDto);
    }
}
