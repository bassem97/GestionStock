package com.tn.esprit.gestionstock.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;
    private String lastName;
    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(unique = true)
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cin;

    private String password;

    @Enumerated(EnumType.STRING)
    CategorieUser categorieUser;
    @Enumerated(EnumType.STRING)
    Profession proffesion;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonIgnoreProperties({"user"})
    List<Facture> factures;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "user_id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id") })
    @JsonIgnoreProperties({"users"})
    private List<Role> roles;

    public User() {
        this.factures = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public User(String lastName, String firstName, Date birthDate, String email,String phone , String cin, String password, CategorieUser categorieUser, Profession proffesion) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.categorieUser = categorieUser;
        this.proffesion = proffesion;
        this.factures = factures;
        this.roles = new ArrayList<>();
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CategorieUser getCategorieUser() {
        return categorieUser;
    }

    public void setCategorieUser(CategorieUser categorieUser) {
        this.categorieUser = categorieUser;
    }

    public Profession getProffesion() {
        return proffesion;
    }

    public void setProffesion(Profession proffesion) {
        this.proffesion = proffesion;
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(Long idUser, String lastName, String firstName, Date birthDate, String phone, String email, String cin, String password, CategorieUser categorieUser, Profession proffesion) {
        this.idUser = idUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.categorieUser = categorieUser;
        this.proffesion = proffesion;
    }

    public User(Long idUser, String lastName, String firstName, Date birthDate, String phone, String email, String cin, String password, CategorieUser categorieUser, Profession proffesion, List<Role> roles) {
        this.idUser = idUser;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.email = email;
        this.cin = cin;
        this.password = password;
        this.categorieUser = categorieUser;
        this.proffesion = proffesion;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", cin='" + cin + '\'' +
                ", password='" + password + '\'' +
                ", categorieUser=" + categorieUser +
                ", proffesion=" + proffesion +
//                ", factures=" + factures +
//                ", roles=" + roles +
                '}';
    }
}
