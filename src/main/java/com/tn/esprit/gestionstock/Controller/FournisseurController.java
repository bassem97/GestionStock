package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Service.Fournisseur.FournisseurService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Fournisseur management")
@RequestMapping("/fournisseur/")
public class FournisseurController  {

    @Autowired
    private FournisseurService fournisseurService;

    @ApiOperation(value = "Add fournisseur ")
    @PostMapping("add")
    public Fournisseur add(@Valid @RequestBody Fournisseur fournisseur) {
        return fournisseurService.add(fournisseur);
    }

    @ApiOperation(value = "Update fournisseur ")
    @PutMapping("update/{id}")
    public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur,@PathVariable("id") Long id) {
        return fournisseurService.update(fournisseur, id);
    }

    @ApiOperation(value = "Delete fournisseur")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        fournisseurService.delete(id);
    }

    @ApiOperation(value = "Retreive all fournisseurs")
    @GetMapping("list")
    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }

    @ApiOperation(value = "Find fournisseur by provided id")
    @GetMapping("findById/{id}")
    public Fournisseur findById(@PathVariable("id") Long id) {
        return fournisseurService.findById(id);
    }
}
