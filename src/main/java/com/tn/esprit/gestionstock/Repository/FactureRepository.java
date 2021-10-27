package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {

}
