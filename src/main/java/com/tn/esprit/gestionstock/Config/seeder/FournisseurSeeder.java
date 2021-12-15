package com.tn.esprit.gestionstock.Config.seeder;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Service.Fournisseur.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class FournisseurSeeder {
    @Autowired
    FournisseurService fournisseurService;

    @Autowired
    ProduitSeeder produitSeeder;

    public Fournisseur fournisseur1;
    public Fournisseur fournisseur2;

    public void seed(){
        fournisseur1 = new Fournisseur("F1","Fournisseur 1","avatar1","36.77925482803498, 9.90715481499987");
        fournisseur1.setProduits(Arrays.asList(produitSeeder.produit1, produitSeeder.produit2));
        fournisseur2 = new Fournisseur("F2","Fournisseur 2","avatar2","36.77925482803498, 9.90715481499987");

        fournisseur2.setProduits(Collections.singletonList(produitSeeder.produit3));
//
        fournisseurService.addFournisseur(fournisseur1);
        fournisseurService.addFournisseur(fournisseur2);

    }
}
