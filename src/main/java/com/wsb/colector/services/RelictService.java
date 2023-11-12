package com.wsb.colector.services;

import com.wsb.colector.models.PrimeItem;
import com.wsb.colector.models.Relict;
import com.wsb.colector.models.RelictDropTable;
import com.wsb.colector.models.RelictWithDropTable;
import com.wsb.colector.repositories.PrimeItemRepository;
import com.wsb.colector.repositories.RelictDropTableRepository;
import com.wsb.colector.repositories.RelictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelictService {

    @Autowired
    private RelictRepository relictRepository;

    @Autowired
    private RelictDropTableRepository relictDropTableRepository;

    @Autowired
    private PrimeItemRepository primeItemRepository;

    public List<Relict> getAllRelicts() {
        return relictRepository.findAll();
    }

    public List<Relict> getRelictsByName(String rName) {
        return relictRepository.findAllByName(rName) ;
    }

    public void saveNewRelict(Relict relict) {
        relictRepository.save(relict);
    }

    public void doIt(RelictWithDropTable relictWithDropTable) {

        Relict newRelict = new Relict(
                relictWithDropTable.getRelict().getName(),
                relictWithDropTable.getRelict().getTier()
        );

        PrimeItem[] items = new PrimeItem[6];
        RelictDropTable[] drops = new RelictDropTable[6];
        for(int i=0; i<relictWithDropTable.getDropList().size();i++){
            items[i] = new PrimeItem(
                    relictWithDropTable.getDropList().get(i).getPrimeItem().getName(),
                    relictWithDropTable.getDropList().get(i).getPrimeItem().getDucats()
            );
            primeItemRepository.save(items[i]);
            drops[i] = new RelictDropTable(
                    items[i],
                    newRelict,
                    relictWithDropTable.getDropList().get(i).getRarity()
            );
            relictDropTableRepository.save(drops[i]);
        }
        relictRepository.save(newRelict);

    }
}
