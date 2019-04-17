/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.service;

import com.lipodico.inv.entities.Brands;
import com.lipodico.inv.entities.Clients;
import com.lipodico.inv.entities.Moves;
import com.lipodico.inv.entities.Parts;
import com.lipodico.inv.entities.TypeMoves;
import java.util.List;

/**
 *
 * @author flobos
 */
public interface CarsService {
  
    //Brands
    public void createBrand(Brands b);
    public void deleteBrand(Brands b);
    public List<Brands> listBrand();
    
   //Parts
    public void createPart(Parts p);
    public void deletePart(Parts p);
    public List<Parts> listPart();
    public List<Parts> listByBrand(int id_brand);
    
    //Moves
    public void createMove(Moves m);
    public void deleteMove(Moves m);
    public List<Moves> listMove();
    
    //Clients
    
    public List<Clients> listClient();
    
    //TypeMoves
    
    public List<TypeMoves> listTypeMove();
    
    
}
