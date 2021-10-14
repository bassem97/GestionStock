package com.tn.esprit.gestionstock.Service.Fournisseur;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Override
    public Fournisseur add(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        fournisseurRepository.deleteById(id);
    }

    @Override
    public List<Fournisseur> findAll() {
        return fournisseurRepository.findAll();
    }


    @Override
    public Fournisseur findById(Long id) {
        return fournisseurRepository.getById(id);
    }
}
