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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name="establishment")
public class Establishment implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="estb_id")
    private Long id;
    
    @Column(name="estb_name", nullable = false, unique = true)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_master_id")
    private MenuMaster menuMaster;
    
    @OneToMany(mappedBy = "establishment", cascade = CascadeType.ALL)
    private List<Floor> listFloor = new ArrayList<>(0);
    
    
    public Establishment() {
    }

    public Establishment(String name, MenuMaster menuMaster) {
        this.name = name;
        this.menuMaster = menuMaster;
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

    public MenuMaster getMenuMaster() {
        return menuMaster;
    }

    public void setMenuMaster(MenuMaster menuMaster) {
        this.menuMaster = menuMaster;
    }

    public List<Floor> getListFloor() {
        return listFloor;
    }

    public void setListFloor(List<Floor> listFloor) {
        this.listFloor = listFloor;
    }
    
    public void addFloor(Floor floor)
    {
        this.listFloor.add(floor);
        floor.setEstablishment(this);
    }

    @Override
    public String toString() {
        return name;
    }
    
}
