package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Client;
import com.tn.esprit.gestionstock.Service.Client.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@Api(tags = "Client management")
@RequestMapping("/client/")
public class ClientController  {

    @Autowired
    private ClientService clientService;

    @ApiOperation(value = "Add client ")
    @PostMapping("add")
    public Client add(@Valid @RequestBody Client client) {
        return clientService.add(client);
    }

    @ApiOperation(value = "Update client ")
    @PutMapping("update/{id}")
    public Client update(@Valid @RequestBody Client client,@PathVariable("id") Long id) {
        return clientService.update(client, id);
    }

    @ApiOperation(value = "Delete client")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        clientService.delete(id);
    }

    @ApiOperation(value = "Retreive all clients")
    @GetMapping("list")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @ApiOperation(value = "Find client by provided id")
    @GetMapping("findById/{id}")
    public Client findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }
}
