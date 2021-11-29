package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetailFacture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailFacture;

    private int qte;
    private float prixtotal;
    private int pourcentageRemise;
    private float montantRemise;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idFacture")
    private Facture facture;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idProduit")
    @JsonIgnoreProperties({"detailFactures", "produit"})
    private Produit produit;


    public DetailFacture(int qte, float prixtotal, int pourcentageRemise, float montantRemise, Facture facture, Produit produit) {
        this.qte = qte;
        this.prixtotal = prixtotal;
        this.pourcentageRemise = pourcentageRemise;
        this.montantRemise = montantRemise;
        this.facture = facture;
        this.produit = produit;
    }

    public DetailFacture() {

    }

    public Long getIdDetailFacture() {
        return idDetailFacture;
    }

    public void setIdDetailFacture(Long idDetailFacture) {
        this.idDetailFacture = idDetailFacture;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrixtotal() {
        return prixtotal;
    }

    public void setPrixtotal(float prixtotal) {
        this.prixtotal = prixtotal;
    }

    public int getPourcentageRemise() {
        return pourcentageRemise;
    }

    public void setPourcentageRemise(int pourcentageRemise) {
        this.pourcentageRemise = pourcentageRemise;
    }

    public float getMontantRemise() {
        return montantRemise;
    }

    public void setMontantRemise(float montantRemise) {
        this.montantRemise = montantRemise;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
