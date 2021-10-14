package com.tn.esprit.gestionstock.Service.DetailProduit;

import com.tn.esprit.gestionstock.Entities.DetailProduit;

import java.util.List;

public interface DetailProduitService {
    DetailProduit add(DetailProduit detailProduit);
    DetailProduit update(DetailProduit detailProduit, Long id);
    void delete(long id);
    List<DetailProduit> findAll();
    DetailProduit findById(Long id);
}
