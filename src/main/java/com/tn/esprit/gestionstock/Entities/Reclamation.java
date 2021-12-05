package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Reclamation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamation;
    private String subject;
    private String body;
    private boolean etat;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduit")
    @JsonIgnoreProperties({"reclamations","detailFactures"})
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reclamations","factures"})
    private User user;

    public Reclamation() {
        this.etat = false;
    }

    public Reclamation(String subject, String body ,Produit produit, User user) {
        this.subject = subject;
        this.body = body;
        this.etat = false;
        this.produit = produit;
        this.user = user;
    }

    public Long getIdReclamation() {
        return idReclamation;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setIdReclamation(Long idReclamtion) {
        this.idReclamation = idReclamtion;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;


    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Reclamation{" +
                "idReclamtion=" + idReclamation +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", produit=" + produit +
                ", user=" + user +
                '}';
    }
}
