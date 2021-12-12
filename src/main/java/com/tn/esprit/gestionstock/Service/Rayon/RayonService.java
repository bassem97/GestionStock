package com.tn.esprit.gestionstock.Service.Rayon;


import com.tn.esprit.gestionstock.Entities.Rayon;

import java.util.List;

public interface RayonService {
    List<Rayon> retrieveAllRayons();
    Rayon addRayon(Rayon r);
    void deleteRayon(Long id);
    Rayon updateRayon(Rayon r);
    Rayon retrieveRayon(Long id);
}
