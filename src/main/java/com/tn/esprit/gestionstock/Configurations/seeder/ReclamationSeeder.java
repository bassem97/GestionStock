package com.tn.esprit.gestionstock.Configurations.seeder;

import com.tn.esprit.gestionstock.Entities.Reclamation;
import com.tn.esprit.gestionstock.Repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReclamationSeeder {

    @Autowired
    ReclamationRepository reclamationRepository;

    @Autowired
    ProduitSeeder produitSeeder;

    @Autowired
    ClientSeeder clientSeeder;

    public void seed(){
        Reclamation reclamation1 = new Reclamation("avis defavorable 1 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta.", produitSeeder.produit1, clientSeeder.client1);
        Reclamation reclamation2 = new Reclamation("avis defavorable 2 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta.", produitSeeder.produit2, clientSeeder.client2);
        Reclamation reclamation3 = new Reclamation("avis defavorable 3 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta. ", produitSeeder.produit3, clientSeeder.client3);
        Reclamation reclamation4 = new Reclamation("avis defavorable 4 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta. ", produitSeeder.produit3, clientSeeder.client3);
        Reclamation reclamation5 = new Reclamation("avis defavorable 5 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta. ", produitSeeder.produit2, clientSeeder.client2);
        Reclamation reclamation6 = new Reclamation("avis defavorable 6 ","Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aliquam amet assumenda blanditiis dolore eaque eos esse et fugit, incidunt nihil, odit quam quibusdam saepe unde, veritatis vero vitae. Dicta. ", produitSeeder.produit1, clientSeeder.client1);

        reclamationRepository.save(reclamation1);
        reclamationRepository.save(reclamation2);
        reclamationRepository.save(reclamation3);
        reclamationRepository.save(reclamation4);
//        reclamationRepository.save(reclamation5);
//        reclamationRepository.save(reclamation6);
    }
}
