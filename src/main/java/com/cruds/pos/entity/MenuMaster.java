/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name="menu_master")
public class MenuMaster implements Serializable{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_master_id")
    private Long id;  

    @Column(name="menu_master_name", nullable = false, unique = true)
    private String name;
    
    @OneToMany(mappedBy = "menumaster", cascade = CascadeType.ALL)
    private List<L1Menu> listL1Menu = new ArrayList<>(0);

    
    public MenuMaster() {
    }

    public MenuMaster(String name) {
        this.name = name;
    }

    public MenuMaster(Long id, String name) {
        this.id = id;
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

    public List<L1Menu> getListL1Menu() {
        return listL1Menu;
    }

    public void setListL1Menu(List<L1Menu> listL1Menu) {
        this.listL1Menu = listL1Menu;
    }
    
    public void addL1Menu(L1Menu l1Menu)
    {
        this.listL1Menu.add(l1Menu);
        l1Menu.setMenumaster(this);
    }

    @Override
    public String toString() {
        //return name + ":" + listL1Menu;
        return name;
    }
    
}
