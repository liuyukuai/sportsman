package com.sysware.cloud.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SportsmanController {

    @GetMapping("sportsman.htm")
    public String sports(){
        return "sportsman";
    }

}
