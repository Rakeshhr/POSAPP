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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "bill")
public class Bill implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="bill_id")     
   private Long id;    
   
   @Basic
   @Column(name="bill_date")
   private LocalDate billDate;
    
   @Basic
   @Column(name="bill_created_date")
   private LocalDateTime createdDate;    
    
    @Column(name="amount")
    private Double amount; 
    
    @Column(name="totalTax")
    private Double totalTax;
    
    @Column(name="netAmount")
    private Double netAmount;
    
    @ManyToOne
    @JoinColumn(name = "table_sitting_id")
    private TableSitting tableSitting;   
    
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<Payment> paymentList = new ArrayList<>(0);
    
    @Column(name = "bill_type")
    private String type;
    
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillTax> listBillTaxes = new ArrayList<>(0);
    
 //   @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
 //   @Transient
  //  private List<KOTItem> listKOTItem = new ArrayList<>(0);
    
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
    private List<BillItem> listBillItem = new ArrayList<>(0);    
    
    @Column(name = "disc_percent")
    private Double discount;
    
    @Column
    private String status;
    
    @Column
    private String floorTableName;
    
    @Column
    private String kotNos;
    
    @Column
    private String steward;
    
    @Column
    private Integer covers;
    
    @Column
    private Integer totalItems;
    
    @Column
    private String billGenUserId;
    
    @Column(name="disc_app_user")
    private String discAppUser;
    
    @Column(name = "disc_app_reason")
    private String discAppReason;  
    
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
    private String strBillDate;
    
    public Bill() {
        this.billDate = LocalDate.now();
        this.createdDate = LocalDateTime.now();
    }

    public Bill(Double amount) {
        //this.billDate = billDate;
        this();
        this.amount = amount;
        this.status = POSConstant.TABLE_BILL_PRINTED_STATUS;
    }

    public Bill(Double amount, Double totalTax, Double discount, String floorTableName) {
        this();
        this.amount = amount;
        this.totalTax = totalTax;
        this.floorTableName = floorTableName;
        if(discount != null)
        {
            this.discount = discount;
        }
    }

    public Bill(Double amount,Double totalTax, String floorTableName, String kotNos, String steward, Integer covers, String billGenUserId) {
        this();
        this.amount = amount;
        this.totalTax = totalTax;
        this.floorTableName = floorTableName;
        this.kotNos = kotNos;
        this.steward = steward;
        this.covers = covers;
        this.billGenUserId = billGenUserId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public TableSitting getTableSitting() {
        return tableSitting;
    }

    public void setTableSitting(TableSitting tableSitting) {
        this.tableSitting = tableSitting;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }
    
    public void addPayment(Payment p)
    {
        this.paymentList.add(p);
        p.setBill(this);
    } 
    
    public void addAmt(Double amt)
    {
        if(this.amount != null)
        {
            this.amount = this.amount + amt;    
        }else
        {
            this.amount = amt;
        }
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

//    @Deprecated
//    @Override
//    public Long getBillId() {
//        return id;
//    }

//    @Override
//    public Double getBillAmount() {
//        return amount;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BillTax> getListBillTaxes() {
        return listBillTaxes;
    }

    public void setListBillTaxes(List<BillTax> listBillTaxes) {
        this.listBillTaxes = listBillTaxes;
    }
   
    public void addBillItem(BillItem billItem)
    {
        this.listBillItem.add(billItem);
        billItem.setBill(this);
    }
    
   public void addBillTax(BillTax billTax)
   {
      listBillTaxes.add(billTax);
      billTax.setBill(this);
   }

/*   
    public List<KOTItem> getListKOTItem() {
        return listKOTItem;
    }

    public void setListKOTItem(List<KOTItem> listKOTItem) {
        for(KOTItem item : listKOTItem)
        {
            this.listKOTItem.add(item);
            item.setBill(this);
        }
    }
*/
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFloorTableName() {
        return floorTableName;
    }

    public void setFloorTableName(String floorTableName) {
        this.floorTableName = floorTableName;
    }

    public List<BillItem> getListBillItem() {
        return listBillItem;
    }

    public void setListBillItem(List<BillItem> listBillItem) {
        this.listBillItem = listBillItem;
    }

    public String getKotNos() {
        return kotNos;
    }

    public void setKotNos(String kotNos) {
        this.kotNos = kotNos;
    }

    public String getSteward() {
        return steward;
    }

    public void setSteward(String steward) {
        this.steward = steward;
    }

    public Integer getCovers() {
        return covers;
    }

    public void setCovers(Integer covers) {
        this.covers = covers;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getBillGenUserId() {
        return billGenUserId;
    }

    public void setBillGenUserId(String billGenUserId) {
        this.billGenUserId = billGenUserId;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(Double netAmount) {
        this.netAmount = netAmount;
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

    public String getStrBillDate() {
        return strBillDate;
    }

    public void setStrBillDate(String strBillDate) {
        this.strBillDate = strBillDate;
    }

    public Double getGst12TaxAmt() {
        return gst12TaxAmt;
    }

    public void setGst12TaxAmt(Double gst12TaxAmt) {
        this.gst12TaxAmt = gst12TaxAmt;
    }

}
