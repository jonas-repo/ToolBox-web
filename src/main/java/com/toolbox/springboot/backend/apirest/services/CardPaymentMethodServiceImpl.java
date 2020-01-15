package com.toolbox.springboot.backend.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toolbox.springboot.backend.apirest.dao.DAOCardPaymentMethod;
import com.toolbox.springboot.backend.apirest.model.entity.CardMethod;

@Service
public class CardPaymentMethodServiceImpl implements CardPaymentMethodService {

	@Autowired
	private DAOCardPaymentMethod daocardmethod;

	@Override
	public CardMethod save(CardMethod card) {
		
		return daocardmethod.save(card);
	}

	@Override
	public void delete(Long id) {
		daocardmethod.deleteById(id);
	}	
	
}
