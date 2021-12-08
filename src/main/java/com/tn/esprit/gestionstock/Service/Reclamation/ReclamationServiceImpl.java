package com.tn.esprit.gestionstock.Service.Reclamation;

import com.tn.esprit.gestionstock.Entities.Reclamation;
import com.tn.esprit.gestionstock.Repository.ReclamationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReclamationServiceImpl implements ReclamationService  {

    @Autowired
    ReclamationRepository reclamationRepository;

    @Override
    public Reclamation add(Reclamation reclamation) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation update(Reclamation reclamation, Long id) {
        return reclamationRepository.save(reclamation);
    }

    @Override
    public void delete(long id) {
         reclamationRepository.deleteById(id);
    }

    @Override
    public List<Reclamation> findAll() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation findById(Long id) {
        return reclamationRepository.findById(id).get();
    }
}
