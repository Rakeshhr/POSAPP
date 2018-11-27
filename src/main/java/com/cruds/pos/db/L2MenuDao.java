package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.L2Menu;

public interface L2MenuDao {
	public boolean createL2menu(String name,Long l1mmId,Double price,Long taxId);
	public List<L2Menu> getAllL2menuList();
	public List<L2Menu> getAllL2menuList(Long mmId);
}
