/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import ma.projet.entity.Produit;
import ma.projet.service.ProduitService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Session;


/**
 *
 * @author LENOVO
 */
public class ProduitTest {
    
    public static void main(String[] args) {
        ProduitService pr = new ProduitService();
      
       // us.create(new Produit("aa", "aa", new Date()));
        Produit pp = pr.findById(1);
        pp.setRefe("a");
        pp.setMarque("b");
         pp.setDes("c");
         pp.setPrix(66);
         
          
        pr.update(pp);
        for(Produit p : pr.findAll())
            System.out.println(p.getRefe()+ p.getMarque() + p.getDes() + p.getPrix() );
        
        Session session = HibernateUtil.getSessionFactory().openSession();
session.beginTransaction();

Produit produit = (Produit) session.get(Produit.class, 2); // Remplacez "Produit" par le nom de votre classe d'entité

if (produit != null) {
    System.out.println("Informations du produit avec ID 2 :");
    System.out.println("id: " + produit.getId());
    System.out.println("Prix : " + produit.getPrix());
    // ... autres propriétés du produit
} else {
    System.out.println("Le produit avec ID 2 n'a pas été trouvé.");
}

//session.getTransaction().commit();
//session.close();





//Session session = NewHibernateUtil.getSessionFactory().openSession();
//session.beginTransaction();

//Produit produit = (Produit) session.get(Produit.class, 3); // Remplacez "Produit" par le nom de votre classe d'entité

if (produit != null) {
    session.delete(produit);
    System.out.println("Le produit avec ID 3 a été supprimé.");
} else {
    System.out.println("Le produit avec ID 3 n'a pas été trouvé.");
}



//Session session = NewHibernateUtil.getSessionFactory().openSession();
//session.beginTransaction();

//Produit produit = session.get(Produit.class, 1); // Remplacez "Produit" par le nom de votre classe d'entité

if (produit != null) {
    produit.setDes("nn");
    produit.setPrix(200); // Modifiez d'autres propriétés selon vos besoins
    session.update(produit);
    System.out.println("Les informations du produit avec ID 1 ont été mises à jour.");
} else {
    System.out.println("Le produit avec ID 1 n'a pas été trouvé.");
}

session.getTransaction().commit();
session.close();

    }
    
}
