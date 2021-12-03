package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
