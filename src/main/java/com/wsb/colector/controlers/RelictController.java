package com.wsb.colector.controlers;

import com.wsb.colector.models.Relict;
import com.wsb.colector.models.RelictDropTable;
import com.wsb.colector.models.RelictWithDropTable;
import com.wsb.colector.services.RelictDropTableService;
import com.wsb.colector.services.RelictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(path = "/relict")
public class RelictController {

    @Autowired
    private RelictService relictService;
    @Autowired
    private RelictDropTableService relictDropTableService;

    @GetMapping(path = "/all")
    public List<Relict> getAllRelicts(){
        return relictService.getAllRelicts();
    }

    @GetMapping(path = "/name/{rName}")
    public List<Relict> getRelictsByName(@PathVariable String rName){
        return relictService.getRelictsByName(rName);
    }

    @PostMapping(path = "/addOne")
    public ResponseEntity<Relict> addOneRelict(@RequestBody Relict relict){
        relictService.saveNewRelict(relict);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getRelictById(@PathVariable long id){
        Optional<Relict> relict = relictService.getById(id);
        if(relict.isPresent()){
            return new ResponseEntity<Relict>(relict.get(),HttpStatus.OK);
        }
        return new ResponseEntity<String>("Bład!!! Nie znaleziono szczegółów Reliktu o takim ID.",HttpStatus.NO_CONTENT);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createCompleteRelict(@RequestBody RelictWithDropTable relictWithDropTable){
        relictService.createCompleteRelict(relictWithDropTable);
        return new ResponseEntity <>(HttpStatus.CREATED );
    }

}
