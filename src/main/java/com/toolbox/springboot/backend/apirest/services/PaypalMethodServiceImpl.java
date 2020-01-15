package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.toolbox.springboot.backend.apirest.dao.DAOPaypalMethod;
import com.toolbox.springboot.backend.apirest.model.entity.PaypalMethod;

public class PaypalMethodServiceImpl implements PaypalMethodService {

	@Autowired
	private DAOPaypalMethod daopaypal;
	
	@Override
	public PaypalMethod save(PaypalMethod method) {
		return daopaypal.save(method);
	}

	@Override
	public void delete(Long id) {
		daopaypal.deleteById(id);
		
	}

	
}
