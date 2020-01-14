package com.toan.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toan.model.labor;

@Service
public class LaborServiceIm implements LaborService {
	@Autowired
	SessionFactory sessionfactory;

	@Transactional
	public void insert(labor labor) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(labor);
		
	}
	@Transactional
	public void update(labor labor) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().update(labor);

		
	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session currentSession = sessionfactory.getCurrentSession();
		currentSession.delete(getLabor(id));	
		
	}
	@Transactional
	public List<labor> getlistlabor() {
		Session session = sessionfactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<labor> cq = cb.createQuery(labor.class);
		Root<labor> root = cq.from(labor.class);
		cq.select(root);

		Query<labor> query = session.createQuery(cq);
		return query.getResultList();
	}
	@Transactional
	public labor getLabor(int id) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().byId(labor.class).load(id);
	}
	
}
