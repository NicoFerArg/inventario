
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Clients;
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
@Repository("clientDao")
public class ClientDaoImpl implements ClientDao, Serializable {
    
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
    public List<Clients> listClient(){
    
        return getSession().createQuery("select c from Clients c").list();
    
    }
    
}
