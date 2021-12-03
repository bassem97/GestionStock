package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
}
