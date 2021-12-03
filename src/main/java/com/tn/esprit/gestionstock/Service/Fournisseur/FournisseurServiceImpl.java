package com.tn.esprit.gestionstock.Service.Fournisseur;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Repository.FournisseurRepository;
import com.tn.esprit.gestionstock.Repository.ProduitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public Fournisseur add(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur update(Fournisseur fournisseur, Long id) {
        if(fournisseurRepository.findById(id).isPresent()){
            Fournisseur fournisseur1 = fournisseurRepository.findById(id).get();
            fournisseur1.setCode(fournisseur.getCode());
            fournisseur1.setLibelle(fournisseur.getLibelle());
            fournisseur1.setProduits(fournisseur.getProduits());
            return fournisseurRepository.save(fournisseur1);
        }
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

    @Transactional
    @Override
    public void assignFournisseurToProduit(Long idFournisseur, Long idProduit) {
        Fournisseur fournisseur = fournisseurRepository.getById(idFournisseur);
        log.info("ID fournisseur  :"+fournisseur.getIdFournisseur());
        log.info("ID PRODUIT  :"+produitRepository.getById(idProduit).getIdProduit());
        fournisseur.getProduits().add(produitRepository.getById(idProduit));
        fournisseurRepository.save(fournisseur);
    }
}
