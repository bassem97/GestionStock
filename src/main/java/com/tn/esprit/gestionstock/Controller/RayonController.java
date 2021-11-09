package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Rayon;
import com.tn.esprit.gestionstock.Service.Rayon.RayonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Rayon management")
@RequestMapping("/rayon/")
public class RayonController  {

    @Autowired
    private RayonService rayonService;

    @ApiOperation(value = "Add rayon ")
    @PostMapping("add")
    public Rayon add(@Valid @RequestBody Rayon rayon) {
        return rayonService.add(rayon);
    }

    @ApiOperation(value = "Update rayon ")
    @PutMapping("update/{id}")
    public Rayon update(@Valid @RequestBody Rayon rayon,@PathVariable("id") Long id) {
        return rayonService.update(rayon, id);
    }

    @ApiOperation(value = "Delete rayon")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        rayonService.delete(id);
    }

    @ApiOperation(value = "Retreive all rayons")
    @GetMapping("list")
    public List<Rayon> findAll() {
        return rayonService.findAll();
    }

    @ApiOperation(value = "Find rayon by provided id")
    @GetMapping("findById/{id}")
    public Rayon findById(@PathVariable("id") Long id) {
        return rayonService.findById(id);
    }
}
