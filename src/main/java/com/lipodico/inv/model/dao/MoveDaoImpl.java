/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Moves;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author flobos
 */

@Repository("moveDao")
public class MoveDaoImpl implements MoveDao, Serializable {

    private static final long serialVersionUID = 1L;
   
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Session getSession(){
    
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<Moves> listMove(){
    
        return getSession().createQuery("select m from Moves m order by m.id desc").list();
    
    }
    
    @Override
    public void createMove(Moves m){
    
        getSession().save(m);
    
    }
    
    @Override
    public void deleteMove(Moves m){
    
        getSession().delete(m);
    
    }
    
    
    
    
}
