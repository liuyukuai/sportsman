package com.sysware.cloud.service;

import com.sysware.cloud.dto.SportsmanDto;
import com.sysware.cloud.entity.Sportsman;

public interface SportsmanService {
    Sportsman addSportsman(SportsmanDto sportsmanDto);
}
