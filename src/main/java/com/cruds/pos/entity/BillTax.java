/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

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
@Table(name = "bill_taxes")
public class BillTax implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="billtax_id")     
   private Long id;
   
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "tax_id")
   private Tax tax; 
   
   @Column
   private double taxAmount;
   
   @ManyToOne
   @JoinColumn(name = "bill_id")
   private Bill bill;

   public BillTax() {
   }

    public BillTax(Tax tax, double taxAmount) {
        this.tax = tax;
        this.taxAmount = taxAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
    
}
