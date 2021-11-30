package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Produit;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import com.tn.esprit.gestionstock.Service.Produit.ProduitService;
import com.tn.esprit.gestionstock.Service.Produit.ProduitServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Produit management")
@RequestMapping("/produit/")
public class ProduitController  {

    @Autowired
    private ProduitService produitService;

    @Autowired
    WebSocketController webSocketController;

    @ApiOperation(value = "Add produit ")
    @PostMapping("add")
    public Produit add(@Valid @RequestBody Produit produit)  {
        Produit p = produitService.add(produit);
        webSocketController.sendMessage(new WebSocketMessage("add produit "+p.getIdProduit(),p.getIdProduit()));
        return p;
    }

    @ApiOperation(value = "Update produit ")
    @PutMapping("update/{id}")
    public Produit update(@Valid @RequestBody Produit produit,@PathVariable("id") Long id) {
        produit.getDetailProduit().setDateDerniereModification(new Date());
        webSocketController.sendMessage(new WebSocketMessage("update produit "+id,id));
        return produitService.update(produit, id);
    }

    @ApiOperation(value = "Delete produit")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        webSocketController.sendMessage(new WebSocketMessage("delete produit "+id,id));
        produitService.delete(id);
    }

    @ApiOperation(value = "Retreive all produits")
    @GetMapping("list")
    public List<Produit> findAll() {
        return produitService.findAll();
    }

    @ApiOperation(value = "Find produit by provided id")
    @GetMapping("findById/{id}")
    public Produit findById(@PathVariable("id") Long id) {
        return produitService.findById(id);
    }
}
