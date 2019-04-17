
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Brands;
import com.lipodico.inv.entities.Parts;
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

@Repository("partDao")
public class PartDaoImpl implements PartDao , Serializable {
   
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
    public List<Parts> listPart(){
    
        return getSession().createQuery("select b from Parts b order by b.id desc").list();
    }
    
    @Override
    public List<Parts> listByBrand(int id_brand){
     
        return getSession().createQuery("select p from Parts p where p.brands.id=:id_brand").setParameter("id_brand", id_brand).list();
    }
    
    @Override
    public void createPart(Parts p){
    
        getSession().save(p);
    
    }
    
    @Override
    public void deletePart(Parts p){
    
        getSession().delete(p);
    
    }
    
}
