package com.tn.esprit.gestionstock.Configurations.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedByOrder {
    @Autowired
    private ClientSeeder clientSeeder;

    @Autowired
    private FactureSeeder factureSeeder;

    @Autowired
    private ProduitSeeder produitSeeder;

    @Autowired
    private StockSeeder stockSeeder;

    @Autowired
    private RayonSeeder rayonSeeder;

    @Autowired
    private DetailFactureSeeder detailFactureSeeder;

    @Autowired
    private FournisseurSeeder fournisseurSeeder;


    public void init() throws Exception {
        clientSeeder.seed();
        factureSeeder.seed();
        stockSeeder.seed();
        rayonSeeder.seed();
        produitSeeder.seed();
        fournisseurSeeder.seed();
        detailFactureSeeder.seed();
    }
}
