package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.L1Menu;

public interface L1MenuDao {

	public boolean createL1menu(String name,Long mmId,Long taxId);
	public List<L1Menu> getAllL1menu();
	public List<L1Menu> getAllL1menuList(Long mmId);
}
