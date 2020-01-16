package com.toolbox.springboot.backend.apirest.services;

import com.toolbox.springboot.backend.apirest.model.entity.CardMethod;

public interface CardPaymentMethodService {
	
	public CardMethod save(CardMethod card);
	
	public void delete(Long id);
}
