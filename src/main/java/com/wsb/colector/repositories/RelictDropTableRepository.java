package com.wsb.colector.repositories;

import com.wsb.colector.models.RelictDropTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelictDropTableRepository extends JpaRepository<RelictDropTable,Long> {
}
