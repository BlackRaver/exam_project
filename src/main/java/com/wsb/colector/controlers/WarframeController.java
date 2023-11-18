package com.wsb.colector.controlers;

import com.wsb.colector.models.Warframe;
import com.wsb.colector.services.WarframeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/warframe")
public class WarframeController {

    @Autowired
    private WarframeService warframeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<Warframe>> getAllWarframes(){
        return new ResponseEntity<>(warframeService.getAllWarframes(),HttpStatus.OK);
    }

    @GetMapping(path = "/name/{name}")
    public Warframe getWarframeByName(@PathVariable String name){
        return warframeService.getWarframeByName(name);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<?> saveWarframe(@RequestBody Warframe warframe){
        warframeService.saveNewWarframe(warframe);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
