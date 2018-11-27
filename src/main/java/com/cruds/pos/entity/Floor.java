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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name="estb_Floor")
public class Floor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "floor_id")
    private Long id;

    @Column(name = "floor_name", nullable = false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "estb_id")
    private Establishment establishment;
    
    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<FloorTable> listTables = new ArrayList<>(0);

    public Floor() {
    }

    public Floor(String name, Establishment establishment) {
        this.name = name;
        this.establishment = establishment;
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

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    public List<FloorTable> getListTables() {
        return listTables;
    }

    public void setListTables(List<FloorTable> listTables) {
        this.listTables = listTables;
    }
    
    public void addFloorTable(FloorTable floorTable)
    {
        this.listTables.add(floorTable);
        floorTable.setFloor(this);
    }

    @Override
    public String toString() {
        return name;
    }
    
}
