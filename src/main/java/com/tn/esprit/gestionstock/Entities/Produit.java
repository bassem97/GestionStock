package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String code;
    private String libelle;
    private float prixUnitaire;

    @ManyToOne()
    @JoinColumn(name = "idDetailFacture")
    private DetailFacture detailFacture;

    @ManyToOne()
    @JoinColumn(name = "idStock")
    private Stock stock;

    @ManyToOne()
    @JoinColumn(name = "idRayon")
    private Rayon rayon;

    @OneToOne
    @JoinColumn(name = "idDetailProduit")
    private DetailProduit detailProduit;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Produit_Fournisseur", joinColumns = {
            @JoinColumn(name = "idProduit") }, inverseJoinColumns = {
            @JoinColumn(name = "idFournisseur") })
    private List<Fournisseur> fournisseurs;

    public Produit() {
        fournisseurs = new ArrayList<>();
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
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

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public DetailFacture getDetailFacture() {
        return detailFacture;
    }

    public void setDetailFacture(DetailFacture detailFacture) {
        this.detailFacture = detailFacture;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public DetailProduit getDetailProduit() {
        return detailProduit;
    }

    public void setDetailProduit(DetailProduit detailProduit) {
        this.detailProduit = detailProduit;
    }

    public List<Fournisseur> getFournisseurs() {
        return fournisseurs;
    }

    public void setFournisseurs(List<Fournisseur> fournisseurs) {
        this.fournisseurs = fournisseurs;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", detailFacture=" + detailFacture +
                ", stock=" + stock +
                ", rayon=" + rayon +
                ", detailProduit=" + detailProduit +
                ", Fournisseurs=" + fournisseurs +
                '}';
    }
}
