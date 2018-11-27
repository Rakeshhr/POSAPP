package com.cruds.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.pos.db.FloorDAO;
import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.Floor;
import com.cruds.pos.entity.FloorTable;
import com.cruds.pos.entity.MenuMaster;
@Service
public class FloorService
{
	@Autowired
	FloorDAO fdao;
	
	public boolean createFloor(String name, Long estId)
	{
		return fdao.createfloor(name, estId);
	}
	public List<Floor> getAllfloor(Long estId)
	{
		return fdao.getAllfloor(estId);
	}
	
	public boolean createFloorTable(String tableName, Long floorId, int maxCap)
	{
		return fdao.createTable(tableName, floorId, maxCap);
	}
	public List<FloorTable> getAlltable(Long estId)
	{
		return fdao.getAlltable(estId);
	}
	public List<FloorTable> getAlltableid(Long estId)
	{
		return fdao.getAlltableid(estId);
	}
	public List<FloorTable> getAllOpenTable(Long estId)
	{
		return fdao.getAllOpenTable(estId);
	}
	public List<FloorTable> getAllActiveTable(Long estId)
	{
		return fdao.getAllActiveTable(estId);
	}
	public List<Establishment> getmenumastername(Long estId)
	{
		return fdao.getmenumastername(estId);
	}
	public Long getmenumasterid(String estId)
	{
		return fdao.getmenumasterid(estId);
	}
	public Boolean changetorunningstatus(Long id)
	{
		return fdao.changetorunningstatus(id);
	}
}
