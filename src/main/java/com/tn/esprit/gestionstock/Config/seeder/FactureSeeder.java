package com.tn.esprit.gestionstock.Config.seeder;

import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Service.FactureService.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FactureSeeder {

    @Autowired
    FactureService factureService;

    @Autowired
    private UserSeeder userSeeder;

    public Facture  facture1;
    public Facture  facture2;
    public Facture  facture3;



    public  void seed(){
        facture1 = new Facture(15F,50F, userSeeder.user1);
        facture2 = new Facture(3F,30F,userSeeder.user2);
        facture3 = new Facture(10F,50F,userSeeder.user3);
        factureService.add(facture1);
        factureService.add(facture2);
        factureService.add(facture3);

    }
}
