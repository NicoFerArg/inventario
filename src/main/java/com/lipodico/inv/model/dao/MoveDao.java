/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Moves;
import java.util.List;

/**
 *
 * @author flobos
 */
public interface MoveDao {
        
    public List<Moves> listMove();
    public void createMove(Moves m);
    public void deleteMove(Moves m);
    
}
