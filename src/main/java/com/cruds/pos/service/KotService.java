package com.cruds.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.pos.db.KotDAO;
import com.cruds.pos.entity.KOT;
import com.cruds.pos.entity.KOTItem;
import com.cruds.pos.entity.TableSitting;

@Service
public class KotService {
	@Autowired
	KotDAO Kotdao;
	public boolean createKot(KOT kot,TableSitting tb,List<KOTItem> kotitem)
	{
		return Kotdao.addKot(kot,tb,kotitem);
	}
	

}
