package com.tn.esprit.gestionstock.Service.Reclamation;

import com.tn.esprit.gestionstock.Entities.Reclamation;

import java.util.List;

public interface ReclamationService {
    Reclamation add(Reclamation reclamation);
    Reclamation update(Reclamation reclamation, Long id);
    void delete(long id);
    List<Reclamation> findAll();
    Reclamation findById(Long id);

}
