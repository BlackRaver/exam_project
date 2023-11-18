package com.wsb.colector.repositories;

import com.wsb.colector.models.PrimeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrimeItemRepository extends JpaRepository<PrimeItem,Long> {
    Optional<PrimeItem> findByName(String name);
}
