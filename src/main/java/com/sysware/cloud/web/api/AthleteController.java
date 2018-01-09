package com.sysware.cloud.web.api;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.KV;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.enums.ItemEnum;
import com.sysware.cloud.service.AthleteService;
import com.sysware.cloud.utils.json.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AthleteController {

    @Autowired
    private AthleteService athleteService;



    @GetMapping(value = "/items")
    public Response<List<KV>> items(){
        ItemEnum[] items =  ItemEnum.values();
        List<KV> kvs = new ArrayList<>();
        for (ItemEnum item:items) {
            kvs.add(new KV(item.getId(),item.getValue()));
        }
        return Response.success(kvs);
    }

    /**
     * 創建運動員
     */
    @PostMapping(value = "/athlete")
    public Response<String> saveAthlete(@RequestBody @Valid AthleteDto athleteDto){
        return Response.success(athleteService.create(athleteDto).getId());
    }

    @GetMapping(value = "/athlete/{id}")
    public Response<Athlete> getAthlete(@PathVariable String id){
        return Response.success(athleteService.getById(id));
    }


}
