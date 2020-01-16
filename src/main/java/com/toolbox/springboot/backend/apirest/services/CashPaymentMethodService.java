package com.toolbox.springboot.backend.apirest.services;

import com.toolbox.springboot.backend.apirest.model.entity.CashPaymentMethod;

public interface CashPaymentMethodService {

	public CashPaymentMethod save(CashPaymentMethod method);
	
	public void delete(Long id);
}
