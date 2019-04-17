package com.lipodico.inv.entities;
// Generated 30-12-2018 07:28:40 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * TypeMoves generated by hbm2java
 */
@Entity
@Table(name="type_moves"
    ,catalog="inventario"
    , uniqueConstraints = @UniqueConstraint(columnNames="name") 
)
public class TypeMoves  implements java.io.Serializable {


     private int id;
     private String name;
     private Date createdAt;
     private Set<Moves> moveses = new HashSet<Moves>(0);

    public TypeMoves() {
    }
    
     public TypeMoves(int id) {
        this.id = id;
       
    }
    
    
    public TypeMoves(int id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }
    public TypeMoves(int id, String name, Date createdAt, Set<Moves> moveses) {
       this.id = id;
       this.name = name;
       this.createdAt = createdAt;
       this.moveses = moveses;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="name", unique=true, nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false, length=19)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="typeMoves")
    public Set<Moves> getMoveses() {
        return this.moveses;
    }
    
    public void setMoveses(Set<Moves> moveses) {
        this.moveses = moveses;
    }




}


