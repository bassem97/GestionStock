package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String image;




    @ManyToOne()
    @JoinColumn(name = "idStock")
    @JsonIgnoreProperties({"produits"})
    private Stock stock;

    @ManyToOne()
    @JoinColumn(name = "idRayon")
    @JsonIgnoreProperties({"set_r_produits"})
//    @JsonBackReference
    private Rayon rayon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDetailProduit")
    private DetailProduit detailProduit;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduit")
    @JsonIgnoreProperties(value = {"produit"}, allowGetters = true)
    private List<DetailFacture> detailFactures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduit")
    @JsonIgnoreProperties({"client"})
    private List<Reclamation> reclamations;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Produit_Fournisseur", joinColumns = {
            @JoinColumn(name = "idProduit") }, inverseJoinColumns = {
            @JoinColumn(name = "idFournisseur") })
    @JsonIgnoreProperties({"produits"})
    private List<Fournisseur> fournisseurs;

    public Produit(String code, String libelle, float prixUnitaire, DetailProduit detailProduit, Rayon rayon, Stock stock) {
        this.code = code;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.detailProduit = detailProduit;
        this.rayon = rayon;
        this.stock = stock;
        this.detailFactures = new ArrayList<>();
        this.fournisseurs = new ArrayList<>();
        this.reclamations = new ArrayList<>();
    }

    public Produit(String code, String libelle, float prixUnitaire) {
        this.code = code;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.detailFactures = new ArrayList<>();
        this.fournisseurs = new ArrayList<>();
        this.reclamations = new ArrayList<>();

    }

    public Produit() {
        fournisseurs = new ArrayList<>();
        this.detailFactures = new ArrayList<>();
        this.reclamations = new ArrayList<>();

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

    public List<DetailFacture> getDetailFactures() {
        return detailFactures;
    }

    public void setDetailFactures(List<DetailFacture> detailFactures) {
        this.detailFactures = detailFactures;
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

    public String getImage() {
        return image;
    }
    public List<Reclamation> getReclamations() {
        return reclamations;
    }
    public void setReclamations(List<Reclamation> reclamations) {
        this.reclamations = reclamations;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                ", rayon=" + rayon +
//                ", detailProduit=" + detailProduit +
//                ", detailFactures=" + detailFactures +
//                ", reclamations=" + reclamations +
//                ", fournisseurs=" + fournisseurs +
                '}';
    }
}
