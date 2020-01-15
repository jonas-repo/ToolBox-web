package com.toolbox.springboot.backend.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.toolbox.springboot.backend.apirest.model.entity.UserGeneral;

import com.toolbox.springboot.backend.apirest.model.entity.CardMethod;
import com.toolbox.springboot.backend.apirest.services.CardPaymentMethodService;

@CrossOrigin(origins = {"http://localhost:3306"})
@RestController
@RequestMapping("/profile/{id}")
public class CardPaymentMethodRestController {

	@Autowired
	private CardPaymentMethodService cardservice;
	
	@PostMapping("/profile/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public CardMethod crate(@RequestBody CardMethod card) {
		return cardservice.save(card);
	}
	
	@PostMapping("/profile/{id}")
	public void delete(@RequestBody CardMethod card, @PathVariable Long id) {
		cardservice.delete(id);
	}
	
	
	
	
	
}
