/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

//import com.cruds.pos.controller.MenuItem;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name="l3_menu")
public class L3Menu implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="l3_menu_id")    
    private Long id;

    @Column(name="l3_menu_name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "l2_menu_id")
    private L2Menu l2Menu;
    
    @Column(name = "price")
    private Double price;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_id")
    private Tax tax;    
    
    public L3Menu() {
    }

    public L3Menu(String name, L2Menu l2Menu, Double price, Tax tax) {
        this.name = name;
        this.l2Menu = l2Menu;
        this.price = price;
        this.tax = tax;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public L2Menu getL2Menu() {
        return l2Menu;
    }

    public void setL2Menu(L2Menu l2Menu) {
        this.l2Menu = l2Menu;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    

//    @Override
//    public String getCategory() {
//        return l2Menu.getCategory();
//    }

    @Override
	public String toString() {
		return "L3Menu [id=" + id + ", name=" + name + ", l2Menu=" + l2Menu + ", price=" + price + ", tax=" + tax + "]";
	}

	public Tax getTax() {
        if(tax != null)
            return tax;
        else
            return l2Menu.getTax();
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }
    
    
}
