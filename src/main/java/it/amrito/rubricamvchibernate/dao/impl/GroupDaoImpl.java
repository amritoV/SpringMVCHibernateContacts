/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.dao.impl;

import it.amrito.rubricamvchibernate.dao.GroupDao;
import it.amrito.rubricamvchibernate.domain.Contact;
import it.amrito.rubricamvchibernate.domain.Group;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amrit
 */
@Repository
public class GroupDaoImpl implements GroupDao {
    
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Group> findAll() {
        return factory.getCurrentSession()
                      .createQuery("FROM Group")
                      .list();
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeGrouptById(Long id) {
        Group group=getGroupById(id);
        if(group == null)
            return false;
        factory.getCurrentSession().delete(group);
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
    public Group getGroupById(Long id) {
        return factory.getCurrentSession().get(Group.class, id);
    }
    
}
