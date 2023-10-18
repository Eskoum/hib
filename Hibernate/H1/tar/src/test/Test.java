/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Personne;
import services.FemmeService;
import services.HommeService;

/**
 *
 * @author LENOVO
 */
public class Test {
    public static void main(String[] args) {
    FemmeService fs = new FemmeService();
  HommeService hs = new HommeService();
  fs.create(new Femme("a","aa","66963489","aaaaaa",new Date(1/2/2000)));
  fs.create(new Femme("b","bb","669636278","bbbbb",new Date(8/2/1999)));
  fs.create(new Femme("c","cc","66910489","ccccc",new Date(18/2/2001)));
  fs.create(new Femme("d","dd","65465820","ddddd",new Date(11/6/1998)));
  fs.create(new Femme("e","ee","65865653","eeeeee",new Date(10/3/2000)));
  fs.create(new Femme("f","ff","66973244","ffffff",new Date(21/2/19997)));
  fs.create(new Femme("g","gg","622268913","iiiiii",new Date(30/9/2002)));
  fs.create(new Femme("h","hh","6647939","gggggg",new Date(17/4/1996)));
  fs.create(new Femme("i","ii","69305409","iiiii",new Date(1/8/1998)));
  fs.create(new Femme("k","kk","669798489","kkkkk",new Date(1/5/2000)));
  List<Femme> femmes = fs.getAll();
  if (femmes !=null) {
    for(Femme femme : femmes) {
        System.out.println("ID :" +femme.getId());
        System.out.println("NOM :"  +femme.getNom());
        System.out.println("PRENOM : "  +femme.getPrenom());
        System.out.println("TELEPHONE :"  +femme.getTelephone());
        System.out.println("adresse : " +femme.getAdr());
        System.out.println("DATE DE NAISSANCE:"  +femme.getDaten());
        System.out.println("    " );
        
        
        
    }
    
}
    
       
       
    
}
}

