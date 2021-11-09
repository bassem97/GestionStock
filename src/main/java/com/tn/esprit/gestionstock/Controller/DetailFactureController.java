package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.DetailFacture;
import com.tn.esprit.gestionstock.Service.DetailFacture.DetailFactureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "DetailFacture management")
@RequestMapping("/detailFacture/")
public class DetailFactureController  {

    @Autowired
    private DetailFactureService detailFactureService;

    @ApiOperation(value = "Add detailFacture ")
    @PostMapping("add")
    public DetailFacture add(@Valid @RequestBody DetailFacture detailFacture) {
        return detailFactureService.add(detailFacture);
    }

    @ApiOperation(value = "Update detailFacture ")
    @PutMapping("update/{id}")
    public DetailFacture update(@Valid @RequestBody DetailFacture detailFacture,@PathVariable("id") Long id) {
        return detailFactureService.update(detailFacture, id);
    }

    @ApiOperation(value = "Delete detailFacture")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        detailFactureService.delete(id);
    }

    @ApiOperation(value = "Retreive all detailFactures")
    @GetMapping("list")
    public List<DetailFacture> findAll() {
        return detailFactureService.findAll();
    }

    @ApiOperation(value = "Find detailFacture by provided id")
    @GetMapping("findById/{id}")
    public DetailFacture findById(@PathVariable("id") Long id) {
        return detailFactureService.findById(id);
    }
}
