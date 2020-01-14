package com.toan.service;

import java.util.List;

import com.toan.model.Partner;

public interface PartnerService {
	void insert(Partner partner);
	void update(Partner partner);
	void delete(int id);
	List<Partner> getlistPartners();
	Partner getpartner(int id);
}
