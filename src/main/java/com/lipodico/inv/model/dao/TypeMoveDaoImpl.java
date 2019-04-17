
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.TypeMoves;
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

@Repository("typemoveDao")
public class TypeMoveDaoImpl implements TypeMoveDao, Serializable {
    
    
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
    public List<TypeMoves> listTypeMove(){
    
        return getSession().createQuery("select t from TypeMoves t").list();
    }
}
