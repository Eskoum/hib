/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.projet.beans.Femme;
import ma.projet.beans.Homme;
import ma.projet.beans.Mariage;
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
public class HommeService  implements IDao<Homme> {

    @Override
    public boolean create(Homme o) {
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

    public boolean delete(Homme o) {
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

    public boolean update(Homme o) {
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
    public Homme findById(int id) {
        Homme homme = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            homme = (Homme) session.get(Homme.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return homme;
    }

    @Override
    public List<Homme> findAll() {
        List<Homme> hommes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            hommes = session.createQuery("from Homme").list();
            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return hommes;
    }
    public List<Homme> findBetweenf( Date dated, Date datef) {
        List<Homme> hommes = null;
        Session session = null;
       
        Transaction tx = null;
       
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
             Query q = session.getNamedQuery("findBetweenf");
             q.setParameter("dated",dated);
             q.setParameter("datef",datef);
               hommes = q.list();
           
            

            tx.commit();
        } catch (HibernateException e) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
        return hommes;
    }
    
    
    public List<Mariage> getMariagesHomme(Homme homme) {
        List<Mariage> mariagesEnCours = new ArrayList<>();
        List<Mariage> mariagesEchoues = new ArrayList<>();
        List<Homme> hommes = null;
        Session session = null;
       
        Transaction tx = null;
        try {
            
            Query query=session.createQuery( "SELECT m, f, m.dateDebut, m.dateFin, m.nombreEnfants " + "FROM Mariage m " +"JOIN m.mariee f " +
                "WHERE m.mari = :homme");
            
            query.setParameter("homme", homme);

            hommes =  query.list();
            Iterable<Object[]> results = null;

            for (Object[] result : results) {
                Mariage mariage = (Mariage) result[0];
                Femme femme = (Femme) result[1];
                Date dateDebut = (Date) result[2];
                Date dateFin = (Date) result[3];
                int nombreEnfants = (int) result[4];

                Mariage m = new Mariage(femme, dateDebut, dateFin, nombreEnfants);

                if (dateFin == null) {
                    mariagesEnCours.add(m);
                } else {
                    mariagesEchoues.add(m);
                }
            }
        } catch (HibernateException e) {
           if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        
        }

        List<Mariage> allMariages = new ArrayList<>();
        allMariages.addAll(mariagesEnCours);
        allMariages.addAll(mariagesEchoues);

        return allMariages;
    }







    }

    









    

