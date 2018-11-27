package com.cruds.pos.entity;

public class FormBeanTax {
	
	private Long id;
    private String name;
    private Double rate;
    private String status;
    
    
	public FormBeanTax() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FormBeanTax(Long id, String name, Double rate, String status) {
		super();
		this.id = id;
		this.name = name;
		this.rate = rate;
		this.status = status;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    

}
