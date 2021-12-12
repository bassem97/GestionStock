package com.tn.esprit.gestionstock.Service.FactureService;

import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Repository.FactureRepository;
import com.tn.esprit.gestionstock.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureServiceImpl implements FactureService{

    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private UserRepository userRepository;




    @Override
    public Facture add(Facture facture) {
        return factureRepository.save(facture);
    }

    @Override
    public Facture update(Facture facture, Long id) {
        return factureRepository.save(facture);
    }

    @Override
    public void delete(long id) {
        factureRepository.deleteById(id);
    }

    @Override
    public List<Facture> findAll() {
        return factureRepository.findAll();
    }


    @Override
    public Facture findById(Long id) {
        return factureRepository.findById(id).get();
    }

    @Override
    public List<Facture> getFacturesByClient(Long iduser) {
        return factureRepository.findAll()
                .stream()
                .filter(facture -> facture.getUser().getIdUser().equals(iduser))
                .collect(Collectors.toList());
    }
}
