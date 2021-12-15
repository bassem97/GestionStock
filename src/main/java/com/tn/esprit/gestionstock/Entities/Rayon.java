package com.tn.esprit.gestionstock.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "idRayon")
public class Rayon implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @NonNull
    long idRayon;
    @Column(length = 64)
    @NonNull
    String code;
    @Column(length = 64)
    @NonNull
    String  libelle;

//        @OneToMany(mappedBy="rayon",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @OneToMany()
    @JoinColumn(name = "idRayon")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Produit> set_r_produits = new HashSet<Produit>();

    public Rayon(@NonNull String code, @NonNull String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Set<Produit> getSet_r_produits() {
        return set_r_produits;
    }

    public void setSet_r_produits(Set<Produit> set_r_produits) {
        this.set_r_produits = set_r_produits;
    }

    @Override
    public String toString() {
        return "Rayon{" +
                "idRayon=" + idRayon +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
