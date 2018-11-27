/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import java.io.Serializable;
import java.util.Objects;
import javafx.scene.control.CheckBox;
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
import javax.persistence.Transient;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 */
@Entity
@Table(name = "kot_item")
public class KOTItem implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="kot_item_id")        
    private Long id;

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
    
    @Column(name="tax_rate")
    private Double taxRate;
    
    @Column(name = "tax_name")
    private String taxName;

    @Column(name = "tax_amt")
    private Double taxAmt;
    
    @Column
    private String itemCancelRemarks;
    
    @ManyToOne
    @JoinColumn(name = "kot_id")
    private KOT kot;
    
    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;    
    
    @Column
    private String paid;
    
    @Column
    private String status;

    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    @JoinColumn(name = "tax_id")
    private Tax tax;    
    
    @Column(name="special_instruction")
    private String splInstruction;
    
    @Column(name="cancel_auth_user")
    private String cancelAuthUser;
    
    @Column(name="old_kotId")
    private Long oldKOTId;    // to handle Table Transfer
    
    @Column(name="billable")
    private Boolean billable;  // to handle multiple scenario of cancel and transfer
    
//    @Transient
//    private CheckBox chkBox;
//    
//    public KOTItem() {
//        chkBox = new CheckBox();
//    }

    public KOTItem(Long itemCode, String description, Double price, String category, Double taxRate) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.category = category;
        this.qty = 1d; // defaults to 1 Qty
        this.taxRate = taxRate;
        this.taxAmt = qty * price * (taxRate/100); 
        //this.total = (qty * price) + taxAmt;
        this.total = (qty * price);
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
        reCalcTotal();
    }

    public Double getTotal() {
        //return qty * price;
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

    public String getItemCancelRemarks() {
        return itemCancelRemarks;
    }

    public void setItemCancelRemarks(String itemCancelRemarks) {
        this.itemCancelRemarks = itemCancelRemarks;
    }

    public KOT getKot() {
        return kot;
    }

    public void setKot(KOT kot) {
        this.kot = kot;
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
    
    public void reCalcTotal()
    {
        this.taxAmt = qty * price * (taxRate/100); 
        this.total = (qty * price);
    }
    
    @Override
    public String toString() {
        
        return String.format("%1$-20s", description) + "\t\t " + qty ;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.itemCode);
        hash = 43 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KOTItem other = (KOTItem) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.itemCode, other.itemCode);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public CheckBox getChkBox() {
//        return chkBox;
//    }
//
//    public void setChkBox(CheckBox chkBox) {
//        this.chkBox = chkBox;
//    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getSplInstruction() {
        return splInstruction;
    }

    public void setSplInstruction(String splInstruction) {
        this.splInstruction = splInstruction;
    }

    public String getCancelAuthUser() {
        return cancelAuthUser;
    }

    public void setCancelAuthUser(String cancelAuthUser) {
        this.cancelAuthUser = cancelAuthUser;
    }

    public Long getOldKOTId() {
        return oldKOTId;
    }

    public void setOldKOTId(Long oldKOTId) {
        this.oldKOTId = oldKOTId;
    }

    public Boolean getBillable() {
        return billable;
    }

    public void setBillable(Boolean billable) {
        this.billable = billable;
    }
    
}
