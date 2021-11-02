package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.CategorieClient;
import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Service.Client.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;

    @Test
    public void testAddClient() {
        List<Client> clients = clientService.findAll();
        int expected = clients.size();
        Client client = new Client("bassem", "jadoui", "bassem.jadoui1@esprit.tn", "123456", CategorieClient.Fidele);
        Client savedClient = clientService.add(client);
        assertEquals(expected + 1, clientService.findAll().size());
        assertNotNull(savedClient.getNom());
        clientService.delete(savedClient.getIdClient());
    }

    @Test
    public void testListClient() {
        clientService.findAll()
                .forEach( client -> log.info("Client :"+ client));
    }
}