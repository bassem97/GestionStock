package com.tn.esprit.gestionstock.Service.DetailFacture;

import com.tn.esprit.gestionstock.Entities.DetailFacture;
import com.tn.esprit.gestionstock.Repository.DetailFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService{

    @Autowired
    private DetailFactureRepository detailFactureRepository;

    @Override
    public DetailFacture add(DetailFacture detailFacture) {
        return detailFactureRepository.save(detailFacture);
    }

    @Override
    public DetailFacture update(DetailFacture detailFacture, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        detailFactureRepository.deleteById(id);
    }

    @Override
    public List<DetailFacture> findAll() {
        return detailFactureRepository.findAll();
    }


    @Override
    public DetailFacture findById(Long id) {
        return detailFactureRepository.getById(id);
    }
}
