package com.toolbox.springboot.backend.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.toolbox.springboot.backend.apirest.dao.DAOCardPaymentMethod;
import com.toolbox.springboot.backend.apirest.model.entity.CardMethod;

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
