/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lipodico.inv.model.dao;

import com.lipodico.inv.entities.Brands;
import java.util.List;

/**
 *
 * @author flobos
 */
public interface BrandDao {
    
    public List<Brands> listBrand();
    public void createBrand(Brands b);
     public void deleteBrand(Brands b);
    
    
}
