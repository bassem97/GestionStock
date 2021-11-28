package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private float montantRemise;
    private float montantFacture;

    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"factures"})
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFacture")
    @JsonIgnoreProperties({"facture"})
    private List<DetailFacture> detailFactures;

    public Facture() {
        this.active = false;
        this.dateFacture  = new Date();
        detailFactures = new ArrayList<>();
    }

    public Facture(float montantRemise, float montantFacture,Client client) {
        this.montantRemise = montantRemise;
        this.montantFacture = montantFacture;
        this.client = client;
        this.active = true;
        this.dateFacture  = new Date();
        detailFactures = new ArrayList<>();
    }
    public Facture(float montantRemise, float montantFacture) {
        this.montantRemise = montantRemise;
        this.montantFacture = montantFacture;
        this.active = true;
        this.dateFacture  = new Date();
        detailFactures = new ArrayList<>();
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public float getMontantRemise() {
        return montantRemise;
    }

    public void setMontantRemise(float montantRemise) {
        this.montantRemise = montantRemise;
    }

    public float getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(float montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetailFacture> getDetailFactures() {
        return detailFactures;
    }

    public void setDetailFactures(List<DetailFacture> detailFactures) {
        this.detailFactures = detailFactures;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "idFacture=" + idFacture +
                ", montantRemise=" + montantRemise +
                ", montantFacture=" + montantFacture +
                ", dateFacture=" + dateFacture +
                ", active=" + active +
                ", client=" + client +
//                ", detailFactures=" + detailFactures +
                '}';
    }
}
