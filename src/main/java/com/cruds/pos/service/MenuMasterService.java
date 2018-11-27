package com.cruds.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.pos.db.MenuMasterDao;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;


@Service
public class MenuMasterService {
	
	@Autowired
	MenuMasterDao dao;
	
	public boolean createmenumaster(MenuMaster menu)
	{
		return dao.createMenuMaster(menu);
	}
	
	public List<MenuMaster> getAllMenu()
	{
		
		return dao.getAllMenu();
	}
	
	public List<MenuMaster> getAllMenuName()
	{
		
		return dao.getAllMenuName();
	}
}
