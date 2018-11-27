/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import com.cruds.pos.util.POSConstant;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sadanand.rudraiah@crudsinfotech.com
 * This is a transaction tables. Maintains info about running tables
 * Running tables are occupied instance of FLoor tables
 * One Floor table once occupied becomes a running table
 * till bill is settled
 */
@Entity
@Table(name = "table_sitting")
public class TableSitting implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="table_sitting_id")     
    private Long id;

/*    @ManyToOne
    @JoinColumn(name = "table_id")
    private FloorTable floorTable; */

    // Trying to denormalize the information
    // keeping references to estb, floor and table master data
    @Column
    private Long floorTableId;

    @Column
    private Long floorId;

    @Column
    private Long estbId;
    
    @Basic
    @Column(name="sit_date")
    private LocalDate sitDate;
    
    @Basic
    @Column(name = "sit_intime")
    private LocalDateTime in_time;
    
    @Basic
    @Column(name = "sit_outtime")
    private LocalDateTime out_time;

    @Column(name= "num_person_sitting")
    private Integer numberOfPersons;
    
    @Column(name="sitting_status", length = 25)
    private String status;    
    
    @OneToMany(mappedBy = "tableSitting", cascade = CascadeType.ALL)
    private List<KOT> listKOT = new ArrayList<>(0);
    
   // @OneToMany(mappedBy = "tableSitting", cascade = CascadeType.ALL)
   // private List<TempBill> listTempBill = new ArrayList<>(0);    
    
    @OneToMany(mappedBy = "tableSitting", cascade = CascadeType.ALL)
    private List<Bill> listBill = new ArrayList<>(0);   
   
    @Column(name = "steward")
    private String steward;

    @Column
    private String customerName;
    
    @Column
    private String specialStatus;
    
    @Column
    private Double discountPercent;
    
    @Column(name="disc_app_user")
    private String discAppUser;
    
    @Column(name = "disc_app_reason")
    private String discAppReason;
    
   // these below fields used for Bill Printing    
    @Transient
    private Double totalBillAmount;
    
    @Transient
    private Double totalTaxAmount;
    
    @Transient
    private Double netBill;    
    
    @Transient
    private Double gst5TaxAmt; 
    
    @Transient
    private Double gst18TaxAmt; 
    
    @Transient
    private Double gst12TaxAmt;    
    
    @Transient
    private Double gst28TaxAmt; 
    
    @Transient
    private Double serVATTaxAmt; 
    
    @Transient
    private List<KOTItem> printKOTItemList;
    
    @Transient
    private Long billNo;    

    @Transient
    String billDate;
    
    @Transient
    String floorTableName;    
    
    @Transient
    String kotIds;
    
    @Transient
    HashMap<Tax, Double> taxMap;
    
    public TableSitting() {
        sitDate = LocalDate.now();
        status = POSConstant.TABLE_RUNNING_STATUS;
    }

    public TableSitting(Long estbId,Long floorId, Long floorTableId, Integer numberOfPersons, String steward ) {
        this();
        this.floorTableId = floorTableId;
        this.floorId = floorId;
        this.estbId = estbId;
        this.numberOfPersons = numberOfPersons;
        this.steward = steward;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSitDate() {
        return sitDate;
    }

    public void setSitDate(LocalDate sitDate) {
        this.sitDate = sitDate;
    }
    
    public LocalDateTime getIn_time() {
        return in_time;
    }

    public void setIn_time(LocalDateTime in_time) {
        this.in_time = in_time;
    }

    public LocalDateTime getOut_time() {
        return out_time;
    }

    public void setOut_time(LocalDateTime out_time) {
        this.out_time = out_time;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public List<KOT> getListKOT() {
        return listKOT;
    }

    public void setListKOT(List<KOT> listKOT) {
        this.listKOT = listKOT;
    }
    
    public void addKOT(KOT kot)
    {
        this.listKOT.add(kot);
        kot.setTableSitting(this);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getFloorTableId() {
        return floorTableId;
    }

//    public List<TempBill> getListTempBill() {
//        return listTempBill;
//    }

 //   public void setListTempBill(List<TempBill> listTempBill) {
 //       this.listTempBill = listTempBill;
 //   }

    public List<Bill> getListBill() {
        return listBill;
    }

    public void setListBill(List<Bill> listBill) {
        this.listBill = listBill;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getEstbId() {
        return estbId;
    }

    public void setEstbId(Long estbId) {
        this.estbId = estbId;
    }

    public Double getTotalBillAmount() {
        return totalBillAmount;
    }

    public void setTotalBillAmount(Double totalBillAmount) {
        this.totalBillAmount = totalBillAmount;
    }

    public Double getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(Double totalTaxAmount) {
        this.totalTaxAmount = totalTaxAmount;
    }

    public String getSteward() {
        return steward;
    }

    public void setSteward(String steward) {
        this.steward = steward;
    }

    public void setFloorTableId(Long floorTableId) {
        this.floorTableId = floorTableId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSpecialStatus() {
        return specialStatus;
    }

    public void setSpecialStatus(String specialStatus) {
        this.specialStatus = specialStatus;
    }

    public Double getGst5TaxAmt() {
        return gst5TaxAmt;
    }

    public void setGst5TaxAmt(Double gst5TaxAmt) {
        this.gst5TaxAmt = gst5TaxAmt;
    }

    public Double getGst18TaxAmt() {
        return gst18TaxAmt;
    }

    public void setGst18TaxAmt(Double gst18TaxAmt) {
        this.gst18TaxAmt = gst18TaxAmt;
    }

    public Double getGst28TaxAmt() {
        return gst28TaxAmt;
    }

    public void setGst28TaxAmt(Double gst28TaxAmt) {
        this.gst28TaxAmt = gst28TaxAmt;
    }

    public Double getSerVATTaxAmt() {
        return serVATTaxAmt;
    }

    public void setSerVATTaxAmt(Double serVATTaxAmt) {
        this.serVATTaxAmt = serVATTaxAmt;
    }

    public Long getBillNo() {
        return billNo;
    }

    public void setBillNo(Long billNo) {
        this.billNo = billNo;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }
    
    public List<KOTItem> getPrintKOTItemList() {
        return printKOTItemList;
    }

    public void setPrintKOTItemList(List<KOTItem> printKOTItemList) {
        this.printKOTItemList = printKOTItemList;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getFloorTableName() {
        return floorTableName;
    }

    public void setFloorTableName(String floorTableName) {
        this.floorTableName = floorTableName;
    }

    public String getKotIds() {
        return kotIds;
    }

    public void setKotIds(String kotIds) {
        this.kotIds = kotIds;
    }

    public HashMap<Tax, Double> getTaxMap() {
        return taxMap;
    }

    public void setTaxMap(HashMap<Tax, Double> taxMap) {
        this.taxMap = taxMap;
    }

    public String getDiscAppUser() {
        return discAppUser;
    }

    public void setDiscAppUser(String discAppUser) {
        this.discAppUser = discAppUser;
    }

    public String getDiscAppReason() {
        return discAppReason;
    }

    public void setDiscAppReason(String discAppReason) {
        this.discAppReason = discAppReason;
    }

    public Double getNetBill() {
        return totalBillAmount + totalTaxAmount;
    }

    public void setNetBill(Double netBill) {
        this.netBill = netBill;
    }

    public Double getGst12TaxAmt() {
        return gst12TaxAmt;
    }

    public void setGst12TaxAmt(Double gst12TaxAmt) {
        this.gst12TaxAmt = gst12TaxAmt;
    }
    
}
