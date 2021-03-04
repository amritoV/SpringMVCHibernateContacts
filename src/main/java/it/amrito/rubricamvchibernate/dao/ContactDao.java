/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.dao;

import it.amrito.rubricamvchibernate.domain.Contact;
import java.util.List;

/**
 *
 * @author amrit
 */
public interface ContactDao {
    
    List<Contact> findAll();
    
    void removeAll();
    
    Boolean removeContactById(Long id);
    
    void save(Contact contact);
    
    Contact getContactById(Long id);
    
}
