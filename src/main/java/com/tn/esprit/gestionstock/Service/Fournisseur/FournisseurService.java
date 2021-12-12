package com.tn.esprit.gestionstock.Service.Fournisseur;

import com.tn.esprit.gestionstock.Entities.Fournisseur;

import java.util.List;

public interface FournisseurService {
    List<Fournisseur> retrieveAllFournisseurs();
    Fournisseur addFournisseur(Fournisseur f);
    void deleteFournisseur(Long id);
    Fournisseur updateFournisseur(Fournisseur f);
    Fournisseur retrieveFournisseur(Long id);
    void assignFournisseurToProduit(Long fournisseurId, Long produitId);

}
