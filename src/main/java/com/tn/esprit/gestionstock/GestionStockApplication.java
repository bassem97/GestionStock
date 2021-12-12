package com.tn.esprit.gestionstock;

import com.tn.esprit.gestionstock.Config.seeder.SeedByOrder;
import com.tn.esprit.gestionstock.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;

@EnableSwagger2
@SpringBootApplication
public class GestionStockApplication {

    @Autowired
    SeedByOrder seedByOrder;

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionStockApplication.class, args);
//        System.exit(SpringApplication.exit(SpringApplication.run(GestionStockApplication.class, args)));

    }

    @PostConstruct
    public void init() throws Exception {
        if (userRepository.findAll().isEmpty())
            seedByOrder.init();
    }


    @Configuration
    @Profile("local")
    @ComponentScan(lazyInit = true)
    static class loadConfig{

    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer () {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }

}



