package com.tn.esprit.gestionstock.Service.Rayon;


import com.tn.esprit.gestionstock.Entities.Rayon;

import java.util.List;

public interface RayonService {
    Rayon add(Rayon rayon);
    Rayon update(Rayon rayon, Long id);
    void delete(long id);
    List<Rayon> findAll();
    Rayon findById(Long id);
}
