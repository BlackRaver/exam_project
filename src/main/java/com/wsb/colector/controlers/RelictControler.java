package com.wsb.colector.controlers;

import com.wsb.colector.models.Relict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RelictControler {

    @GetMapping(path = "/relict/test")
    public ResponseEntity<?> Test(){
        Relict testowy = new Relict(UUID.randomUUID(),"N3","hydroid");
        return new ResponseEntity<Relict>(testowy, HttpStatus.OK);
    }
}
