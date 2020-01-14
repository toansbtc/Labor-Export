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

import com.toan.model.login;

@Service
public class UserServiceIm implements UserService {
	@Autowired
	SessionFactory factory;
	@Transactional
	public List<login> getuser() {
		Session session = factory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<login> cq = cb.createQuery(login.class);
		Root<login> root = cq.from(login.class);
		cq.select(root);

		Query<login> query = session.createQuery(cq);
		return query.getResultList();
	}

}
