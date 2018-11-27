/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cruds.pos.entity;

import com.cruds.pos.util.POSConstant;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tax")
public class Tax implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tax_id")    
    private Long id;

    @Column(name = "tax_name")
    private String name;
    
    @Column(name="tax_rate")
    private Double rate;
    
    @Column(name="tax_type")
    private String taxType;
    
    @Column(name="status")
    private String status;
    
    @Basic
    @Column
    private LocalDate startDate;

    @Basic
    @Column
    private LocalDate endDate;    

    public Tax() {
       
    }

    public Tax(String name, Double rate,LocalDate startDate) {
        this.startDate = startDate;
        this.status = POSConstant.ACTIVE_STATUS;
        this.name = name;
        this.rate = rate;
    }
    
    
    public Tax(String tax) {
		// TODO Auto-generated constructor stub
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
	public String toString() {
		return "Tax [id=" + id + ", name=" + name + ", rate=" + rate + ", taxType=" + taxType + ", status=" + status
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Tax other = (Tax) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
