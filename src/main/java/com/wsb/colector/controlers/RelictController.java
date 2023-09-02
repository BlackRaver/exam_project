package com.wsb.colector.controlers;

import com.wsb.colector.models.Relict;
import com.wsb.colector.services.RelictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/relict")
public class RelictController {

    @Autowired
    private RelictService relictService;

    @GetMapping(path = "/all")
    public List<Relict> getAllRelicts(){
        return relictService.getAllRelicts();
    }

    @GetMapping(path = "/name/{rName}")
    public List<Relict> getRelictsByName(@PathVariable String rName){
        return relictService.getRelictsByName(rName);
    }

}
