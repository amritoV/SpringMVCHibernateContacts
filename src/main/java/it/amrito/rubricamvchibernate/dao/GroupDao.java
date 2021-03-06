/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.dao;

import it.amrito.rubricamvchibernate.domain.Contact;
import it.amrito.rubricamvchibernate.domain.Group;
import java.util.List;

/**
 *
 * @author amrit
 */
public interface GroupDao {
    
    List<Group> findAll();
    
    void removeAll();
    
    Boolean removeGrouptById(Long id);
    
    void save(Contact contact);
    
    Group getGroupById(Long id);
    
}
