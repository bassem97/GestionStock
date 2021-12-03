package com.tn.esprit.gestionstock.Service.Rayon;

import com.tn.esprit.gestionstock.Entities.Rayon;
import com.tn.esprit.gestionstock.Repository.RayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RayonServiceImpl implements RayonService{

    @Autowired
    private RayonRepository rayonRepository;

    @Override
    public Rayon add(Rayon rayon) {
        return rayonRepository.save(rayon);
    }

    @Override
    public Rayon update(Rayon rayon, Long id) {
        return null;
    }

    @Override
    public void delete(long id) {
        rayonRepository.deleteById(id);
    }

    @Override
    public List<Rayon> findAll() {
        return rayonRepository.findAll();
    }


    @Override
    public Rayon findById(Long id) {
        return rayonRepository.getById(id);
    }
}
