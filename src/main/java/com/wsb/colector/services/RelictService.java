package com.wsb.colector.services;

import com.wsb.colector.models.Relict;
import com.wsb.colector.repositories.RelictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelictService {

    @Autowired
    private RelictRepository relictRepository;

    public List<Relict> getAllRelicts() {
        return relictRepository.findAll();
    }

    public List<Relict> getRelictsByName(String rName) {
        return relictRepository.findAllByName(rName) ;
    }

    public void saveNewRelict(Relict relict) {
        relictRepository.save(relict);
    }
}
