package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Facture implements Serializable {

    @Id
    private Long idFacture;

    private float montantRemise;
    private float montantFacture;

    @Temporal(TemporalType.DATE)
    private Date dateFacture;
    private Boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    private Client client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFacture")
    private List<DetailFacture> detailFactures;

    public Facture() {
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
                '}';
    }
}
