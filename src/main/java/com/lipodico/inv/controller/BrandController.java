
package com.lipodico.inv.controller;

import com.lipodico.inv.entities.Brands;
import com.lipodico.inv.model.service.CarsService;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author flobos
 */

@ManagedBean(name="brands")
@ViewScoped
public class BrandController implements Serializable {

   public static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{carsService}")
    private CarsService carsService;

    public CarsService getCarsService() {
        return carsService;
    }

    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }

   
    
    private int id;
    private String name;
    private Date createdat;
    private List<Brands> listBrand;
    private Brands selectedBrand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public List<Brands> getListBrand() {
        return listBrand;
    }

    public void setListBrand(List<Brands> listBrand) {
        this.listBrand = listBrand;
    }

    public Brands getSelectedBrand() {
        return selectedBrand;
    }

    public void setSelectedBrand(Brands selectedBrand) {
        this.selectedBrand = selectedBrand;
    }
    
    
    
       
    
    @PostConstruct
    public void init(){
    
        listBrand = carsService.listBrand();
    
   }
    
    
    public String save(){
    
       Brands b= new Brands();
        
        b.setName(name);
        
        try{
            
            carsService.createBrand(b);
            
        
        }catch(org.springframework.dao.DataIntegrityViolationException e){
            Message("Brand already exists",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listBrand.add(b);
         
         Message("Brand saved",FacesMessage.SEVERITY_INFO);
         
         name = null;
         return null;
  
    }
    
    
    public String deleteBrand(){
    
        try{

                carsService.deleteBrand(selectedBrand);


        }catch(RuntimeException ex){
            Message("Error",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
        
        listBrand.remove(selectedBrand);    
        Message("Item Deleted",FacesMessage.SEVERITY_ERROR);

        
        return null;
    }
    
    
    public void Message(String text , FacesMessage.Severity severety){
  
      FacesMessage message = new FacesMessage(text);
      message.setSeverity(severety);
      FacesContext.getCurrentInstance().addMessage(null, message);
      
      
      
  }
    
    public BrandController() {
    }
    
}
