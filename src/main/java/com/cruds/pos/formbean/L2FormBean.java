package com.cruds.pos.formbean;

public class L2FormBean {
	
	private String l2MenuName;
	private Double price;
	private Long l1mmId;
	private Long taxId;
	
	
	public L2FormBean() {
		super();
	}

	public L2FormBean(String l2MenuName, Double price, Long l1mmId, Long taxId) {
		super();
		this.l2MenuName = l2MenuName;
		this.price = price;
		this.taxId = taxId;
	}
	
	public String getL2MenuName() {
		return l2MenuName;
	}
	public void setL2MenuName(String l2MenuName) {
		this.l2MenuName = l2MenuName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Long getTaxId() {
		return taxId;
	}
	public void setTaxId(Long taxId) {
		this.taxId = taxId;
	}

	public Long getL1mmId() {
		return l1mmId;
	}

	public void setL1mmId(Long l1mmId) {
		this.l1mmId = l1mmId;
	}
	

	
	
}
