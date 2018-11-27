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
@Table(name="l1_menu")
public class L1Menu implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="l1_menu_id")
    private Long id;  

    @Column(name="l1_menu_name", nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "l1Menu", cascade = CascadeType.ALL)
    private List<L2Menu> listL2Menu = new ArrayList<>(0);

    @ManyToOne
    @JoinColumn(name = "menu_master_id")
    private MenuMaster menumaster;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_id")
    private Tax tax;

    public L1Menu() {
    }

    public L1Menu(String name, MenuMaster menumaster, Tax tax) {
        this.name = name;
        this.menumaster = menumaster;
        this.tax = tax;
    }
    
    public L1Menu(String name) {
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

    public MenuMaster getMenumaster() {
        return menumaster;
    }

    public void setMenumaster(MenuMaster menumaster) {
        this.menumaster = menumaster;
    }
    
    public void add(L2Menu l2Menu)
    {
        this.listL2Menu.add(l2Menu);
        l2Menu.setL1Menu(this);
    }

    public List<L2Menu> getListL2Menu() {
        return listL2Menu;
    }

    public void setListL2Menu(List<L2Menu> listL2Menu) {
        this.listL2Menu = listL2Menu;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
