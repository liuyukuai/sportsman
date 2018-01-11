package com.sysware.cloud.web.api;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.entity.Health;
import com.sysware.cloud.service.HealthService;
import com.sysware.cloud.utils.json.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class HealthController {

    @Autowired
    private HealthService healthService;


    /**
     * 創建健康
     */
    @PostMapping(value = "/health")
    public Response<String> saveHealth(@RequestBody @Valid HealthDto healthDto){
        return Response.success(healthService.saveHealth(healthDto).getId());
    }

    @GetMapping(value = "/health/{id}")
    public Response<Health> getHealth(@PathVariable String id){
        return Response.success(healthService.getById(id));
    }

}
