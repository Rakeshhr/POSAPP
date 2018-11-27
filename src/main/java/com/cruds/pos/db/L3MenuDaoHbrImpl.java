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
import com.cruds.pos.entity.L2Menu;
import com.cruds.pos.entity.L3Menu;
import com.cruds.pos.entity.MenuMaster;
import com.cruds.pos.entity.Tax;

@Repository
@Transactional
public class L3MenuDaoHbrImpl implements L3MenuDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createL3menu(String name,Long l2mmId,Double price,Long taxId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		L2Menu l2mm = session.load(L2Menu.class, l2mmId);
		Tax dbTax = session.load(Tax.class, taxId);
		L3Menu l3Menu = new L3Menu(name, l2mm,price, dbTax);
		session.saveOrUpdate(l3Menu);
		
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}
	
	@Override
	public List<L3Menu> getAllL3menuList() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
	
		String hql = "FROM L3Menu";
		Query query = session.createQuery(hql);
		List<L3Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public List<L3Menu> getAllL3menuList(Long mmId) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		L2Menu mm = session.load(L2Menu.class, mmId);
		String hql = "FROM L3Menu where l2Menu=:l2Menu";
		Query query = session.createQuery(hql);
		query.setParameter("l2Menu", mm);
		List<L3Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public List<L3Menu> getL3menuListByid(Long mmId) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		String hql = "FROM L3Menu where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", mmId);
		List<L3Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	


}
