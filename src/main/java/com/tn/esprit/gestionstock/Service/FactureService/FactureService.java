package com.tn.esprit.gestionstock.Service.FactureService;

import com.tn.esprit.gestionstock.Entities.Facture;

import java.util.List;

public interface FactureService {
    Facture add(Facture facture);
    Facture update(Facture facture, Long id);
    void delete(long id);
    List<Facture> findAll();
    Facture findById(Long id);
    List<Facture> getFacturesByClient(Long idClient);
}
