package com.cruds.pos.db;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.Establishment;
import com.cruds.pos.entity.Floor;
import com.cruds.pos.entity.FloorTable;
import com.cruds.pos.entity.L1Menu;
import com.cruds.pos.entity.L2Menu;
import com.cruds.pos.entity.MenuMaster;


@Repository
@Transactional
public class FloorDAOHbrlmpl implements FloorDAO
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createfloor(String name,Long estId) 
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    Establishment mm = session.load(Establishment.class, estId);
		Floor floor = new Floor(name, mm);
		session.saveOrUpdate(floor);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create Floor");
		return true;
		
	}

	@Override
	public List<Floor> getAllfloor(Long estId) {
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();
		Establishment est = session.load(Establishment.class, estId);
		Hibernate.initialize(est.getListFloor());
		//String hql = "SELECT id,name FROM Floor where establishment=:establishment";
		//Query query = session.createQuery(hql); 
		//query.setParameter("establishment", est);
		//List<Floor> results = (List<Floor>) query.list();
		//tx.commit();
		session.close();
		return est.getListFloor();
	}

	@Override
	public boolean createTable(String tableName, Long floorId, int maxCap)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Floor floor = session.load(Floor.class, floorId);
		FloorTable floorTable = new FloorTable(tableName, floor, maxCap);
		session.saveOrUpdate(floorTable);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create TABLE Successfully");
		return true;
	
	}
	@Override
	public List<FloorTable> getAlltable(Long estId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		Floor mm = session.load(Floor.class, estId);
		String hql = "FROM FloorTable where floor=:floor";
		Query query = session.createQuery(hql);
		query.setParameter("floor", mm);
		List<FloorTable> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	public List<FloorTable> getAlltableid(Long estId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		Floor mm = session.load(Floor.class, estId);
		String hql = "SELECT id FROM FloorTable where floor=:floor";
		Query query = session.createQuery(hql);
		query.setParameter("floor", mm);
		List<FloorTable> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public List<FloorTable> getAllOpenTable(Long estId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		Floor mm = session.load(Floor.class, estId);
		String hql = "FROM FloorTable where floor=:floor and status=:status";
		Query query = session.createQuery(hql);
		query.setParameter("floor", mm);
		query.setParameter("status", "Inactive");
		List<FloorTable> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public List<FloorTable> getAllActiveTable(Long estId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		Floor mm = session.load(Floor.class, estId);
		String hql = "FROM FloorTable where floor=:floor and status=:status";
		Query query = session.createQuery(hql);
		query.setParameter("floor", mm);
		query.setParameter("status", "Active");
		List<FloorTable> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public List<Establishment> getmenumastername(Long estId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		String hql = "FROM Establishment where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", estId);
		List<Establishment> results = query.list();
		tx.commit();
		session.close();
		return results;
	}
	
	public Long getmenumasterid(String menumastername) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		String hql = "SELECT id FROM MenuMaster where name=:name";
		Query query = session.createQuery(hql);
		query.setParameter("name", menumastername);
		Long results = (Long) query.uniqueResult();
		tx.commit();
		session.close();
		return results;
	}
	
	public boolean changetorunningstatus(Long id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE FloorTable set status='running' where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return true;
	}
	
}
