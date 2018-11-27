package com.cruds.pos.db;

import java.time.LocalDate;
import java.util.List;

import com.cruds.pos.entity.Tax;

public interface TaxDao {

	public boolean addTax(Tax tax);
	public List<Tax> getAllActiveTax();
	public List<Tax> getAllTax();
	public List<Tax> getAllTaxList();
	public boolean setInactive(int id,LocalDate endDate);
	public Tax getTaxObject(String name);
}
