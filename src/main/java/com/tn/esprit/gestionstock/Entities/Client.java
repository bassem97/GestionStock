package com.tn.esprit.gestionstock.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idClient;
    String nom;
    String prenom;

    @Temporal(TemporalType.DATE)
//    @Temporal(TemporalType.TIMESTAMP)
    Date dateNaissance;
    String email;
    String password;
    @Enumerated(EnumType.STRING)
    CategorieClient categorieClient;
    @Enumerated(EnumType.STRING)
    Profession proffesion;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    List<Facture> factures;

    public Client() {
        factures = new ArrayList<>();
    }

    public Client(String nom, String prenom, Date dateNaissance, String email, String password, CategorieClient categorieClient, Profession proffesion) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.password = password;
        this.categorieClient = categorieClient;
        this.proffesion = proffesion;
        factures = new ArrayList<>();
    }

    public Client(String nom, String prenom, String email, String password, CategorieClient categorieClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.categorieClient = categorieClient;
        factures = new ArrayList<>();
    }
}
