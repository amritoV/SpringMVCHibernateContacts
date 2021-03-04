/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.business.impl;

import it.amrito.rubricamvchibernate.business.ContactBo;
import it.amrito.rubricamvchibernate.dao.ContactDao;
import it.amrito.rubricamvchibernate.dao.impl.ContactDaoImpl;
import it.amrito.rubricamvchibernate.domain.Contact;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amrit
 */
@Service
@Transactional
public class ContactBoImpl implements ContactBo{
    
    @Autowired
    private ContactDao contactDao;

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
    }

    @Override
    public void removeAll() {
        contactDao.removeAll();
    }

    @Override
    public Boolean removeContactById(Long id) {
        return contactDao.removeContactById(id);
    }

    @Override
    public void save(Contact contact) {
        contactDao.save(contact);
    }

    @Override
    public Contact getContactById(Long id) {
        return contactDao.getContactById(id);
    }

    
    
}
