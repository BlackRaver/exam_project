package com.wsb.colector.repositories;

import com.wsb.colector.models.Warframe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarframeRepository extends JpaRepository<Warframe,Long> {
}
