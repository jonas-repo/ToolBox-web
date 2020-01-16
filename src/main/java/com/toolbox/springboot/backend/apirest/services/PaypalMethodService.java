package com.toolbox.springboot.backend.apirest.services;

import com.toolbox.springboot.backend.apirest.model.entity.PaypalMethod;

public interface PaypalMethodService {

	public PaypalMethod save(PaypalMethod paypal);
	
	public void delete(Long id);
	
}
