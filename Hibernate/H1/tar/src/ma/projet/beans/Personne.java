/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "Personne")

public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int  id;
    @Column(name = "Firsttname")
     String nom;
    @Column(name = "Lastname")
     String prenom;
    @Column(name = "tel")
     String telephone;
    @Column(name = "adr")
      String adr;
    @Temporal(javax.persistence.TemporalType.DATE)
     Date daten;

    public Personne(String nom, String prenom, String telephone, String adr, Date daten) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adr = adr;
        this.daten = daten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Date getDaten() {
        return daten;
    }

    public void setDaten(Date daten) {
        this.daten = daten;
    }
    
   
                    
    
}
