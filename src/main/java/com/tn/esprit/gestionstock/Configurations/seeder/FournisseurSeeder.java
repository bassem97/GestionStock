package com.tn.esprit.gestionstock.Configurations.seeder;

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
        fournisseur1 = new Fournisseur("F1","Fournisseur 1");
        fournisseur1.setProduits(Arrays.asList(produitSeeder.produit1, produitSeeder.produit2));
        fournisseur2 = new Fournisseur("F2","Fournisseur 2");
        fournisseur2.setProduits(Collections.singletonList(produitSeeder.produit3));

        fournisseurService.add(fournisseur1);
        fournisseurService.add(fournisseur2);

    }
}
