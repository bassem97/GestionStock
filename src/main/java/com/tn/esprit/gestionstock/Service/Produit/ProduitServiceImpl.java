package com.tn.esprit.gestionstock.Service.Produit;

import com.tn.esprit.gestionstock.Entities.Produit;
import com.tn.esprit.gestionstock.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    
    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Produit add(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit update(Produit produit, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }


    @Override
    public Produit findById(Long id) {
        return produitRepository.getById(id);
    }
}
