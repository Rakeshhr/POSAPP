package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.L3Menu;

public interface L3MenuDao {
	public boolean createL3menu(String name,Long l2mmId,Double price,Long taxId);
	public List<L3Menu> getAllL3menuList();
	public List<L3Menu> getAllL3menuList(Long mmId);
	public List<L3Menu> getL3menuListByid(Long mmId);
}
