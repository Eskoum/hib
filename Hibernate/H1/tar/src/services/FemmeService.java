/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.dao.IDao;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author LENOVO
 */
public class FemmeService implements IDao<Femme> {
    private Object session;

    
    @Override
    public boolean create(Femme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    public boolean delete(Femme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    public boolean update(Femme o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return false;
    }

    @Override
    public Femme findById(int id) {
        Femme femme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femme = (Femme) session.get(Femme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return femme;
    }

    @Override
    public List<Femme> findAll() {
        List<Femme> femmes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            femmes = session.createQuery("from Femme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return femmes;
    }
        public int findNombreEnfantsEntreDates(Femme femme, Date dateDebut, Date dateFin) {
        int nombreEnfants = 0;
        List<Femme> femmes = null;
       
        Session session = null;
        Transaction tx = null;
        try {
            Query query = session.getNamedQuery("Femme.findNombreEnfantsEntreDates");
            query.setParameter("femme", femme);
            query.setParameter("dateDebut", dateDebut);
            query.setParameter("dateFin", dateFin);

          femmes =  query.list();
        } catch (HibernateException e) {
            
        }
        return nombreEnfants;
    }
        public List<Femme> findFemmesMarieesDeuxFoisOuPlus() {
        List<Femme> femmes = null;
        
        Session session = null;
        Transaction tx = null;
        try {
            
           Query query = session.getNamedQuery("Femme.findFemmesMarieesDeuxFoisOuPlus");
           femmes =  query.list();
           
        } catch (HibernateException e) {
             
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return femmes;
        }

    public List<Femme> getAll() {
        return null;
        
    }
       
}













          
    

    
    

