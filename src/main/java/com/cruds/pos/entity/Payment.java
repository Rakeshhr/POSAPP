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
@Table(name = "payment")
public class Payment implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")     
    private Long id;    
    
    @Column(name = "mode")
    private String mode;    
    
    
    @Column(name="amount")
    private Double amount;
    
    @Column(name="cc_number")
    private String ccNumber;

    @Column(name="description")
    private String description;
    
   @ManyToOne
   @JoinColumn(name = "bill_id")
   private Bill bill;
   
   @Column
   private String comments;
   
   @Column
   private Boolean isDeleted;
   
   @Column
   private String approvedBy;   
    
    public Payment() {
    }

    public Payment(String mode, Double amount) {
        this.mode = mode;
        this.amount = amount;
    }

    public Payment(String mode, Double amount, String ccNumber, String description) {
        this.mode = mode;
        this.amount = amount;
        this.ccNumber = ccNumber;
        this.description = description;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
 
}
