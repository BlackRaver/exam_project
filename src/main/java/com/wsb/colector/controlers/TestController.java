package com.wsb.colector.controlers;

import com.wsb.colector.models.PrimeItem;
import com.wsb.colector.models.Relict;
import com.wsb.colector.models.RelictDropTable;
import com.wsb.colector.models.Warframe;
import com.wsb.colector.repositories.PrimeItemRepository;
import com.wsb.colector.repositories.RelictDropTableRepository;
import com.wsb.colector.repositories.RelictRepository;
import com.wsb.colector.repositories.WarframeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private PrimeItemRepository primeItemRepository;

    @Autowired
    private RelictRepository relictRepository;

    @Autowired
    private WarframeRepository warframeRepository;

    @Autowired
    private RelictDropTableRepository relictDropTableRepository;

    @GetMapping(path = "/relict/test")
    public Relict Test(){

        PrimeItem p1 = new PrimeItem("wisp neurooptic",15);
        primeItemRepository.save(p1);
        PrimeItem p3 = new PrimeItem("forma",45);
        primeItemRepository.save(p3);
        PrimeItem p6 = new PrimeItem("rare",100);
        primeItemRepository.save(p6);

        Relict testowy = new Relict("E1",4);

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

        //relict.addToDropTable(primeItem);
        return relictRepository.save(relict);
   }

    @RequestMapping("/warframe/test")
    public Warframe createTestWarframe(){

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

    @RequestMapping("/feature/test1")
    public Relict testnewRelict(){
        PrimeItem p1 = new PrimeItem("Prime test 1",15);
        primeItemRepository.save(p1);
        PrimeItem p2 = new PrimeItem("Prime test 2",15);
        primeItemRepository.save(p2);
        PrimeItem p3 = new PrimeItem("Prime test 3",15);
        primeItemRepository.save(p3);
        PrimeItem p4 = new PrimeItem("Prime test 4",15);
        primeItemRepository.save(p4);
        PrimeItem p5 = new PrimeItem("Prime test 5",15);
        primeItemRepository.save(p5);
        PrimeItem p6 = new PrimeItem("Prime test 6",15);
        primeItemRepository.save(p6);

        Relict r1 = new Relict("A3",3);
        RelictDropTable rt1 = new RelictDropTable(p1,r1,"common");
        relictDropTableRepository.save(rt1);
        RelictDropTable rt2 = new RelictDropTable(p2,r1,"common");
        relictDropTableRepository.save(rt2);
        RelictDropTable rt3 = new RelictDropTable(p3,r1,"common");
        relictDropTableRepository.save(rt3);
        RelictDropTable rt4 = new RelictDropTable(p4,r1,"uncommon");
        relictDropTableRepository.save(rt4);
        RelictDropTable rt5 = new RelictDropTable(p5,r1,"uncommon");
        relictDropTableRepository.save(rt5);
        RelictDropTable rt6 = new RelictDropTable(p6,r1,"rare");
        relictDropTableRepository.save(rt6);

        r1.addToDropTable(rt1);
        r1.addToDropTable(rt2);
        r1.addToDropTable(rt3);
        r1.addToDropTable(rt4);
        r1.addToDropTable(rt5);
        r1.addToDropTable(rt6);

        return relictRepository.save(r1);
    }

    @RequestMapping("/feature/test2")
    public Relict testnewRelict2(){
        List<PrimeItem> items = new ArrayList<>();
        PrimeItem p1 = new PrimeItem("Prime test 1",15);
        PrimeItem p2 = new PrimeItem("Prime test 2",15);
        PrimeItem p3 = new PrimeItem("Prime test 3",15);
        PrimeItem p4 = new PrimeItem("Prime test 4",15);
        PrimeItem p5 = new PrimeItem("Prime test 5",15);
        PrimeItem p6 = new PrimeItem("Prime test 6",15);
        items.add(p1);
        items.add(p2);
        items.add(p3);
        items.add(p4);
        items.add(p5);
        items.add(p6);
        primeItemRepository.saveAll(items);

        Relict r1 = new Relict("A3",3);
        RelictDropTable rt1 = new RelictDropTable(p1,r1,"common");
        relictDropTableRepository.save(rt1);
        RelictDropTable rt2 = new RelictDropTable(p2,r1,"common");
        relictDropTableRepository.save(rt2);
        RelictDropTable rt3 = new RelictDropTable(p3,r1,"common");
        relictDropTableRepository.save(rt3);
        RelictDropTable rt4 = new RelictDropTable(p4,r1,"uncommon");
        relictDropTableRepository.save(rt4);
        RelictDropTable rt5 = new RelictDropTable(p5,r1,"uncommon");
        relictDropTableRepository.save(rt5);
        RelictDropTable rt6 = new RelictDropTable(p6,r1,"rare");
        relictDropTableRepository.save(rt6);

        r1.addToDropTable(rt1);
        r1.addToDropTable(rt2);
        r1.addToDropTable(rt3);
        r1.addToDropTable(rt4);
        r1.addToDropTable(rt5);
        r1.addToDropTable(rt6);

        return relictRepository.save(r1);
    }

    @PostMapping("/feature/test3")
    public ResponseEntity<?> InsertNewWarframe(@RequestBody Relict relict){
        Relict result = relictRepository.save(relict);
    return new ResponseEntity <>(result,HttpStatus.CREATED );
    }

}
