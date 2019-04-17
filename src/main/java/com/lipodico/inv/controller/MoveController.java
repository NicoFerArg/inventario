
package com.lipodico.inv.controller;

import com.lipodico.inv.entities.Clients;
import com.lipodico.inv.entities.Moves;
import com.lipodico.inv.entities.Parts;
import com.lipodico.inv.entities.TypeMoves;
import com.lipodico.inv.model.service.CarsService;
import java.io.Serializable;
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
@ManagedBean(name="moves")
@ViewScoped
public class MoveController implements Serializable {

    public static final long serialVersionUID = 1L;
    
    @ManagedProperty(value="#{carsService}")
    private CarsService carsService;

    public CarsService getCarsService() {
        return carsService;
    }

    public void setCarsService(CarsService carsService) {
        this.carsService = carsService;
    }
    
    private List<Moves> listMove;
    
    private int id;
    private List<Clients> listClient;
    private List<TypeMoves> listTypeMove;
    private List<Parts> listPart;
    private int quantity;
    
    
    //////////
    
    private int id_client;
    private int id_typemove;
    private int id_part;

    public List<Moves> getListMove() {
        return listMove;
    }

    public void setListMove(List<Moves> listMove) {
        this.listMove = listMove;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Clients> getListClient() {
        return listClient;
    }

    public void setListClient(List<Clients> listClient) {
        this.listClient = listClient;
    }

    public List<TypeMoves> getListTypeMove() {
        return listTypeMove;
    }

    public void setListTypeMove(List<TypeMoves> listTypeMove) {
        this.listTypeMove = listTypeMove;
    }

    public List<Parts> getListPart() {
        return listPart;
    }

    public void setListPart(List<Parts> listPart) {
        this.listPart = listPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_typemove() {
        return id_typemove;
    }

    public void setId_typemove(int id_typemove) {
        this.id_typemove = id_typemove;
    }

    public int getId_part() {
        return id_part;
    }

    public void setId_part(int id_part) {
        this.id_part = id_part;
    }
    
    
    
    @PostConstruct
    public void init(){
    
        listMove = carsService.listMove();
        
        listClient = carsService.listClient();
        listTypeMove = carsService.listTypeMove();
        listPart = carsService.listPart();
   
    }
    
    
    public String save_move(){
    
       
       Clients c= new Clients(id_client);
       TypeMoves t = new TypeMoves(id_typemove);
       Parts p= new Parts(id_part);
       
       Moves m = new Moves(); 
       
       
       m.setClients(c);
       m.setTypeMoves(t);
       m.setParts(p);
       m.setQuantity(quantity);
           
        try{
            
            carsService.createMove(m);
            
        
        }catch(org.springframework.dao.DataIntegrityViolationException e){
            Message("Move already exists",FacesMessage.SEVERITY_ERROR);
            return null; 
        }
         listMove.add(m);
         
         Message("Move saved",FacesMessage.SEVERITY_INFO);
         
         quantity = 0;
         return null;
  
    }
    
    
    
    
     public void Message(String text , FacesMessage.Severity severety){
  
        FacesMessage message = new FacesMessage(text);
        message.setSeverity(severety);
        FacesContext.getCurrentInstance().addMessage(null, message);
     }
    
    
 
    
    public MoveController(){
    }
    
}
