package com.tn.esprit.gestionstock.Service.DetailFacture;

import com.tn.esprit.gestionstock.Entities.DetailFacture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetailFactureService {
    DetailFacture add(DetailFacture detailFacture);
    DetailFacture update(DetailFacture detailFacture, Long id);
    void delete(long id);
    List<DetailFacture> findAll();
    DetailFacture findById(Long id);
}
