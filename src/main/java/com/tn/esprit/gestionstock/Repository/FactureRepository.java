package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.User;
import com.tn.esprit.gestionstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {


    List<Facture> getFacturesByUser(Long idUser);
    List<Facture> findFacturesByUser(User user);


    @Query(value = "SELECT f FROM Facture f WHERE f.user.idUser = ?1")
    List<Facture> findFacturesByUser(Long idUser);
}
