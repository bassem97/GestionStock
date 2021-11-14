package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureRepository extends JpaRepository<Facture,Long> {


    List<Facture> getFacturesByClient(Long idClient);
    List<Facture> findFacturesByClient(Client client);


    @Query(value = "SELECT f FROM Facture f WHERE f.client.idClient = ?1")
    List<Facture> findFacturesByClient(Long idClient);
}
