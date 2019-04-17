/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Clients;
import java.util.List;

/**
 *
 * @author flobos
 */
public interface ClientDao {
    
    
    public List<Clients> listClient();
    
}
