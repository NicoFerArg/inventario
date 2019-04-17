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
import com.lipodico.inv.model.dao.BrandDao;
import com.lipodico.inv.model.dao.ClientDao;
import com.lipodico.inv.model.dao.MoveDao;
import com.lipodico.inv.model.dao.PartDao;
import com.lipodico.inv.model.dao.TypeMoveDao;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author flobos
 */
@Service("carsService")
@Transactional
public class CarsServiceImpl implements CarsService, Serializable{
    
    private static final long serialVersionUID = 1L;

   @Autowired
    private BrandDao brandDao;
   
   @Autowired
    private PartDao partDao;
   
    @Autowired
    private MoveDao moveDao;
   
    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private TypeMoveDao typemoveDao;
    
    
    public BrandDao getBrandDao() {
        return brandDao;
    }

    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public PartDao getPartDao() {
        return partDao;
    }

    public void setPartDao(PartDao partDao) {
        this.partDao = partDao;
    }

    public MoveDao getMoveDao() {
        return moveDao;
    }

    public void setMoveDao(MoveDao moveDao) {
        this.moveDao = moveDao;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public TypeMoveDao getTypemoveDao() {
        return typemoveDao;
    }

    public void setTypemoveDao(TypeMoveDao typemoveDao) {
        this.typemoveDao = typemoveDao;
    }
    
    
    
    
    
    
    
    
    
    //brands
    @Override
    public List<Brands> listBrand(){
    
        return brandDao.listBrand();
    }
    
    @Override
    public void createBrand(Brands b){
    
        brandDao.createBrand(b);
    }
    
    @Override
    public void deleteBrand(Brands b){
    
        brandDao.deleteBrand(b);
    }
    
    
    //Parts
    @Override
    public List<Parts> listPart(){
    
        return partDao.listPart();
    }
    
    @Override
    public void createPart(Parts p){
    
        partDao.createPart(p);
    }
    
    @Override
    public void deletePart(Parts p){
    
        partDao.deletePart(p);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Parts> listByBrand(int id_brand){
    
        return partDao.listByBrand(id_brand);
    }
    
        //Moves
    
    @Override
    @Transactional(readOnly = true)
    public List<Moves> listMove(){
    
        return moveDao.listMove();
    }
    
    @Override
    public void createMove(Moves m){
    
        moveDao.createMove(m);
    }
    
    @Override
    public void deleteMove(Moves m){
    
        moveDao.deleteMove(m);
    }
    
    //Clients
    
    @Override
    @Transactional(readOnly = true)
    public List<Clients> listClient(){
    
        return clientDao.listClient() ;
    }
    
    
    //TypeMoves
    
    @Override
    @Transactional(readOnly = true)
    public List<TypeMoves> listTypeMove(){
    
        return typemoveDao.listTypeMove() ;
    }
    
    


}
