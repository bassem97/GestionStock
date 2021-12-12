package com.tn.esprit.gestionstock.Service.Produit;

import com.tn.esprit.gestionstock.Entities.Produit;
import com.tn.esprit.gestionstock.Entities.WebSocketMessage;
import com.tn.esprit.gestionstock.Repository.ProduitRepository;
import com.tn.esprit.gestionstock.Repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@EnableScheduling
public class ProduitServiceImpl implements ProduitService{
    
    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Produit add(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit update(Produit produit, Long id) {
        if (produitRepository.findById(id).isPresent()) {
            Produit p = produitRepository.findById(id).get();
            p.setImage(produit.getImage());
            p.setStock(produit.getStock());
            p.setCode(produit.getCode());
            p.setLibelle(produit.getLibelle());
            p.setPrixUnitaire(produit.getPrixUnitaire());
            p.setRayons(produit.getRayons());
            p.setDetailProduit(produit.getDetailProduit());
            p.setFournisseurs(produit.getFournisseurs());
            p.getDetailProduit().setDateDerniereModification(new Date());
            return produitRepository.save(produit);
        }
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
        return produitRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void assignProduitToStock(Long idProduit, Long idStock) {
        Produit produit = produitRepository.getById(idProduit);
        log.info("ID PRODUIT  :"+produit.getIdProduit());
        log.info("ID STOCK  :"+stockRepository.getById(idStock).getIdStock());
        produit.setStock(stockRepository.getById(idStock));
        produitRepository.save(produit);



    }

    @Transactional
    @Override
    public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
        return (float) produitRepository.getRevenuBrutProduit(idProduit, startDate, endDate) * findById(idProduit).getPrixUnitaire();
    }

    @Override
//        @Scheduled(cron = "*/60 * * * * *") // every 60 seconds
    @Scheduled(cron = "0 0 22 * * *") // everyday at 22h
    public void retrieveStatusStock() {
//        produitRepository.findAll().stream().filter(produit -> produit.getStock().getQte()< produit.getStock().getQteMin())
        produitRepository.retrieveStatusStock()
                .forEach(produit -> log.warn("PRODUIT "+produit.getIdProduit()+" CODE : "+produit.getCode()+" est epuisé !"));
    }

}
