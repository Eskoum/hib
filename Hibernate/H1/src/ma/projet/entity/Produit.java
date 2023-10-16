

package ma.projet.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;


  
@Entity
@Table(name = "produits")
public class Produit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "reference")
    private String refe;
    @Column(name = "marque")
    private String marque;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datea;
    @Column(name = "designatino")
    private String des;
    @Column(name = "prix")
    private int prix;

    public Produit( String refe, String marque, Date datea, String des, int prix) {
       // this.id = id;
        this.refe = refe;
        this.marque = marque;
        this.datea = datea;
        this.des = des;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRefe() {
        return refe;
    }

    public void setRefe(String refe) {
        this.refe = refe;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Date getDatea() {
        return datea;
    }

    public void setDatea(Date datea) {
        this.datea = datea;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    
}





    

