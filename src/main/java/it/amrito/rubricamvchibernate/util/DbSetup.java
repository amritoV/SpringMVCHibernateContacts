/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.util;

import org.hibernate.SessionFactory;
import it.amrito.rubricamvchibernate.domain.Contact;
import it.amrito.rubricamvchibernate.domain.Group;
import it.amrito.rubricamvchibernate.domain.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author amrit
 */
@Component
public class DbSetup {
    
    
    @Autowired
    private SessionFactory sessionFactory;
    
    
    public void initialize(){
        System.out.println("Initializing db()");
        setUp();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void setUp(){
        //Email c1sMail=new Email("amrito@hotmail.it");
        Contact c1=new Contact("Amrito","Verrelli","3801517992","amrito@hotmail.it");
        //c1.addEmailRelationship(c1sMail);
        
       
        
        //Email c2sMail=new Email("tolstoj@gmail.com");
        Contact c2=new Contact("lev","tolstoj","12345678","tolstoj@gmail.com");
        //c2.addEmailRelationship(c2sMail);
        
        //Email c3sMail=new Email("Kundera@outlook.in");
        Contact c3=new Contact("Milan","Kundera","380667145","Kundera@outlook.in");
        //c3.addEmailRelationship(c3sMail);
        
        //Email c4sMail=new Email("Pippo@live.it");
        Contact c4=new Contact("Pippo","Baudo","356123785","Pippo@live.it");
        //c4.addEmailRelationship(c4sMail);
        
        Group g1=new Group("calcetto-family", "Calcetto del venerdì, essere puntuali",c1);
        //c1.addGruppoProprietarioRelationship(g1);
        
        c1.addGruppoRelationship(g1);
        
        c2.addGruppoRelationship(g1);
        
        Message m1=new Message("Ciao a tutti ragazzi, benvenuti nel gruppo", c1, g1);
        c1.getMessages().add(m1);
        g1.getMessages().add(m1);
        
        try{
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            Logger.getLogger(DbSetup.class.getName()).log(Level.SEVERE, null, ex);
        }

        
      
        Message m2=new Message("Ciao grazie per l'invito",c2,g1);
        c2.getMessages().add(m2);
        g1.getMessages().add(m2);
        
       try{
            Thread.sleep(1200);
        } catch (InterruptedException ex) {
            Logger.getLogger(DbSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Message m3=new Message("Di nulla", c1, g1);
        c1.getMessages().add(m3);
        g1.getMessages().add(m3);
        
        
        Group g2=new Group("Studio e ripasso di matematica","Regole del gruppo:.....",c4);
        //g2.addOwnerRelationship(c4);
        
        c1.addGruppoRelationship(g2);
        
        Message m4=new Message("ciao sono pipo benvenuti nel gruppo di matiematica",c4,g2);
        c4.getMessages().add(m4);
        g2.getMessages().add(m4);
        
        //Email c5sMail=new Email("balboa@hotmail.it");
        Contact c5=new Contact("Rocky","Balboa","571239908","balboa@hotmail.it");
        //c5.addEmailRelationship(c5sMail);
        
        Group g3=new Group("Hibernate immersion", "Benvenuti nel gruppo dedicato alle problematiche di Hibernate",c3);
        //g3.setOwner(c3);
        c1.addGruppoRelationship(g3);
        c2.addGruppoRelationship(g3);
        c3.addGruppoRelationship(g3);
        c4.addGruppoRelationship(g3);
        c5.addGruppoRelationship(g3);
        
        Session session=sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(c1);
            session.save(c2);
            session.save(c3);
            session.save(c4);
            session.save(c5);
            //session.save(g1);
            //session.save(c1sMail);
            //session.save(c2sMail);
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null) tx.rollback();
            System.err.println(e);
        }
        
        finally {session.close();}
        
        
    }
    
    public void setUp2(){
        //Email c1sMail=new Email("amrito@hotmail.it");
        Contact c1=new Contact("Amrito","Verrelli","3801517992","amrito@hotmail.it");
        //c1.addEmailRelationship(c1sMail);
        
        
        Group g1=new Group("calcetto-family", "Calcetto del venerdì, essere puntuali",c1);
        //g1.addOwnerRelationship(c1);
        Session session=sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(c1);
            session.save(g1);
            tx.commit();
            
        }
        catch(HibernateException e){
            if(tx!=null) tx.rollback();
            System.err.println(e);
        }
        
        finally {session.close();}
    }
    
}
