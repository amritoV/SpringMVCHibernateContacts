/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.dao.impl;

import it.amrito.rubricamvchibernate.dao.ContactDao;
import it.amrito.rubricamvchibernate.domain.Contact;
import java.util.List;
import java.util.Set;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amrit
 */
@Repository
public class ContactDaoImpl implements ContactDao {
    
    @Autowired
    SessionFactory factory;
    
    @Override
    public List<Contact> findAll() {
        List<Contact> contatti = factory.getCurrentSession()
                                        .createQuery("FROM Contact")
                                        .list();
        return contatti;
    }

    @Override
    public void removeAll() {
        factory.getCurrentSession()
               .createSQLQuery("DELETE FROM Contact")
               .executeUpdate();
    }

    @Override
    public Boolean removeContactById(Long id) {
        Contact contact=getContactById(id);
        if(contact == null) return false;
        factory.getCurrentSession()
               .delete(contact);
        return true;
    }

    @Override
    public void save(Contact contact) {
        if(contact.getId() == null)
            factory.getCurrentSession().save(contact);
        else
            factory.getCurrentSession().update(contact);
    }

    @Override
    public Contact getContactById(Long id) {
        return (Contact)factory.getCurrentSession().get(Contact.class, id);
    }
    
}
