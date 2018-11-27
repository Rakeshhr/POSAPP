package com.cruds.pos.db;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.L1Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;

@Repository
@Transactional
public class L1MenuDaoHbrImpl implements L1MenuDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createL1menu(String name,Long mmId,Long taxId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		MenuMaster mm = session.load(MenuMaster.class, mmId);
		Tax dbTax = null;
		if(taxId!=null)
		{
		dbTax = session.load(Tax.class, taxId);
		}
		L1Menu l1Menu = new L1Menu(name, mm, dbTax);
		session.saveOrUpdate(l1Menu);
		
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}

	@Override
	public List<L1Menu> getAllL1menu() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM L1Menu";
		Query query = session.createQuery(hql); 
		List<L1Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	@Override
	public List<L1Menu> getAllL1menuList(Long mmId) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		MenuMaster mm = session.load(MenuMaster.class, mmId);
		String hql = "FROM L1Menu where menumaster=:menumaster";
		Query query = session.createQuery(hql);
		query.setParameter("menumaster", mm);
		List<L1Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	
	
	

}
