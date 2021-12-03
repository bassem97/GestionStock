package com.tn.esprit.gestionstock.Service.Produit;


import com.tn.esprit.gestionstock.Entities.Produit;

import java.util.Date;
import java.util.List;

public interface ProduitService {
    Produit add(Produit produit);
    Produit update(Produit produit, Long id);
    void delete(long id);
    List<Produit> findAll();
    Produit findById(Long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
    void retrieveStatusStock();

}
