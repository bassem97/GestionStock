package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
}
