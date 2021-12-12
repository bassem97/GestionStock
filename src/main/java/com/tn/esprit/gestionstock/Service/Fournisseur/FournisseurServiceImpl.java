package com.tn.esprit.gestionstock.Service.Fournisseur;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Entities.Produit;
import com.tn.esprit.gestionstock.Repository.FournisseurRepository;
import com.tn.esprit.gestionstock.Repository.ProduitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    /*@PersistenceContext
    private EntityManager entityManager;*/

    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        return (List<Fournisseur>) this.fournisseurRepository.findAll();
    }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        return this.fournisseurRepository.save(f);
    }

    @Override
    public void deleteFournisseur(Long id) {
        this.fournisseurRepository.deleteById(id);
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        return this.fournisseurRepository.save(f);
    }

    @Override
    public Fournisseur retrieveFournisseur(Long id) {
        return this.fournisseurRepository.findById(id).get();
    }

    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
        if (fournisseurId != null && produitId != null) {
            if (this.produitRepository.findById(produitId).isPresent()
                    && this.fournisseurRepository.findById(fournisseurId).isPresent()) {
                Produit u = this.produitRepository.findById(produitId).get();
                u.getFournisseurs().add(this.fournisseurRepository.findById(fournisseurId).get());
                this.produitRepository.save(u);
            }
        }
    }


    /*@Transactional
    public void alterMyTableAddMyColumn() {
        List<Fournisseur> check_list= (List<Fournisseur>) this.fournisseurRepository.findAll();
        if(check_list.size()==0) {
            String query = "ALTER table fournisseur AUTO_INCREMENT=1";
            entityManager.createNativeQuery(query).executeUpdate();
        }
    }*/
    @Scheduled(cron = "*/5 * * * * *")
    public void reset_value(){
        List<Fournisseur> check_list= (List<Fournisseur>) this.fournisseurRepository.findAll();
        if(check_list.size()==0)
            this.fournisseurRepository.reset_auto_increment();
    }
}
