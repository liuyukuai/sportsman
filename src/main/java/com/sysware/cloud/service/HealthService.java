package com.sysware.cloud.service;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.entity.Health;

public interface HealthService {
    Health saveHealth(HealthDto healthDto);
}
