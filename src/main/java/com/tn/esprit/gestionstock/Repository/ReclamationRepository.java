package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {


}
