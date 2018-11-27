/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

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
@Table(name = "bill_item")
public class BillItem implements Serializable {
    
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="bill_item_id")     
  private Long id;     
    
    @Column
    private Long kotItemId;
  
    @Column
    private int slNo;
    
    @Column
    private Long itemCode;
    
    @Column
    private String description;
    
    @Column
    private Double price;
    
    @Column
    private Double qty;

    @Column
    private Double total;

    @Column
    private String category;
    
    @Column
    private Long taxId;
    
    @Column(name="tax_rate")
    private Double taxRate;
    
    @Column(name = "tax_name")
    private String taxName;

    @Column(name = "tax_amt")
    private Double taxAmt; 
    
    @Column
    private Long kotId;
    
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public BillItem() {
    }

    public BillItem(Long kotItemId, int slNo, Long itemCode, String description, Double price, Double qty, Double total, String category, Long taxId, Double taxRate, String taxName, Double taxAmt, Long kotId) {
        this.kotItemId = kotItemId;
        this.slNo = slNo;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.qty = qty;
        this.total = total;
        this.category = category;
        this.taxId = taxId;
        this.taxRate = taxRate;
        this.taxName = taxName;
        this.taxAmt = taxAmt;
        this.kotId = kotId;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSlNo() {
        return slNo;
    }

    public void setSlNo(int slNo) {
        this.slNo = slNo;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getTaxId() {
        return taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public Double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(Double taxAmt) {
        this.taxAmt = taxAmt;
    }

    public Long getKotId() {
        return kotId;
    }

    public void setKotId(Long kotId) {
        this.kotId = kotId;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Long getKotItemId() {
        return kotItemId;
    }

    public void setKotItemId(Long kotItemId) {
        this.kotItemId = kotItemId;
    }
  
}
