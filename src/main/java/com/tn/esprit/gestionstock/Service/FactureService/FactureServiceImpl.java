package com.tn.esprit.gestionstock.Service.FactureService;

import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Repository.UserRepository;
import com.tn.esprit.gestionstock.Repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
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
        return factureRepository.getById(id);
    }

    @Override
    public List<Facture> getFacturesByUser(Long idUser) {
//        return factureRepository.findAll()
//                .stream()
//                .filter(facture -> facture.getUser().getIdUser().equals(idUser))
//                .collect(Collectors.toList());
//        return factureRepository.findFacturesByUser(userRepository.findById(idUser).get());
        return factureRepository.findFacturesByUser(idUser);
    }
}
