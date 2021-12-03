package com.tn.esprit.gestionstock.Config.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedByOrder {
    @Autowired
    private UserSeeder userSeeder;

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

    @Autowired
    private RoleSeeder roleSeeder;


    public void init() throws Exception {
        roleSeeder.seed();
        userSeeder.seed();
        factureSeeder.seed();
        stockSeeder.seed();
        rayonSeeder.seed();
        produitSeeder.seed();
        fournisseurSeeder.seed();
        detailFactureSeeder.seed();
    }
}
