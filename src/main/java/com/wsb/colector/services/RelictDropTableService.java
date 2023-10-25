package com.wsb.colector.services;

import com.wsb.colector.models.RelictDropTable;
import com.wsb.colector.repositories.RelictDropTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RelictDropTableService {

    @Autowired
    private RelictDropTableRepository relictDropTableRepository;

    public List<RelictDropTable> getAllRelicts() {
        return relictDropTableRepository.findAll();
    }

}