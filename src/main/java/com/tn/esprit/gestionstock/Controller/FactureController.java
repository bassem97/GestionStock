package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import com.tn.esprit.gestionstock.Service.FactureService.FactureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Facture management")
@RequestMapping("/facture/")
public class FactureController  {

    @Autowired
    private FactureService factureService;
    @Autowired
    WebSocketController webSocketController;

    @ApiOperation(value = "Add facture ")
    @PostMapping("add")
    public Facture add(@Valid @RequestBody Facture facture) {
        Facture add = factureService.add(facture);
        webSocketController.sendMessage(new WebSocketMessage("add facture"+facture.getIdFacture()));
        return add;
    }


    @ApiOperation(value = "Update facture ")
    @PutMapping("update/{id}")
    public Facture update(@Valid @RequestBody Facture facture,@PathVariable("id") Long id) {
        Facture update = factureService.update(facture, id);
        webSocketController.sendMessage(new WebSocketMessage("update Facture"));
        return update;
    }

    @ApiOperation(value = "Delete facture")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        factureService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("delete Facture"));
    }

    @ApiOperation(value = "Retreive all factures")
    @GetMapping("list")
    public List<Facture> findAll() {
        return factureService.findAll();
    }

    @ApiOperation(value = "Find facture by provided id")
    @GetMapping("findById/{id}")
    public Facture findById(@PathVariable("id") Long id) {
        return factureService.findById(id);
    }
}
