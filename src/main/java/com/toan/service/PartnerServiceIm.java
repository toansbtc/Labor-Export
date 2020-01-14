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

import com.toan.model.Partner;

@Service
public class PartnerServiceIm implements PartnerService {
	@Autowired
	SessionFactory sessionfactory;
	@Transactional
	public void insert(Partner partner) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().save(partner);

		
	}
	@Transactional
	public void update(Partner partner) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().update(partner);

	}
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		 sessionfactory.getCurrentSession().delete(getpartner(id));

		
	}
	@Transactional
	public List<Partner> getlistPartners() {
		// TODO Auto-generated method stub
		Session session = sessionfactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Partner> cq = cb.createQuery(Partner.class);
		Root<Partner> root = cq.from(Partner.class);
		cq.select(root);

		Query<Partner> query = session.createQuery(cq);
		return query.getResultList();
	}
	@Transactional
	public Partner getpartner(int id) {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().byId(Partner.class).load(id);

	}

}
