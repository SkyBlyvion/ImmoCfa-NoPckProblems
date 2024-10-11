package com.cfa.immo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String adresse;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String email;

    @ManyToMany
    @Column(nullable = false)
    @JoinTable(name = "agence_agent",
        joinColumns = @JoinColumn(name = "agence_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    private List<Agent> agents;

    public Agence(String nom, String adresse, String tel, String email) {
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public Agence(Long id, String nom, String adresse, String tel, String email) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.email = email;
    }

    public Agence() {
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public String joinedAgent(){
        return agents.stream().map(Agent::getFullName)
                .collect(Collectors.joining(", "));
    }
}
