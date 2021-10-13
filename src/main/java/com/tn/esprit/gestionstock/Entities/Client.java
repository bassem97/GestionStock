package com.tn.esprit.gestionstock.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String nom;

    private String prenom;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private String email;

    private String password;

    private CategorieClient categorieClient;

    private Proffesion proffesion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClient")
    private List<Facture> factures;

    public Client() {
        factures = new ArrayList<>();
    }

    public Client(String nom, String prenom, Date dateNaissance, String email, String password, CategorieClient categorieClient, Proffesion proffesion) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.password = password;
        this.categorieClient = categorieClient;
        this.proffesion = proffesion;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CategorieClient getCategorieClient() {
        return categorieClient;
    }

    public void setCategorieClient(CategorieClient categorieClient) {
        this.categorieClient = categorieClient;
    }

    public Proffesion getProffesion() {
        return proffesion;
    }

    public void setProffesion(Proffesion proffesion) {
        this.proffesion = proffesion;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", categorieClient=" + categorieClient +
                ", proffesion=" + proffesion +
                ", factures=" + factures +
                '}';
    }

    // ENNNUMMSS
    private enum Proffesion{
        Docteur, Inghenieur, Etudiant, Commercial, Cadre, Autre
    }

    private enum CategorieClient{
        Fidele, Ordinaire, Premium
    }

}
