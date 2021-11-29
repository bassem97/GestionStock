package com.tn.esprit.gestionstock.Service.Produit;

import com.tn.esprit.gestionstock.Entities.Produit;
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
        return produitRepository.save(produit);
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
        return produitRepository.getById(id);
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
//        @Scheduled(cron = "*/5 * * * * *") // every 30 seconds
    @Scheduled(cron = "0 0 22 * * *") // everyday at 22h
    public void retrieveStatusStock() {
//        produitRepository.findAll().stream().filter(produit -> produit.getStock().getQte()< produit.getStock().getQteMin())
        produitRepository.retrieveStatusStock()
                .forEach(produit -> log.warn("PRODUIT "+produit.getIdProduit()+" CODE : "+produit.getCode()+" est epuisé !"));
    }

}
