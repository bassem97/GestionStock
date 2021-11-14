package com.tn.esprit.gestionstock.Repository;

import com.tn.esprit.gestionstock.Entities.CategorieClient;
import com.tn.esprit.gestionstock.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


    List<Client> findAllByCategorieClient(CategorieClient categorieClient);
}
