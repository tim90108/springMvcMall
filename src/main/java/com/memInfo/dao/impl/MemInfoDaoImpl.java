package com.memInfo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.memInfo.bean.MemInfo;
import com.memInfo.dao.MemInfoDao;

@Repository
public class MemInfoDaoImpl implements MemInfoDao{
	
//	有多個sessionFactory 可以用Resource來指定
//	@Resource(name = "sessionFactory") 
//	private SessionFactory sessionFactory;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public MemInfo findById(Integer id) {
		String sql = "select ID, ACCOUNT, PASSWORD, NAME,"
				+ " SEX, EMAIL from MEM_INFO where id = :id";
		
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(MemInfo.class);
		
		query.setParameter("id", id);
		
		return (MemInfo) query.getSingleResult();
	}

	@Override
	@Transactional
	public List<MemInfo> findAll() {
		String sql = "select ID, ACCOUNT, PASSWORD, NAME,"
				+ " SEX, EMAIL from MEM_INFO";
		
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(MemInfo.class);
		
		@SuppressWarnings("unchecked")
		List<MemInfo> resultList = query.getResultList();
		
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int update(MemInfo memInfo) {
		String sql = "UPDATE MEM_INFO SET NAME = :name ,"
				+ " SEX = :sex ,"
				+ " EMAIL = :email WHERE  id = :id";
		
		Transaction transaction = null;
		int result = -1;
		
		try {
	        Session session = sessionFactory.getCurrentSession();
	        
	        Query<MemInfo> query = session.createSQLQuery(sql);
	        
	        query.setParameter("id", memInfo.getId());
	        query.setParameter("name", memInfo.getName());
	        query.setParameter("sex", memInfo.getSex());
	        query.setParameter("email", memInfo.getEmail());
	        
	        result = query.executeUpdate();
	        
	        transaction = session.getTransaction();
		 } catch (Exception ex) {
		        ex.printStackTrace();
		        if (transaction != null) {
		            transaction.rollback();
		        }
		 }
		return result;
	}
	
}
