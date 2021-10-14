package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Service.Client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/client/")
public class ClientController  {

    @Autowired
    private ClientService clientService;


    @PostMapping("add")
    public Client add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @PutMapping("update/{id}")
    public Client update(@Valid @RequestBody Client client,@PathVariable("id") Long id) {
        return clientService.update(client, id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        clientService.delete(id);
    }

    @GetMapping("list")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("findById/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }
}
