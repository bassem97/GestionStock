package com.tn.esprit.gestionstock.Controller;

import com.tn.esprit.gestionstock.Entities.Reclamation;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import com.tn.esprit.gestionstock.Service.Reclamation.ReclamationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(tags = "Reclamation management")
@RequestMapping("/reclamation/")
public class ReclamationController {

    @Autowired
    private ReclamationService reclamationService;

    @Autowired
    WebSocketController webSocketController;

    @ApiOperation(value = "Add reclamation ")
    @PostMapping("add")
    public Reclamation add(@Valid @RequestBody Reclamation reclamation) {
        webSocketController.sendMessage(new WebSocketMessage("add reclamation "));
        return reclamationService.add(reclamation);
    }

    @ApiOperation(value = "Update reclamation ")
    @PutMapping("update/{id}")
    public Reclamation update(@Valid @RequestBody Reclamation reclamation,@PathVariable("id") Long id) {
        return reclamationService.update(reclamation, id);
    }

    @ApiOperation(value = "Delete reclamation")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) {
        reclamationService.delete(id);
    }

    @ApiOperation(value = "Retreive all clients")
    @GetMapping("list")
    public List<Reclamation> findAll() {
        return reclamationService.findAll();
    }

    @ApiOperation(value = "Find reclamation by provided id")
    @GetMapping("findById/{id}")
    public Reclamation findById(@PathVariable("id") Long id) {
        return reclamationService.findById(id);
    }
}
