package com.cruds.pos.db;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.KOT;
import com.cruds.pos.entity.KOTItem;
import com.cruds.pos.entity.TableSitting;
import com.cruds.pos.entity.Tax;
@Repository
@Transactional
public class KOTDAOHbrImpl implements KotDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addKot(KOT kot,TableSitting tableSitting,List<KOTItem> kotitem) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(tableSitting);
		kot.setTableSitting(tableSitting);
		kot.addKOTItemList(kotitem);
		session.save(kot);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}

}
