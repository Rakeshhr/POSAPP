package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.MenuMaster;

public interface MenuMasterDao {
	
	public boolean createMenuMaster(MenuMaster menu);
	public List<MenuMaster> getAllMenu();
	public List<MenuMaster> getAllMenuName();

}
