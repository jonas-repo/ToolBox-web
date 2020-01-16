package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolbox.springboot.backend.apirest.dao.DAOCashPaymentMethod;
import com.toolbox.springboot.backend.apirest.model.entity.CashPaymentMethod;

@Service
public class CashPaymentMethodServiceImpl implements CashPaymentMethodService {

	@Autowired
	private DAOCashPaymentMethod daocashmethod;
	
	@Override
	public CashPaymentMethod save(CashPaymentMethod method) {
		return daocashmethod.save(method);
	}

	@Override
	public void delete(Long id) {
		daocashmethod.deleteById(id);
	}

}
