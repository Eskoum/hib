/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author LENOVO
 */
@Entity
@NamedQuery(name = "find betweenf", query= " from  Mariage m" + "WHERE m.mari = :homme " + "AND m.dated>= :dated" + "AND (m.datef IS NULL OR m.datef<= :datef)")
public class Homme extends Personne {

    public Homme(String nom, String prenom, String telephone, String adr, Date daten) {
        super(nom, prenom, telephone, adr, daten);
    }
    
}
