package com.cfa.immo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "Agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL, orphanRemoval = false)
    List<Bien> biens = new ArrayList<>();

    public Agent(String nom, String prenom, String tel, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public Agent(Long id, String nom, String prenom, String tel, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.email = email;
    }

    public Agent() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bien> getBiens() {
        return biens;
    }

    public void addBien(Bien bien){
        biens.add(bien);
        bien.setAgent(this);
    }

    public void removeBien(Bien bien){
        biens.remove(bien);
        bien.setAgent(null);
    }


    /**
     * methode de recup du nom complet
     * @return
     */
    public String getFullName(){
        return this.nom + " " + this.prenom;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("<table>")
            .append("<tr><td>nom</td><td>").append(this.nom + "</td></tr>")
            .append("<tr><td>prenom</td><td>").append(this.prenom + "</td></tr>")
            .append("<tr><td>tel</td><td>").append(this.tel + "</td></tr>")
            .append("<tr><td>email</td><td>").append(this.email + "</td></tr>")
            .append("</table>");
        return str.toString();
    }
}
