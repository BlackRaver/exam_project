package com.wsb.colector.controlers;


import com.wsb.colector.models.PrimeItem;
import com.wsb.colector.services.PrimeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/primeItem")
public class PrimeItemController {

    @Autowired
    private PrimeItemService primeItemService;

    @GetMapping(path = "/all")
    public List<PrimeItem> getAllPrimeItems(){
      return primeItemService.getAllPrimeItems();
    }

}
