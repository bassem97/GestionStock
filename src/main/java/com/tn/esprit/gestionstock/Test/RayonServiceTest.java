package com.tn.esprit.gestionstock.Test;

import com.tn.esprit.gestionstock.Entities.Rayon;
import com.tn.esprit.gestionstock.Service.Rayon.RayonService;
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
public class RayonServiceTest {
    @Autowired
    private RayonService rayonService;

    @Test
    @Ignore
    public void testAddRayon() {
//        List<Rayon> rayons = rayonService.findAll();
//        int expected = rayons.size();
//        Rayon rayon = new Rayon("r123","rayon 123");
//        Rayon savedRayon= rayonService.add(rayon);
//        assertEquals(expected + 1, rayonService.findAll().size());
//        assertNotNull(savedRayon.getCode());
//        rayonService.delete(savedRayon.getIdRayon());
    }

    @Test
    @Ignore
    public void testListRayon() {
//        rayonService.retrieveAllRayons()
//                .forEach( rayon -> log.info("Rayon :"+ rayon));
    }
}