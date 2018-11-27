package com.cruds.pos.db;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.Tax;


@Repository
@Transactional
public class TaxDaoHbrImpl implements TaxDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addTax(Tax tax) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(tax);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}
	
	public List<Tax> getAllActiveTax() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM Tax where status=:status";
		Query query = session.createQuery(hql); 
		query.setParameter("status", "Active");
		List<Tax> results = query.list();
		tx.commit();
		session.close();
		return results;
		
	}
	
	public List<Tax> getAllTax() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM Tax";
		Query query = session.createQuery(hql); 
		List<Tax> results = query.list();
		tx.commit();
		session.close();
		return results;
		
	}

	@Override
	public boolean setInactive(int id, LocalDate endDate) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		
		String hql = "UPDATE Tax set status='Inactive',endDate=:endDate where tax_id=:id"; 
		Query query = session.createQuery(hql); 
		query.setParameter("endDate", endDate);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public List<Tax> getAllTaxList() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM Tax where status=:status";
		Query query = session.createQuery(hql); 
		query.setParameter("status", "Active");
		List<Tax> results = query.list();
		tx.commit();
		session.close();
		return results;
	}

	@Override
	public Tax getTaxObject(String name) {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM Tax where name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", name);
		Tax results = (Tax) query.uniqueResult();
		if(results != null)
		{
			System.out.println(results);
		}
		tx.commit();
		session.close();
		return results;
	}
	
	
	
	
	
	
	

}
