package com.tn.esprit.gestionstock.Configurations.seeder;

import com.tn.esprit.gestionstock.Entities.CategorieClient;
import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Entities.Profession;
import com.tn.esprit.gestionstock.Service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class ClientSeeder {

    @Autowired
    private ClientService clientService;

    public Client client1;
    public Client client2 ;
    public Client client3 ;


    public void seed(){
        client1  = new Client("bassem","jadoui", new Date(97, Calendar.MAY,20),"bassem.jadoui@esprit.tn","123456", CategorieClient.Premium, Profession.Etudiant);
        client2  = new Client("karim","manai", new Date(98, Calendar.JANUARY,12),"karim.manai@esprit.tn","123456", CategorieClient.Fidele, Profession.Docteur);
        client3  = new Client("mounir","hmidi", new Date(97, Calendar.NOVEMBER,3),"mounir.hmidi@esprit.tn","123456", CategorieClient.Fidele, Profession.Commercial);
       clientService.add(client1);
        clientService.add(client2);
        clientService.add(client3);
    }
}
