package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rayon  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRayon;
    private String code;
    private String libelle;

    @OneToMany()
    @JoinColumn(name = "idRayon")
    private List<Produit> produits;

    public Rayon() {
        produits = new ArrayList<>();
    }

    public Rayon(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Long getIdRayon() {
        return idRayon;
    }

    public void setIdRayon(Long idRayon) {
        this.idRayon = idRayon;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "idRayon=" + idRayon +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", produits=" + produits +
                '}';
    }
}
