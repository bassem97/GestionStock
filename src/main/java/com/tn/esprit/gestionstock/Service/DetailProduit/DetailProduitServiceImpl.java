package com.tn.esprit.gestionstock.Service.DetailProduit;

import com.tn.esprit.gestionstock.Entities.DetailProduit;
import com.tn.esprit.gestionstock.Repository.DetailProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailProduitServiceImpl implements DetailProduitService{

    @Autowired
    private DetailProduitRepository detailProduitRepository;

    @Override
    public DetailProduit add(DetailProduit detailProduit) {
        return detailProduitRepository.save(detailProduit);
    }

    @Override
    public DetailProduit update(DetailProduit detailProduit, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        detailProduitRepository.deleteById(id);
    }

    @Override
    public List<DetailProduit> findAll() {
        return detailProduitRepository.findAll();
    }


    @Override
    public DetailProduit findById(Long id) {
        return detailProduitRepository.getById(id);
    }
}
