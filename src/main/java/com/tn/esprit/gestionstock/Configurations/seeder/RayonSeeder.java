package com.tn.esprit.gestionstock.Configurations.seeder;

import com.tn.esprit.gestionstock.Entities.Rayon;
import com.tn.esprit.gestionstock.Service.Rayon.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RayonSeeder {

    @Autowired
    RayonService rayonService;

    public Rayon rayon1;
    public Rayon rayon2;
    public Rayon rayon3;

    public void seed(){
        rayon1 = new Rayon("RA1","Rayon 1");
        rayon2 = new Rayon("RA2","Rayon 2");
        rayon3 = new Rayon("RA3","Rayon 3");

        rayonService.add(rayon1);
        rayonService.add(rayon2);
        rayonService.add(rayon3);
    }
}
