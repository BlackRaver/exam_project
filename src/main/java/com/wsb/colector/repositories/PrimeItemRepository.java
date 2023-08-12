package com.wsb.colector.repositories;

import com.wsb.colector.models.PrimeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimeItemRepository extends JpaRepository<PrimeItem,Long> {
}
