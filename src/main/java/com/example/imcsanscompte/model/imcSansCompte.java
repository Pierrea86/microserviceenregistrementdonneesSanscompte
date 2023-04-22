package com.example.imcsanscompte.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "IMCCompte")
public class imcSansCompte {
    @Column(name="identifiant")
    private String identifiant;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id") //indique la colonne de la table de la base de données auquelle appartient la variable

    private Long id;
    @Column(name = "masse")
    private float masse;
    @Column(name = "taille")
    private float taille;
    @Column(name = "dateIMC")
    private LocalDate dateIMC;

    @Column(name = "imc")
    private float imc;


    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public float getMasse() {
        return masse;
    }

    public void setMasse(float masse) {
        this.masse = masse;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public LocalDate getDateIMC() {
        return dateIMC;
    }

    public void setDateIMC(LocalDate dateIMC) {
        this.dateIMC = dateIMC;
    }


    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public imcSansCompte(){}

    public imcSansCompte(String identifiant, Float masse, Float taille){
        this.setIdentifiant(identifiant);
        this.setMasse(masse);
        this.setTaille(taille);
        this.setDateIMC(LocalDate.now());
        float imcCalcul= masse/(taille*taille);
        this.setImc(imcCalcul);
    }


    @Override
    public String toString() {
        return "Tutorial [identifiant=" + this.getIdentifiant() + ",id=" + this.getId() + ",masse=" + this.getMasse() + ",taille=" + this.getTaille() +",dateIMC="+ this.getDateIMC() +"]";
    }
}

/*
*         ^
DROP TABLE
imcsanscompte=> CREATE TABLE IMCCompte (
    identifiant character varying(30) NOT NULL,
    id SERIAL NOT NULL PRIMARY KEY,
    masse integer NOT NULL,                                                                                                                          masse integer NOT NULL,
    taille integer NOT NULL,
    dateIMC date DEFAULT CURRENT_DATE
  );
* */
