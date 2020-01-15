package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.toolbox.springboot.backend.apirest.dao.DAOUserPaymentMethods;
import com.toolbox.springboot.backend.apirest.model.entity.UserPaymentMethods;

public class UserPaymentMethodsServiceImpl implements UserPaymentMethodsService{

	@Autowired
	private DAOUserPaymentMethods daopaymentmethods;
	
	@Override
	public UserPaymentMethods findById(Long id) {
		return daopaymentmethods.findById(id).orElse(null);
	}

	@Override
	public UserPaymentMethods save(UserPaymentMethods paymentMethod) {
		return daopaymentmethods.save(paymentMethod);
	}

	@Override
	public void delete(Long id) {
		daopaymentmethods.deleteById(id);;
	}

}
