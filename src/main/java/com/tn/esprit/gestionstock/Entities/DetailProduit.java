package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DetailProduit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailProduit;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDerniereModification;

    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;

    public DetailProduit() {
    }

    public DetailProduit(Date dateCreation, Date dateDerniereModification, CategorieProduit categorieProduit) {
        this.dateCreation = dateCreation;
        this.dateDerniereModification = dateDerniereModification;
        this.categorieProduit = categorieProduit;
    }

    public Long getIdDetailProduit() {
        return idDetailProduit;
    }

    public void setIdDetailProduit(Long idDetailProduit) {
        this.idDetailProduit = idDetailProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateDerniereModification() {
        return dateDerniereModification;
    }

    public void setDateDerniereModification(Date dateDerniereModification) {
        this.dateDerniereModification = dateDerniereModification;
    }

    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    @Override
    public String toString() {
        return "DetailProduit{" +
                "idDetailProduit=" + idDetailProduit +
                ", dateCreation=" + dateCreation +
                ", dateDerniereModification=" + dateDerniereModification +
                ", categorieProduit=" + categorieProduit +
                '}';
    }
}
