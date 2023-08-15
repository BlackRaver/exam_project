package com.wsb.colector.controlers;

import com.wsb.colector.models.PrimeItem;
import com.wsb.colector.models.Relict;
import com.wsb.colector.models.Warframe;
import com.wsb.colector.repositories.PrimeItemRepository;
import com.wsb.colector.repositories.RelictRepository;
import com.wsb.colector.repositories.WarframeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestControlLer {

    @Autowired
    PrimeItemRepository primeItemRepository;

    @Autowired
    RelictRepository relictRepository;

    @Autowired
    WarframeRepository warframeRepository;

    @GetMapping(path = "/relict/test")
    public Relict Test(){

        PrimeItem p1 = new PrimeItem("wisp neurooptic",15);
        primeItemRepository.save(p1);
        PrimeItem p3 = new PrimeItem("forma",45);
        primeItemRepository.save(p3);
        PrimeItem p6 = new PrimeItem("rare",100);
        primeItemRepository.save(p6);

        Relict testowy = new Relict("E1",4,p1);

        return relictRepository.save(testowy);
    }

    @PostMapping("/new/relict")
    Relict createRelict(@RequestBody Relict relict) {
        return relictRepository.save(relict);
    }

    @PostMapping("/new/primeItem")
    PrimeItem createPrimeItem(@RequestBody PrimeItem primeItem) {
        return primeItemRepository.save(primeItem);
    }

   @PutMapping("/relict/{relictId}/item/{primeItemId}")
    Relict createDropTable(
            @PathVariable Long relictId,
            @PathVariable Long primeItemId
   ) {
        Relict relict = relictRepository.findById(relictId).get();
        PrimeItem primeItem = primeItemRepository.findById(primeItemId).get();
        relict.addToDropTable(primeItem);
        return relictRepository.save(relict);
   }

    @RequestMapping("/warframe/test")
    Warframe createTestWarframe(){

        PrimeItem p1 = new PrimeItem("Excalibur Prime Neuroptics",15);
        primeItemRepository.save(p1);
        PrimeItem p3 = new PrimeItem("Excalibur Prime Blueprint",45);
        primeItemRepository.save(p3);
        PrimeItem p6 = new PrimeItem("Excalibur Prime chassis",65);
        primeItemRepository.save(p6);
        PrimeItem p2 = new PrimeItem("Excalibur Prime Systems",100);
        primeItemRepository.save(p2);

        Warframe warframe = new Warframe("Excalibur Prime",p3,p1,p6,p2);

        return warframeRepository.save(warframe);
    }


}
