/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Brands;
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
@Repository("brandDao")
public class BrandDaoImpl implements BrandDao, Serializable {
    
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
    public List<Brands> listBrand(){
    
        return getSession().createQuery("select b from Brands b order by b.id desc").list();
    
    }
    
    @Override
    public void createBrand(Brands b){
    
        getSession().save(b);
    
    }
    
    @Override
    public void deleteBrand(Brands b){
    
        getSession().delete(b);
    
    }
    
    
    
}
