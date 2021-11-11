package com.tn.esprit.gestionstock.Configurations.seeder;

import com.tn.esprit.gestionstock.Entities.DetailFacture;
import com.tn.esprit.gestionstock.Service.DetailFacture.DetailFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailFactureSeeder {

    @Autowired
    DetailFactureService detailFactureService;

    @Autowired
    FactureSeeder factureSeeder;

    @Autowired
    ProduitSeeder produitSeeder;

    public DetailFacture detailFacture1;
    public DetailFacture detailFacture2;
    public DetailFacture detailFacture3;

    public void seed(){
        detailFacture1 = new DetailFacture(20,50F,30,15F, factureSeeder.facture1, produitSeeder.produit1);
        detailFacture2 = new DetailFacture(10,30F,10,3F, factureSeeder.facture2, produitSeeder.produit2);
        detailFacture3 = new DetailFacture(15,50F,20,10F, factureSeeder.facture3, produitSeeder.produit3);
        detailFactureService.add(detailFacture1);
        detailFactureService.add(detailFacture2);
        detailFactureService.add(detailFacture3);
    }
}
