package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.Produit;
import com.tn.esprit.gestionstock.Service.Produit.ProduitService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProduitServiceTest {
    @Autowired
    private ProduitService produitService;

    @Test
    @Ignore
    public void testAddProduit() {
        List<Produit> produits = produitService.findAll();
        int expected = produits.size();
        Produit produit = new Produit("p123", "produit 123", 5.2F);
        Produit savedProduit = produitService.add(produit);
        assertEquals(expected + 1, produitService.findAll().size());
        assertNotNull(savedProduit.getCode());
        produitService.delete(savedProduit.getIdProduit());
    }

    @Test
    @Ignore
    public void testListProduit() {
        produitService.findAll()
                .forEach( produit -> log.info("Produit :"+ produit));
    }

    @Test
    @Ignore
    public void testAssignProduitToStock(){
        produitService.assignProduitToStock(2L,1L);
    }

    @Test
    public void testGetRevenuBrutProduit(){
        log.info("QTE : "+produitService.getRevenuBrutProduit(1L,new Date(121, Calendar.NOVEMBER, 11),new Date(121, Calendar.NOVEMBER, 14)));
    }
}