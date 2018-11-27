package com.cruds.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.pos.db.L1MenuDao;
import com.cruds.pos.db.L2MenuDao;
import com.cruds.pos.db.L3MenuDao;
import com.cruds.pos.entity.L1Menu;
import com.cruds.pos.entity.L2Menu;
import com.cruds.pos.entity.L3Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;
import com.cruds.pos.formbean.L1FormBean;
import com.cruds.pos.formbean.L2FormBean;
import com.cruds.pos.formbean.L3FormBean;


@Service
public class L1MenuService {
	@Autowired
	L1MenuDao l1MenuDAO;
	
	@Autowired
	L2MenuDao l2MenuDAO;
	
	@Autowired
	L3MenuDao l3MenuDAO;
	
	public boolean createL1menu(L1FormBean l1formbean,Long mmId)
	{
		if(l1formbean.getTaxId()==0)
		{
			return l1MenuDAO.createL1menu(l1formbean.getL1MenuName(), mmId, null);
		}
		
		else
		{
			return l1MenuDAO.createL1menu(l1formbean.getL1MenuName(), mmId, l1formbean.getTaxId());
		}
		
		
	}
	
	public List<L1Menu> getAllL1menulist(Long mmId)
	{
		
		return l1MenuDAO.getAllL1menuList(mmId);
	}
	
	public List<L1Menu> getAllL1menuList(Long mmId)
	{
		return l1MenuDAO.getAllL1menuList(mmId);
	}
	
	@Deprecated
	public boolean createl2menu(String name,Long l1mmId,Double price,Long taxId)
	{
		return l2MenuDAO.createL2menu(name, l1mmId, price, taxId);
	}
	
	public boolean createl2menu(L2FormBean l2formBean,Long l1menuid)
	{
		if(l2formBean.getTaxId() == 0)
		{
			return l2MenuDAO.createL2menu(l2formBean.getL2MenuName(), l1menuid, l2formBean.getPrice(), null);
		}
		else
		{
			return l2MenuDAO.createL2menu(l2formBean.getL2MenuName(), l1menuid, l2formBean.getPrice(), l2formBean.getTaxId());

		}
		
		
	}
	
	public List<L2Menu> getAllL2menuList()
	{
		return l2MenuDAO.getAllL2menuList();
	}
	
	public List<L2Menu> getAllL2menuList(Long mmId)
	{
		return l2MenuDAO.getAllL2menuList(mmId);
	}
	
	public boolean createl3menu(L3FormBean l3formBean,Long l2mmid)
	{
		return l3MenuDAO.createL3menu(l3formBean.getL3MenuName(), l2mmid, l3formBean.getPrice(), l3formBean.getTaxId());
	}
	
	public List<L3Menu> getAllL3menuList()
	{
		return l3MenuDAO.getAllL3menuList();
	}
	
	public List<L3Menu> getAllL3menuList(Long mmId)
	{
		return l3MenuDAO.getAllL3menuList(mmId);
	}
	public List<L3Menu> getL3menuListByid(Long mmId)
	{
		return l3MenuDAO.getL3menuListByid(mmId);
	}
}
