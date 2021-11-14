package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.Fournisseur;
import com.tn.esprit.gestionstock.Service.Fournisseur.FournisseurService;
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
public class FournisseurServiceTest {
    @Autowired
    private FournisseurService fournisseurService;

    @Ignore
    @Test
    public void testAddFournisseur() {
        List<Fournisseur> fournisseurs = fournisseurService.findAll();
        int expected = fournisseurs.size();
        Fournisseur fournisseur = new Fournisseur("f123", "fourn 123");
        Fournisseur savedFournisseur = fournisseurService.add(fournisseur);
        assertEquals(expected + 1, fournisseurService.findAll().size());
        assertNotNull(savedFournisseur.getIdFournisseur());
        fournisseurService.delete(savedFournisseur.getIdFournisseur());
    }

    @Test
    @Ignore
    public void testListFournisseur() {
        fournisseurService.findAll()
                .forEach(fournisseur -> log.info("Fournisseur :" + fournisseur));
    }

    @Test
    public void testAssignFournisseurToProduit() {
        fournisseurService.assignFournisseurToProduit(1L,3L);
    }

}