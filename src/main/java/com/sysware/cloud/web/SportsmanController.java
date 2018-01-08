package com.sysware.cloud.web;

import com.sysware.cloud.dto.SportsmanDto;
import com.sysware.cloud.entity.Sportsman;
import com.sysware.cloud.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class SportsmanController {

    @Autowired
    private SportsmanService sportsmanService;

    @GetMapping("sportsman.htm")
    public String sports(){
        return "sportsman";
    }

    /**
     * 增加
     */
    @PostMapping(value = "/sportsman")
    public Sportsman addSportsman(SportsmanDto sportsmanDto){
        return sportsmanService.addSportsman(sportsmanDto);
    }
}
