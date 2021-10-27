package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepository extends JpaRepository<Rayon,Long> {

}
