package com.tn.esprit.gestionstock.Service.Fournisseur;

import com.tn.esprit.gestionstock.Entities.Fournisseur;

import java.util.List;

public interface FournisseurService {
    Fournisseur add(Fournisseur fournisseur);
    Fournisseur update(Fournisseur fournisseur, Long id);
    void delete(long id);
    List<Fournisseur> findAll();
    Fournisseur findById(Long id);
    void assignFournisseurToProduit(Long fournisseurId, Long produitId);

}
