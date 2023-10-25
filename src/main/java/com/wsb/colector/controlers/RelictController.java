package com.wsb.colector.controlers;

import com.wsb.colector.models.Relict;
import com.wsb.colector.services.RelictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "addOne")
    public ResponseEntity<Relict> addOneRelict(@RequestBody Relict relict){
        relictService.saveNewRelict(relict);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}