package com.cruds.pos.db;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;


@Repository
@Transactional
public class MenuMasterDaoHbrImpl implements MenuMasterDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createMenuMaster(MenuMaster menu) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(menu);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create Menu  Method");
		return true;
	}

	@Override
	public List<MenuMaster> getAllMenuName() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "SELECT name FROM MenuMaster ORDER BY id ASC";
		Query query = session.createQuery(hql); 
		List<MenuMaster> results = query.list();
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public List<MenuMaster> getAllMenu() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM MenuMaster ORDER BY id ASC";
		Query query = session.createQuery(hql); 
		List<MenuMaster> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	
	
	
	
	

}
