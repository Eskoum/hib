/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "Mariage")
public class Mariage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nbe;
    @Temporal(TemporalType.DATE)
    private  Date dated;
    @Temporal(TemporalType.DATE)
    private  Date datef;
    private Femme femme;

    public Mariage(int nbe, Date dated, Date datef) {
        this.nbe = 0;
        this.dated = dated;
        this.datef = null;
    }

    public Mariage(Femme femme, Date dated, Date datef, int nombreEnfants) {
        this.femme= femme;
         this.nbe = 0;
        this.dated = dated;
        this.datef = null;
    }

    public int getNbe() {
        return nbe;
    }

    public void setNbe(int nbe) {
        this.nbe = nbe;
    }

    public Date getDated() {
        return dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    public Date getDatef() {
        return datef;
    }

    public void setDatef(Date datef) {
        this.datef = datef;
    }
    
}
