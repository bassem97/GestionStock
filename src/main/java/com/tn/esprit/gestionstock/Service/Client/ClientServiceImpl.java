package com.tn.esprit.gestionstock.Service.Client;

import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
