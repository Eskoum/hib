/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author LENOVO
 */
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Femme.findNombreEnfantsEntreDates",
        query =  "SELECT SUM(m.nombreEnfants) " +
                "FROM Mariage m " +
                "WHERE m.mariee = :femme " +
                "AND m.dateDebut >= :dateDebut " +
                "AND (m.dateFin IS NULL OR m.dateFin <= :dateFin)" )
})
    
    @NamedQuery(name = "Femme.findFemmesMarieesDeuxFoisOuPlus", query = "SELECT f " +"FROM Femme f " + "WHERE (SELECT COUNT(m) FROM Mariage m WHERE m.mariee = f) >= 2")

public class Femme extends Personne{

    

    public Femme(String nom, String prenom, String telephone, String adr, Date daten) {
        super(nom, prenom, telephone, adr, daten);
    }

    
    

    
    
    
}
