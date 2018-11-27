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
import com.cruds.pos.entity.Tax;

@Repository
@Transactional
public class L2MenuDaoHbrImpl implements L2MenuDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createL2menu(String name,Long l1mmId,Double price,Long taxId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		L1Menu mm = session.load(L1Menu.class, l1mmId);
		Tax dbTax = null;
		if(taxId != null)
		{
			dbTax = session.load(Tax.class, taxId);
		}
		
		L2Menu l2Menu = new L2Menu(name, mm,price, dbTax);
		session.saveOrUpdate(l2Menu);
		
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}
	
	@Override
	public List<L2Menu> getAllL2menuList() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
	
		String hql = "FROM L2Menu";
		Query query = session.createQuery(hql);
		List<L2Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	@Override
	public List<L2Menu> getAllL2menuList(Long mmId) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		L1Menu mm = session.load(L1Menu.class, mmId);
		String hql = "FROM L2Menu where l1Menu=:l1Menu";
		Query query = session.createQuery(hql);
		query.setParameter("l1Menu", mm);
		List<L2Menu> results = query.list();
		tx.commit();
		session.close();
		return results;
	}

}
