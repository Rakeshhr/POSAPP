/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

//import com.cruds.pos.controller.MenuItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name="l2_menu")
public class L2Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="l2_menu_id")
    private Long id;  

    @Column(name="l2_menu_name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "l1_menu_id")
    private L1Menu l1Menu;    
   
    @OneToMany(mappedBy = "l2Menu", cascade = CascadeType.ALL)
    private List<L3Menu> listL3Menu = new ArrayList<>(0);    
    
    @Column(name = "price")
    private Double price;    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_id")
    private Tax tax;    

    public L2Menu() {
    }

    public L2Menu(String name, L1Menu l1Menu, Double price, Tax tax) {
        this.name = name;
        this.l1Menu = l1Menu;
        this.price = price;
        this.tax = tax;
    }

    public L2Menu(String name) {
        this.name = name;
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

    public L1Menu getL1Menu() {
        return l1Menu;
    }

    public void setL1Menu(L1Menu l1Menu) {
        this.l1Menu = l1Menu;
    }

    public List<L3Menu> getListL3Menu() {
        return listL3Menu;
    }

    public void setListL3Menu(List<L3Menu> listL3Menu) {
        this.listL3Menu = listL3Menu;
    }
    
    public void add(L3Menu l3Menu)
    {
        this.listL3Menu.add(l3Menu);
        l3Menu.setL2Menu(this);
    }    

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    public Tax getTax() {
        if(tax != null)
            return tax;
        else
            return l1Menu.getTax();
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

//    @Override
//    public String getCategory() {
//        return l1Menu.getName();
//    }
    
}
