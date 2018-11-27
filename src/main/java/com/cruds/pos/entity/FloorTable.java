/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import com.cruds.pos.util.POSConstant;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name = "floor_table")
public class FloorTable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="table_id")      
    private Long id;
    
    @Column(name = "table_name", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;
    
    @Column(name="table_status", length = 25)
    private String status;
    
    @Column(name="max_capacity")
    private Integer max_capacity;
    
 //   @OneToMany(mappedBy = "floorTable", cascade = CascadeType.ALL)
 //   private List<TableSitting> listTableSitting = new ArrayList<>(0);

    public FloorTable() {
    }

    public FloorTable(String name, Floor floor, Integer max_capacity) {
        this.name = name;
        this.floor = floor;
        this.max_capacity = max_capacity;
        this.status = POSConstant.INACTIVE_STATUS;
    }
    
    public FloorTable(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(Integer max_capacity) {
        this.max_capacity = max_capacity;
    }

 /*   public List<TableSitting> getListTableSitting() {
        return listTableSitting;
    }

    public void setListTableSitting(List<TableSitting> listTableSitting) {
        this.listTableSitting = listTableSitting;
    }
    
    public void addTableSitting(TableSitting tableSitting)
    {
        this.listTableSitting.add(tableSitting);
        tableSitting.setFloorTable(this);
    }*/

    @Override
    public String toString() {
        return name;
    }
    
}
