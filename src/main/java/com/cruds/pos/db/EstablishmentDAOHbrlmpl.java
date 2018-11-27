package com.cruds.pos.db;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.MenuMaster;
@Repository
@Transactional
public class EstablishmentDAOHbrlmpl implements EstablishmentDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createEstablishment(String name,Long mmId) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		MenuMaster mm = session.load(MenuMaster.class, mmId);
		Establishment establishment = new Establishment(name, mm);
		session.saveOrUpdate(establishment);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO CreateEstablishment");
		return true;
		
	}

	@Override
	public List<Establishment> getAllEstablishment() {
		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "FROM Establishment";
		Query query = session.createQuery(hql); 
		List<Establishment> results = query.list();
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Get all Establishment done!!!!");
		return results;
	
	}
	public List<String> getAllEstablishmentname() {
		
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();
		String hql = "Select name FROM Establishment";
		Query query = session.createQuery(hql); 
		List<String> results = query.list();
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Get all Establishment done!!!!");
		return results;
	
	}
	
}
