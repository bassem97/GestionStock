package com.tn.esprit.gestionstock.Service.Client;

import com.tn.esprit.gestionstock.Entities.CategorieClient;
import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
        if(clientRepository.findById(id).isPresent()){
            Client cl = clientRepository.findById(id).get();
            cl.setNom(client.getNom());
            cl.setPrenom(client.getPrenom());
            cl.setEmail(client.getEmail());
            cl.setPassword(client.getPassword());
            cl.setDateNaissance(client.getDateNaissance());
            cl.setProffesion(client.getProffesion());
            cl.setCategorieClient(client.getCategorieClient());
            cl.setFactures(client.getFactures());
            return clientRepository.save(cl);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    @Override
    public Client findById(Long id) {
        return clientRepository.getById(id);
    }

    @Override
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date startDate, Date endDate) {
        return (float) clientRepository.findAllByCategorieClient(categorieClient)
                .stream()
                .mapToDouble(client -> client.getFactures()
                        .stream()
                        .filter(facture -> facture.getDateFacture().after(startDate) && facture.getDateFacture().before(endDate))
                        .mapToDouble(Facture::getMontantFacture)
                        .sum())
                .sum();

    }
}
