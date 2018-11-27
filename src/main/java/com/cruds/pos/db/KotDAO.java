package com.cruds.pos.db;

import java.util.List;

import com.cruds.pos.entity.KOT;
import com.cruds.pos.entity.KOTItem;
import com.cruds.pos.entity.TableSitting;

public interface KotDAO {
	public boolean addKot(KOT kot,TableSitting tb,List<KOTItem> kotitem);

}
