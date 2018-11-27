package com.cruds.pos.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cruds.pos.entity.User;



@Repository
@Transactional
public class UserDAOHbrImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean create(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		System.out.println("Hibernate DAO Create user Method");
		return true;
	}

	@Override
	public String authenticateUser(String firstName, String password) {
		String sql = "select user_role from user where user_name=? and password=? ";
		String type=null;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,firstName);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null &&  rs.next()){
				
				type = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		System.out.println("User Type:"  + type);
		
		return type; 
	}

	public List<User> getAllUser() {
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		String hql = "FROM User U"; 
		Query query = session.createQuery(hql); 
		List<User> results = query.list();

		tx.commit();
		session.close();
		return results;
		
	}
	
	
	
	
}
