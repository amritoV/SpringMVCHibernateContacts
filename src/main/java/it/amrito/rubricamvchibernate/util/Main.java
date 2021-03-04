/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.util;

import it.amrito.rubricamvchibernate.domain.Contact;
import it.amrito.rubricamvchibernate.domain.Group;
import it.amrito.rubricamvchibernate.domain.Message;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDateTime;
import java.time.Month;
/**
 *
 * @author amrit
 */
public class Main {
    
    public static void main(String[] args){
        
        Contact c1=new Contact("Amrito","Verrelli","3801517992","amrito@hotmail.it");
       
        Contact c2=new Contact("lev","tolstoj","12345678","tolstoj@gmail.com");

        Contact c3=new Contact("Milan","Kundera","380667145","Kundera@outlook.in");

        Contact c4=new Contact("Pippo","Baudo","356123785","Pippo@live.it");

        
        Group g1=new Group("calcetto-family", "Calcetto del venerdì, essere puntuali",c1);

        
        c1.addGruppoRelationship(g1);
        
        c2.addGruppoRelationship(g1);
        
        Message m1=new Message("Ciao a tutti ragazzi, benvenuti nel gruppo", c1, g1);
        c1.getMessages().add(m1);
        g1.getMessages().add(m1);
        
        System.out.println(m1.getDate());
        
      
        Message m2=new Message("Ciao grazie per l'invito",c2,g1);
        c2.getMessages().add(m2);
        g1.getMessages().add(m2);
        
       
        
        
        Message m3=new Message("Di nulla", c1, g1);
        
        
        m3.setDate(LocalDateTime.of(2012, Month.MARCH, 03, 14, 1));
        
        c1.getMessages().add(m3);
        g1.getMessages().add(m3);
        
        
        System.out.println(g1.getMessages());
        
        
    }
    
    
    
    
    
    
    
    
    
   
}
