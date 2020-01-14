package com.toan.service;

import java.util.List;

import com.toan.model.labor;


public interface LaborService {
	abstract void insert(labor labor);
	void update(labor labor);
	void delete(int id);
	List<labor> getlistlabor();
	labor getLabor(int id);

}
