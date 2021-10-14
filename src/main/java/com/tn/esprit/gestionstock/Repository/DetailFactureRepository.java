package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.DetailFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailFactureRepository extends JpaRepository<DetailFacture,Long> {
}
