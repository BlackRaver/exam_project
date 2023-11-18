package com.wsb.colector.services;

import com.wsb.colector.models.PrimeItem;
import com.wsb.colector.repositories.PrimeItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrimeItemService {

    @Autowired
    private PrimeItemRepository primeItemRepository;


    public List<PrimeItem> getAllPrimeItems() {
        return primeItemRepository.findAll();
    }

    public Optional<PrimeItem> getPrimeItemByName(String name){
        return primeItemRepository.findByName(name);
    }

}
