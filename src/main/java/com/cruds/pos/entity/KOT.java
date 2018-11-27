/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
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
import javax.persistence.Transient;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name = "KOT")
public class KOT implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kot_id")     
    private Long id;

    @ManyToOne
    @JoinColumn(name = "table_sitting_id", updatable = false)
    private TableSitting tableSitting;
    
    @Column(name = "kot_status")
    private String status;
    
    @OneToMany(mappedBy = "kot", cascade = CascadeType.ALL)
    private List<KOTItem> listKOTItem = new ArrayList<>(0);
    
    @Column
    private Boolean isTransfered;
    
    
    @Transient
    private String kotType;
    
    //TO DO
    // in time
    // out time
    // Staff Id
    // channel ID
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TableSitting getTableSitting() {
        return tableSitting;
    }

    public void setTableSitting(TableSitting tableSitting) {
        this.tableSitting = tableSitting;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addKOTItem(KOTItem kotItem)
    {
        this.listKOTItem.add(kotItem);
        kotItem.setKot(this);
    }
    
    public List<KOTItem> getListKOTItem() {
        return listKOTItem;
    }

    public void setListKOTItem(List<KOTItem> listKOTItem) {
        this.listKOTItem = listKOTItem;
    }
    
    public void addKOTItemList(List<KOTItem> listKOTItems) {
       for(KOTItem item : listKOTItems)
       {
             this.listKOTItem.add(item);
             item.setKot(this);
       }
    }    

    public void addKOTItemList(ObservableList<KOTItem> listKOTItems) {
       for(KOTItem item : listKOTItems)
       {
             this.listKOTItem.add(item);
             item.setKot(this);
       }
    }

    public String getKotType() {
        return kotType;
    }

    public void setKotType(String kotType) {
        this.kotType = kotType;
    }

    public Boolean getIsTransfered() {
        return isTransfered;
    }

    public void setIsTransfered(Boolean isTransfered) {
        this.isTransfered = isTransfered;
    }
    
    @Override
    public String toString() {
        if(isTransfered != null)
        {
            // To indicate a Transferred KOT
           return String.valueOf(id) + "T"; 
        }
        else
        {
            return String.valueOf(id);
        }
        
    }
    
}
