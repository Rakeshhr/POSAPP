package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.MenuMaster;

public interface EstablishmentDAO 
{
public boolean createEstablishment(String name,Long mmId);
public List<Establishment> getAllEstablishment();

}
