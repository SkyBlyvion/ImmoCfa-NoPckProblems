package com.cfa.immo.model;

import jakarta.persistence.*;

import java.text.NumberFormat;

@Entity
public class Bien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private int surfaceTotal;

    @Column(nullable = false)
    private int surfaceHabitable;

    @Column(nullable = false)
    private int nbrPiece;

    @Column(nullable = false)
    private String typeBien;

    @Column(nullable = false)
    private boolean isVente = true;

    @Column(nullable = false)
    private int prix;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    public Bien(String description, int surfaceTotal, int surfaceHabitable, int nbrPiece, String typeBien, boolean isVente, int prix) {
        this.description = description;
        this.surfaceTotal = surfaceTotal;
        this.surfaceHabitable = surfaceHabitable;
        this.nbrPiece = nbrPiece;
        this.typeBien = typeBien;
        this.isVente = isVente;
        this.prix = prix;
    }

    public Bien(Long id, String description, int surfaceTotal, int surfaceHabitable, int nbrPiece, String typeBien, boolean isVente, int prix) {
        this.id = id;
        this.description = description;
        this.surfaceTotal = surfaceTotal;
        this.surfaceHabitable = surfaceHabitable;
        this.nbrPiece = nbrPiece;
        this.typeBien = typeBien;
        this.isVente = isVente;
        this.prix = prix;
    }

    public Bien() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSurfaceTotal() {
        return surfaceTotal;
    }

    public void setSurfaceTotal(int surfaceTotal) {
        this.surfaceTotal = surfaceTotal;
    }

    public int getSurfaceHabitable() {
        return surfaceHabitable;
    }

    public void setSurfaceHabitable(int surfaceHabitable) {
        this.surfaceHabitable = surfaceHabitable;
    }

    public int getNbrPiece() {
        return nbrPiece;
    }

    public void setNbrPiece(int nbrPiece) {
        this.nbrPiece = nbrPiece;
    }

    public String getTypeBien() {
        return typeBien;
    }

    public void setTypeBien(String typeBien) {
        this.typeBien = typeBien;
    }

    public boolean isVente() {
        return isVente;
    }

    public void setVente(boolean vente) {
        isVente = vente;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    // methode d'affichage du prix réel
    public String getPrixEuro() {
        float prixReel = this.prix / 100;
        return prixReel + " €";
    }
}
