package com.wsb.colector.repositories;

import com.wsb.colector.models.Relict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelictRepository extends JpaRepository<Relict,Long> {
    List<Relict> findAllByName(String rName);
}
