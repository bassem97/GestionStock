package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProduitRepository extends JpaRepository<DetailProduit,Long> {
}
