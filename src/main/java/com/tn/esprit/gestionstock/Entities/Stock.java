package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStock;
    private int qte;
    private int qteMin;
    private String libelleStock;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idStock")
    private List<Produit> produits ;



    public Stock() {
        produits = new ArrayList<>();
    }

    public Stock(int qte, int qteMin, String libelleStock) {
        this.qte = qte;
        this.qteMin = qteMin;
        this.libelleStock = libelleStock;
        produits = new ArrayList<>();
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getQteMin() {
        return qteMin;
    }

    public void setQteMin(int qteMin) {
        this.qteMin = qteMin;
    }

    public String getLibelleStock() {
        return libelleStock;
    }

    public void setLibelleStock(String libelleStock) {
        this.libelleStock = libelleStock;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "idStock=" + idStock +
                ", qte=" + qte +
                ", qteMin=" + qteMin +
                ", libelleStock='" + libelleStock + '\'' +
                ", produits=" + produits +
                '}';
    }
}
