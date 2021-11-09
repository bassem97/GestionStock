package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.DetailProduit;
import com.tn.esprit.gestionstock.Service.DetailProduit.DetailProduitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "DetailProduit management")
@RequestMapping("/detailProduit/")
public class DetailProduitController  {

    @Autowired
    private DetailProduitService detailProduitService;

    @ApiOperation(value = "Add detailProduit ")
    @PostMapping("add")
    public DetailProduit add(@Valid @RequestBody DetailProduit detailProduit) {
        return detailProduitService.add(detailProduit);
    }

    @ApiOperation(value = "Update detailProduit ")
    @PutMapping("update/{id}")
    public DetailProduit update(@Valid @RequestBody DetailProduit detailProduit,@PathVariable("id") Long id) {
        return detailProduitService.update(detailProduit, id);
    }

    @ApiOperation(value = "Delete detailProduit")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        detailProduitService.delete(id);
    }

    @ApiOperation(value = "Retreive all detailProduits")
    @GetMapping("list")
    public List<DetailProduit> findAll() {
        return detailProduitService.findAll();
    }

    @ApiOperation(value = "Find detailProduit by provided id")
    @GetMapping("findById/{id}")
    public DetailProduit findById(@PathVariable("id") Long id) {
        return detailProduitService.findById(id);
    }
}
