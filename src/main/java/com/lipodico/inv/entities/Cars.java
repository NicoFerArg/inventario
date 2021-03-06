package com.lipodico.inv.entities;
// Generated 30-12-2018 07:28:40 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Cars generated by hbm2java
 */
@Entity
@Table(name="cars"
    ,catalog="inventario"
)
public class Cars  implements java.io.Serializable {


     private Integer id;
     private Brands brands;
     private String model;
     private int year;
     private Date createdAt;

    public Cars() {
    }

    public Cars(Brands brands, String model, int year, Date createdAt) {
       this.brands = brands;
       this.model = model;
       this.year = year;
       this.createdAt = createdAt;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_brands", nullable=false)
    public Brands getBrands() {
        return this.brands;
    }
    
    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    
    @Column(name="model", nullable=false, length=100)
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    
    @Column(name="year", nullable=false)
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", nullable=false, length=19)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




}


