package com.wsb.colector.services;

import com.wsb.colector.models.Warframe;
import com.wsb.colector.repositories.WarframeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarframeService {

    @Autowired
    private WarframeRepository warframeRepository;

    public List<Warframe> getAllWarframes() {
        return warframeRepository.findAll();
    }

    public Warframe getWarframeByName(String name) {
        return warframeRepository.findByName(name);
    }

    public void saveNewWarframe(Warframe warframe) {
        warframeRepository.save(warframe);
    }
}
