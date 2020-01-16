package com.toolbox.springboot.backend.apirest.services;

import com.toolbox.springboot.backend.apirest.model.entity.UserPaymentMethods;

public interface UserPaymentMethodsService {

	public UserPaymentMethods findById(Long id); 
	
	public UserPaymentMethods save(UserPaymentMethods paymentMethod);
	
	public void delete(Long id);
}
