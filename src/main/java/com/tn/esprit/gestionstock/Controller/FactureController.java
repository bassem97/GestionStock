package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Facture;
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

    @ApiOperation(value = "Add facture ")
    @PostMapping("add")
    public Facture add(@Valid @RequestBody Facture facture) {
        return factureService.add(facture);
    }

    @ApiOperation(value = "Update facture ")
    @PutMapping("update/{id}")
    public Facture update(@Valid @RequestBody Facture facture,@PathVariable("id") Long id) {
        return factureService.update(facture, id);
    }

    @ApiOperation(value = "Delete facture")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        factureService.delete(id);
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
