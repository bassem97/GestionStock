package com.tn.esprit.gestionstock;

import com.tn.esprit.gestionstock.Configurations.seeder.SeedByOrder;
import com.tn.esprit.gestionstock.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@EnableSwagger2
@SpringBootApplication
public class GestionStockApplication {

    @Autowired
    SeedByOrder seedByOrder;

    @Autowired
    ClientRepository clientRepository;

    public static void main(String[] args) { SpringApplication.run(GestionStockApplication.class, args); }

    @PostConstruct
    public void init() throws Exception {
        if (clientRepository.findAll().isEmpty())
            seedByOrder.init();
    }

}
