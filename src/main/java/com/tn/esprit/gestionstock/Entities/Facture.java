package com.tn.esprit.gestionstock.Entities;

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
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties({"roles"})
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFacture")
    @JsonIgnoreProperties({"facture"})
    private List<DetailFacture> detailFactures;

    public Facture() {
        this.active = false;
        this.dateFacture  = new Date();
        detailFactures = new ArrayList<>();
    }

    public Facture(float montantRemise, float montantFacture,User user) {
        this.montantRemise = montantRemise;
        this.montantFacture = montantFacture;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
//                ", detailFactures=" + detailFactures +
                '}';
    }
}
