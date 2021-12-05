package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.Facture;
import com.tn.esprit.gestionstock.Service.FactureService.FactureService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceTest {
    @Autowired
    private FactureService factureService;

    @Test
    @Ignore
    public void testAddFacture() {
        List<Facture> factures = factureService.findAll();
        int expected = factures.size();
        Facture facture = new Facture(12.5F,15.2F);
        Facture savedFacture= factureService.add(facture);
        assertEquals(expected + 1, factureService.findAll().size());
        assertNotNull(savedFacture.getIdFacture());
        factureService.delete(savedFacture.getIdFacture());
    }

    @Ignore
    @Test
    public void testListFacture() {
        factureService.findAll()
                .forEach( facture -> log.info("Facture :"+ facture));
    }

    @Test
    public void testGetFacturesByClient(){
        log.info("User list of facture 1 : "+factureService.getFacturesByClient(1L));
    }
}