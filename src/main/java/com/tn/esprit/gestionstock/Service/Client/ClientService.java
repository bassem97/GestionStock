package com.tn.esprit.gestionstock.Service.Client;


import com.tn.esprit.gestionstock.Entities.CategorieClient;
import com.tn.esprit.gestionstock.Entities.Client;

import java.util.Date;
import java.util.List;

public interface ClientService {
    Client add(Client client);
    Client update(Client client, Long id);
    void delete(long id);
    List<Client> findAll();
    Client findById(Long id);
    float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate);

}
