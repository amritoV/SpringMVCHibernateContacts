/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.amrito.rubricamvchibernate.business.impl;

import it.amrito.rubricamvchibernate.business.GroupBo;
import it.amrito.rubricamvchibernate.dao.GroupDao;
import it.amrito.rubricamvchibernate.domain.Contact;
import it.amrito.rubricamvchibernate.domain.Group;
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
public class GroupBoImpl implements GroupBo{
    
    @Autowired
    private GroupDao groupDao;

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean removeGroupById(Long id) {
        return groupDao.removeGrouptById(id);
    }

    @Override
    public void save(Contact contact) {
        groupDao.save(contact);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDao.getGroupById(id);
    }
    
}
