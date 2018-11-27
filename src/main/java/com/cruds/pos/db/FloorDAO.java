package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.Floor;
import com.cruds.pos.entity.FloorTable;
import com.cruds.pos.entity.MenuMaster;

public interface FloorDAO 
{
public boolean createfloor(String name, Long estId);
public List<Floor> getAllfloor(Long estId);
public boolean createTable(String tableName, Long floorId, int maxCap);
public List<FloorTable> getAlltable(Long estId);
public List<FloorTable> getAlltableid(Long estId);
public List<FloorTable> getAllOpenTable(Long estId);
public List<FloorTable> getAllActiveTable(Long estId);
public List<Establishment> getmenumastername(Long estId) ;
public Long getmenumasterid(String menumastername);
public boolean changetorunningstatus(Long id);
}
